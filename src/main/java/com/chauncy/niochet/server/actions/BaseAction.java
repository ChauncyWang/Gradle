package com.chauncy.niochet.server.actions;

import com.chauncy.niochet.entity.NetMessageType;
import com.chauncy.niochet.server.SessionFactory;
import com.chauncy.niochet.server.services.UserService;

/**
 * 基础action类 在类中添加 messageType 方便 自动扫描.
 */
public abstract class BaseAction implements IAction {
	private NetMessageType messageType;
	private UserService userService;
	private SessionFactory sessionFactory;

	public BaseAction(NetMessageType messageType) {
		this.messageType = messageType;
		userService = new UserService();
		sessionFactory = SessionFactory.getSessionFactory();
	}

	public NetMessageType getMessageType() {
		return messageType;
	}

	public UserService getUserService() {
		return userService;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
