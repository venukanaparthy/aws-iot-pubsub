package com.esri.geoevent.iot.sample;

public class AWSIoTNOOP extends AWSIoTBase implements AWSIoTCommand {

	public void execute(AWSIoTParams params) throws Exception {
		throw new Exception("NOOP");
	}
}
