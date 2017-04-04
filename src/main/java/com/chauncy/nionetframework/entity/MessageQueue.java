package com.chauncy.nionetframework.entity;

import org.apache.log4j.Logger;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 消息队列 (原子操作)
 * Created by chauncy on 17-3-19.
 */
public class MessageQueue extends ConcurrentLinkedQueue<MessageNode> {
	private static Logger logger = Logger.getLogger(MessageQueue.class);
	/**
	 * 消息队列的名字
	 */
	private String name;

	public MessageQueue(String name) {
		super();
		this.name = name;
	}

	/**
	 * 向消息队列添加 消息
	 *
	 * @param message 待添加的消息
	 */
	public synchronized boolean addMsg(MessageNode message) {
		boolean b = super.offer(message);
		logger.debug(String.format("%s:MQ[%d] 添加一条消息[%s:%d]",
				name, size(), message.getIp(), message.getPort()));
		return b;
	}

	/**
	 * 从MQ中 出队 一个节点
	 *
	 * @return 出队的节点
	 */
	public synchronized MessageNode removeMsg() {
		MessageNode messageNode = super.poll();
		String log;
		if (messageNode != null) {
			log = String.format("%s:MQ[%d] 取出一条消息[%s:%d]",
					name, size(), messageNode.getIp(), messageNode.getPort());

			logger.debug(log);
		}

		return messageNode;
	}
}