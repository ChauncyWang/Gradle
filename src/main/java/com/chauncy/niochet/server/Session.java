package com.chauncy.niochet.server;

import java.nio.channels.SocketChannel;

/**
 * 会话
 * Created by chauncy on 17-3-21.
 */
public class Session {
	private String ip;
	private int port;
	private SocketChannel socketChannel;
	private int state;

	public Session() {
	}

	public Session(String ip, int port, SocketChannel socketChannel, int state) {

		this.ip = ip;
		this.port = port;
		this.socketChannel = socketChannel;
		this.state = state;
	}

	public String getIp() {
		return ip;
	}

	public int getPort() {
		return port;
	}

	public SocketChannel getSocketChannel() {
		return socketChannel;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
