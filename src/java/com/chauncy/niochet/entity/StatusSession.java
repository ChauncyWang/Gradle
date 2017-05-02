package com.chauncy.niochet.entity;

import com.chauncy.nionetframework.entity.IoSession;

import java.nio.channels.SocketChannel;

/**
 * 会话,记录连接到服务器的ip,port所对应的socket channel
 * 并且记录下 该socket channel所对应的user
 * 以及状态
 * Created by chauncy on 17-3-21.
 */
public class StatusSession extends IoSession {
	/**
	 * 登录的用户,没有登录用户则为空
	 */
	private UserInfo user;
	/**
	 * 用户状态
	 */
	private UserStatus status;

	public StatusSession() {
		super();
		//没有用户
		this.user = null;
		//状态为未登录
		this.status = UserStatus.WITHOUT_LOGIN;
	}

	public StatusSession(String ip, int port, SocketChannel socketChannel) {
		super(ip, port, socketChannel);
		//没有用户
		this.user = null;
		//状态为未登录
		this.status = UserStatus.WITHOUT_LOGIN;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}
}
