package com.chauncy.niochet.server;

import com.chauncy.niochet.util.NetMessage;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 消息队列
 * Created by chauncy on 17-3-19.
 */
public class MessageQueue {
	private ConcurrentLinkedQueue<Node> messages;
	public MessageQueue() {
		messages = new ConcurrentLinkedQueue<>();
	}
	public synchronized Node dequeue() {
		return messages.remove();
	}
	public synchronized void enqueue(Node node) {
		messages.add(node);
	}
}
class Node{
	private String ip;
	private int port;
	private NetMessage message;

	public Node(String ip, int port, NetMessage message) {
		this.ip = ip;
		this.port = port;
		this.message = message;
	}

	public String getIp() {
		return ip;
	}

	public int getPort() {
		return port;
	}

	public NetMessage getMessage() {
		return message;
	}
}