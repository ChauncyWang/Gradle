package com.chauncy.nionetframework.entity;

import java.nio.channels.SocketChannel;

/**
 * 会话,记录连接到服务器的ip,port所对应的socket channel
 * Created by chauncy on 17-3-21.
 */
public class IoSession {
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

	/**
	 * 附加信息，为不同的场合添加不同的附加信息
	 */
	private Object attach;


	public IoSession() {
	}

	public IoSession(String ip, int port, SocketChannel socketChannel) {
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

	public Object getAttach() {
		return attach;
	}

	public void setAttach(Object attach) {
		this.attach = attach;
	}

	@Override
	public String toString() {
		return "IoSession{" +
				"ip='" + ip + '\'' +
				", port=" + port +
				", socketChannel=" + socketChannel +
				", attach=" + attach +
				'}';
	}
}
