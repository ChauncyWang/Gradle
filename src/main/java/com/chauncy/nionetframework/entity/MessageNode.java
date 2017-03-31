package com.chauncy.nionetframework.entity;

/**
 * 消息队列的节点
 * Created by chauncy on 17-3-29.
 */
public class MessageNode {
	/**
	 * 消息来源ip
	 */
	private String ip;
	/**
	 * 消息来源的端口号
	 */
	private int port;
	/**
	 * 消息
	 */
	private NetMessage message;

	public MessageNode(String ip, int port, NetMessage message) {
		this.ip = ip;
		this.port = port;
		this.message = message;
	}

	public MessageNode(String ip, int port, NetMessageType type, Object obj) {
		this(ip, port, new NetMessage(type, obj));
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