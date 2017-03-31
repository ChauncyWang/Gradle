package com.chauncy.niochet.server.actions;

import com.chauncy.nionetframework.action.IAction;
import com.chauncy.nionetframework.entity.NetMessage;
import com.chauncy.nionetframework.entity.NetMessageType;
import com.chauncy.niochet.entity.StatusSession;
import com.chauncy.nionetframework.services.StatusSessionService;
import com.chauncy.niochet.server.services.UserService;

import java.io.IOException;

import static com.chauncy.nionetframework.util.NetTools.writeObject;

/**
 * 基础action类 在类中添加 messageType 方便 自动扫描.
 */
public abstract class BaseAction implements IAction {
	private NetMessageType messageType;
	private UserService userService;

	public BaseAction(NetMessageType messageType) {
		this.messageType = messageType;
		userService = new UserService();
	}

	public NetMessageType getMessageType() {
		return messageType;
	}

	public UserService getUserService() {
		return userService;
	}
}
