package com.chauncy.niochet.server;

import com.chauncy.niochet.server.actions.MessageActions;
import com.chauncy.nionetframework.NIOServer;
import com.chauncy.nionetframework.entity.MessageNode;
import org.apache.log4j.Logger;

/**
 * 消息处理线程
 * Created by Chauncy on 2017/4/4.
 */
public class MessageHandleThread implements Runnable {
	private static Logger logger = Logger.getLogger(MessageHandleThread.class);
	/**
	 * nio套接字
	 */
	private NIOServer nioNet;
	/**
	 * 消息处理的集合
	 */
	private MessageActions actions = new MessageActions();

	public MessageHandleThread(NIOServer nioNet) {
		this.nioNet = nioNet;
	}

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		logger.info(thread.getName() + "启动...");
		while (!thread.isInterrupted()) {
			MessageNode messageNode = nioNet.getMq().removeToRMQ();
			if (messageNode != null) {
				nioNet.getMq().addToWMQ(
						actions.getAction(messageNode.getMessage().what).execute(messageNode));
			}
		}
		logger.info(thread.getName() + "结束!");
	}
}
