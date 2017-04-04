package com.chauncy.niochet.server;

import com.chauncy.niochet.server.actions.MessageActions;
import com.chauncy.nionetframework.NIONet;
import com.chauncy.nionetframework.entity.MessageNode;

/**
 * Created by Chauncy on 2017/4/4.
 */
public class MessageHandleThread implements Runnable {
	private NIONet nioNet;
	private MessageActions actions = new MessageActions();
	public MessageHandleThread(NIONet nioNet) {
		this.nioNet = nioNet;
	}

	@Override
	public void run() {
		while (true) {
			MessageNode messageNode = nioNet.getMessageQueueService().removeToRMQ();
			if(messageNode!=null) {
				actions.getAction(messageNode.getMessage().what).execute(messageNode);
			}
		}
	}
}
