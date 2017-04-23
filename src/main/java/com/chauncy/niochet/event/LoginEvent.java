package com.chauncy.niochet.event;

import com.chauncy.niochet.entity.User;
import com.chauncy.nionetframework.entity.IoSession;

/**
 * 用户登陆时传送的event对象
 * Created by Chauncy on 2017/4/6.
 */
public class LoginEvent {
	/**
	 * 服务器会话
	 */
	private IoSession ioSession;
	/**
	 * 登录相关的用户信息
	 */
	private User user;

	////////////////////////////
	/// constructor
	///////////////////////////
	public LoginEvent() {
	}

	public LoginEvent(IoSession ioSession, User user) {
		this.ioSession = ioSession;
		this.user = user;
	}
	////////////////////////////
	/// getter and setter
	///////////////////////////
	public IoSession getIoSession() {
		return ioSession;
	}

	public void setIoSession(IoSession ioSession) {
		this.ioSession = ioSession;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LoginEvent{" +
				"ioSession=" + ioSession +
				", user=" + user +
				'}';
	}
}
