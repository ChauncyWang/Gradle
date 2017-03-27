package com.chauncy.mychet.net;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 * the network send message tool
 * Created by chauncy on 17-3-17.
 */
public class SendTool {
	private Logger logger = Logger.getLogger(SendTool.class);
	private ObjectOutputStream oos;

	public SendTool(ObjectOutputStream oos) {
		this.oos = oos;
	}

	public void sendMessage(NetMessage1 netMessage) throws IOException {
		if(netMessage != null) {
			oos.writeObject(netMessage);
			logger.debug("A network message is send...");
		}else {
			logger.debug("The message is null!");
		}
	}

}
