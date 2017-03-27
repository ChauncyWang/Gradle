package com.chauncy.niochet.server;

import org.apache.log4j.Logger;

/**
 * 消息处理线程
 * Created by chauncy on 17-3-19.
 */
public class MessageHandlerThread implements Runnable {
	private Logger logger = Logger.getLogger(MessageHandlerThread.class);
	private volatile SelectHandlerImpl dealHandler = null;

	public MessageHandlerThread(SelectHandlerImpl dealHandler) {
		this.dealHandler = dealHandler;
	}

	@Override
	public void run() {
		MessageQueue receives = dealHandler.getReceives();
		while (true) {
			try {
				Node node = receives.dequeue();

				logger.info(String.format("处理[%s:%d]的消息:[%s]", node.getIp(), node.getPort(), node.getMessage()));
			} catch (Exception e) {
				//logger.warn(e);
			}

		}
	}
}
