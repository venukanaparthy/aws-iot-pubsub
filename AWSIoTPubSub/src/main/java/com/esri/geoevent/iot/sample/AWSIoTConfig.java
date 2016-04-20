package com.esri.geoevent.iot.sample;

public class AWSIoTConfig {
	private String broker		= "A1OAECNIGB9KXE.iot.us-west-2.amazonaws.com";
	private String port 		= "8883";
	private String protocol 	= "ssl://";
	private String rootCA 		= "";
	private String privateKey 	= "";
	private String certificate  = "";
	private String url			= "";
	
	
	public String getBroker() {
		return broker;
	}
	public void setBroker(String broker) {
		this.broker = broker;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
	public String getRootCA() {
		return rootCA;
	}
	public void setRootCA(String rootCA) {
		this.rootCA = rootCA;
	}
	public String getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
		
	
}
