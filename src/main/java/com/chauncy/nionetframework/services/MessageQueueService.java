package com.chauncy.nionetframework.services;

import com.chauncy.nionetframework.action.IMessageActions;
import com.chauncy.nionetframework.entity.MessageNode;
import com.chauncy.nionetframework.entity.MessageQueue;
import org.apache.log4j.Logger;

import java.rmi.UnexpectedException;

/**
 * 消息队列服务
 * Created by chauncy on 17-3-31.
 */
public class MessageQueueService implements Runnable {
	private static Logger logger = Logger.getLogger(MessageQueueService.class);
	/**
	 * 消息队列
	 */
	private volatile MessageQueue messageQueue;
	/**
	 * 处理消息的函数集合
	 */
	private IMessageActions actions;

	public MessageQueueService(IMessageActions actions) {
		if (actions == null)
			throw new RuntimeException("MQ Actions is null!");
		this.actions = actions;
		messageQueue = new MessageQueue();
	}

	@Override
	public void run() {
		//消息处理啊啊啊
		logger.info(Thread.currentThread().getName() + "开启...");
		while (!Thread.currentThread().isInterrupted()) {
			if (messageQueue.size() != 0) {
				try {
					MessageNode message = messageQueue.remove();
					logger.debug(String.format("MQ[%d] 取出一条消息[%s:%d] 交由处理器 处理",
							messageQueue.size(), message.getIp(), message.getPort()));
					MessageNode result =

							actions.getAction(message.getMessage().what).execute(message);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		logger.info(Thread.currentThread().getName() + "结束!");
	}

	/**
	 * 向消息队列添加 消息
	 *
	 * @param message 待添加的消息
	 */
	public synchronized void add(MessageNode message) {
		messageQueue.add(message);
		logger.debug(String.format("MQ[%d] 添加一条消息[%s:%d]",
				messageQueue.size(), message.getIp(), message.getPort()));
	}

	public MessageQueue getMessageQueue() {
		return messageQueue;
	}
}
