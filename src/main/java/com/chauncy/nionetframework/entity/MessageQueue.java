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
		logger.debug(String.format("MQ[%d] 添加一条消息[%s:%d]",
				size(), message.getIp(), message.getPort()));
		return b;
	}

	/**
	 * 从
	 * @return
	 */
	public synchronized MessageNode removeMsg() {
		return super.poll();
	}
}