package com.esri.geoevent.iot.sample;

public class Run {
	public static void main(String [] args) throws Exception{
		String mode = null;
		if (args.length < 2) {
			System.out.println("Usage: Run publish   topic  event-file");
			System.out.println("Usage: Run consume topic");
			return;
		}	
		
		mode = args[0];
		String topic = args[1];
		String eventsFile = null;
		
		if (args.length == 3){
			eventsFile = args[2];					
		}
		
		AWSIoTConfig awsConfig = ConfigLoader.loadConfig();
		//System.out.println(awsConfig.getUrl());
					
		AWSIoTParams params = new AWSIoTParams();
		params.setMessage("Hello AWS Iot"); //default message if no events file
		params.setTopic(topic);
		params.setQos(0);
		params.setAwsConfig(awsConfig);
		params.setEventsFile(eventsFile);
			
		AWSIoTFactory iotFactory = new AWSIoTFactory();
		AWSIoTCommand cmd = null;
		if (mode.equals("publish")) {
			cmd = iotFactory.create(AWSIOTClientType.PUBLISHER);			
		}else {
			cmd = iotFactory.create(AWSIOTClientType.SUBSCRIBER);	
		}	
		cmd.execute(params);
	}
}
