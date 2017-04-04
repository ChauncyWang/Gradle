package com.chauncy.nionetframework.services;

import com.chauncy.nionetframework.entity.MessageNode;
import com.chauncy.nionetframework.entity.MessageQueue;
import org.apache.log4j.Logger;

/**
 * 读 消息队列服务
 * Created by chauncy on 17-3-31.
 */
public class MessageQueueService {
	/**
	 * 消息队列--读取
	 */
	private volatile MessageQueue readMQ;
	/**
	 * 消息队列--写入
	 */
	private volatile MessageQueue writeMQ;

	public MessageQueueService() {
		readMQ = new MessageQueue("读取MQ");
		writeMQ = new MessageQueue("写入MQ");
	}

	/**
	 * 向读取队列添加消息
	 * @param messageNode 消息节点
	 */
	public synchronized void addToRMQ(MessageNode messageNode) {
		readMQ.addMsg(messageNode);
	}

	/**
	 * 向写入队列添加消息
	 * @param messageNode 消息节点
	 */
	public synchronized void addToWMQ(MessageNode messageNode) {
		writeMQ.addMsg(messageNode);
	}

	/**
	 * 从读取队列出队一个元素
	 * @return 出队的元素
	 */
	public synchronized MessageNode removeToRMQ() {
		return readMQ.removeMsg();
	}

	/**
	 * 从写入队列出队一个元素
	 * @return 出队的元素
	 */
	public synchronized MessageNode removeToWMQ() {
		return writeMQ.removeMsg();
	}

}
