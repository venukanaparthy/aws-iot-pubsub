package com.esri.geoevent.iot.sample;

public class AWSIoTFactory {
		
	public AWSIoTCommand create(AWSIOTClientType mode) {		
		AWSIoTCommand cmd = null;
		switch(mode){
			case PUBLISHER:
				cmd = new AWSIoTPublisher();	
				break;
			case SUBSCRIBER:
				cmd = new AWSIoTConsumer();
				break;
			default:
				cmd= new AWSIoTNOOP();
		}
		
		return cmd;
	}
}
