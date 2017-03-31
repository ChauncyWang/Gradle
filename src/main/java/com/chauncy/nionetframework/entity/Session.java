package com.chauncy.nionetframework.entity;

import java.nio.channels.SocketChannel;

/**
 * 会话,记录连接到服务器的ip,port所对应的socket channel
 * Created by chauncy on 17-3-21.
 */
public class Session {
	/**
	 * ip地址
	 */
	private String ip;
	/**
	 * 连接端口
	 */
	private int port;
	/**
	 * 套接字管道
	 */
	private SocketChannel socketChannel;

	public Session() {
	}

	public Session(String ip, int port, SocketChannel socketChannel) {
		this();
		this.ip = ip;
		this.port = port;
		this.socketChannel = socketChannel;
	}

	/// getter and setter
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public SocketChannel getSocketChannel() {
		return socketChannel;
	}

	public void setSocketChannel(SocketChannel socketChannel) {
		this.socketChannel = socketChannel;
	}
}
