package com.esri.geoevent.iot.sample;

import java.sql.Timestamp;
import java.util.Random;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class AWSIoTConsumer extends AWSIoTBase implements AWSIoTCommand {

	public void execute(AWSIoTParams params) throws Exception {
	
		
		 MqttClient consumer = new MqttClient(params.getAwsConfig().getUrl(),String.format("clientId %d", new Random().nextInt(100)), new MemoryPersistence());	            
		 consumer.setCallback(this);
         MqttConnectOptions connOpts = new MqttConnectOptions();
         //connOpts.setConnectionTimeout(10);
         //connOpts.setKeepAliveInterval(10);
         connOpts.setCleanSession(true);
         connOpts.setSocketFactory(SslUtil.getSocketFactory(params.getAwsConfig().getRootCA(), 
        		 params.getAwsConfig().getCertificate(),
        		 params.getAwsConfig().getPrivateKey(),"password"));
         
         System.out.println(String.format("Subscribing to broker %s: ", params.getAwsConfig().getUrl()));
         consumer.connect(connOpts);
         consumer.subscribe(params.getTopic());	            	         		
	}
	
	@Override
	public void messageArrived(String topic, MqttMessage message)
			throws Exception {
		String time = new Timestamp(System.currentTimeMillis()).toString();
	    System.out.println("=>Recieved at : " + time + "  ,Topic: " + topic + "  ,Message:"	+ new String(message.getPayload()));
	    System.out.println("");
	}


}
