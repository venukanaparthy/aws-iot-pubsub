package com.esri.geoevent.iot.sample;

import java.io.BufferedReader;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class AWSIoTPublisher extends  AWSIoTBase implements AWSIoTCommand  {
		
	 public void execute(AWSIoTParams params)  {
		 
		 if (params.getAwsConfig() != null) {
			
			 try
			 {				 			
				 MqttClient publisher = new MqttClient(params.getAwsConfig().getUrl(), String.format("pubid %d", new Random().nextInt(100)), new MemoryPersistence());         
				 MqttConnectOptions connOpts = new MqttConnectOptions();         
				 connOpts.setCleanSession(true);
				 connOpts.setSocketFactory(SslUtil.getSocketFactory(params.getAwsConfig().getRootCA(),
						 											params.getAwsConfig().getCertificate(), 
						 											params.getAwsConfig().getPrivateKey(),"password"));
				 publisher.connect(connOpts);
				 
				 MqttMessage mqttMessage = null;
				 System.out.println(String.format("Publishing to broker %s: ", params.getAwsConfig().getUrl()));
				 if (params.getEventsFile()!=null) {
					 String line = "";
					 Scanner scan = new Scanner(new File(params.getEventsFile()));
					    while(scan.hasNextLine()){
					        line = scan.nextLine();					        
					         System.out.println(String.format("Publishing %s ", line));
							 mqttMessage = new MqttMessage(line.getBytes());
							 mqttMessage.setQos(params.getQos());
							 publisher.publish(params.getTopic(), mqttMessage);
							 
					        //System.out.println(line);
					        Thread.sleep(1000);			
					        System.out.println("");
					    }					 
					 
				 } else {
					 System.out.println(String.format("Publishing %s ", params.getMessage()));
					 mqttMessage = new MqttMessage(params.getMessage().getBytes());
					 mqttMessage.setQos(params.getQos());
					 publisher.publish(params.getTopic(), mqttMessage);
				 }				 
				 
				 
				 
				 publisher.disconnect();
				 
			 } catch(MqttException mex) {
				 System.out.println("reason "+mex.getReasonCode());
		         System.out.println("msg "+mex.getMessage());
		         //System.out.println("cause "+mex.getCause());
		         //System.out.println("excep "+mex);
		         mex.printStackTrace();		         
		     } catch(Exception ex) {
		    	 ex.printStackTrace();
		     }
		}			
	}	
}
