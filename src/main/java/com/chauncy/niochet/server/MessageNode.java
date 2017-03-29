package com.chauncy.niochet.server;

import com.chauncy.niochet.entity.NetMessage;

/**
 * Created by chauncy on 17-3-29.
 */
public class MessageNode {
	private String ip;
	private int port;
	private NetMessage message;

	public MessageNode(String ip, int port, NetMessage message) {
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