package com.esri.geoevent.iot.sample;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
	
	public static AWSIoTConfig loadConfig() throws Exception{
		
		AWSIoTConfig _awsConfig = new AWSIoTConfig();
		
		ClassLoader classLoader = ConfigLoader.class.getClassLoader();
        InputStream input = classLoader.getResourceAsStream("credentials.properties");
		Properties properties = new Properties();
		properties.load(input);
		String endpoint = properties.getProperty("awsiot.endpoint");
		String rootCA = properties.getProperty("awsiot.rootCA");
		String privateKey = properties.getProperty("awsiot.privateKey");
		String certificate = properties.getProperty("awsiot.certificate");
		String protocol= properties.getProperty("awsiot.protocol");
		String port= properties.getProperty("awsiot.port");

		_awsConfig.setBroker(endpoint);
		_awsConfig.setProtocol(protocol);
		_awsConfig.setRootCA(rootCA);
		_awsConfig.setPrivateKey(privateKey);
		_awsConfig.setCertificate(certificate);
		_awsConfig.setUrl(String.format("%s%s:%s", protocol, endpoint, port));
				
		return _awsConfig;
		
	}
}
