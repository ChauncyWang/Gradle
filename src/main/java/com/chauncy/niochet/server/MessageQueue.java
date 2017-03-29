package com.chauncy.niochet.server;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 消息队列
 * Created by chauncy on 17-3-19.
 */
public class MessageQueue {
	private ConcurrentLinkedQueue<MessageNode> messages;
	public MessageQueue() {
		messages = new ConcurrentLinkedQueue<>();
	}
	public synchronized MessageNode dequeue() {
		return messages.remove();
	}
	public synchronized void enqueue(MessageNode node) {
		messages.add(node);
	}
}