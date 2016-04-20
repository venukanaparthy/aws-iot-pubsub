package com.esri.geoevent.iot.sample;


public class AWSIoTParams {

	private String message 			= null;
	private int qos					= 0;
	private String topic 			= null;
	private String eventsFile		= null;
	private AWSIoTConfig awsConfig     = null;
		
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getQos() {
		return qos;
	}
	public void setQos(int qos) {
		this.qos = qos;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public AWSIoTConfig getAwsConfig() {
		return awsConfig;
	}
	public void setAwsConfig(AWSIoTConfig awsConfig) {
		this.awsConfig = awsConfig;
	}
	public String getEventsFile() {
		return eventsFile;
	}
	public void setEventsFile(String eventsFile) {
		this.eventsFile = eventsFile;
	}
}
