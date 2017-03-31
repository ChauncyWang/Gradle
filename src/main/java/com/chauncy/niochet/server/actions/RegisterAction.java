package com.chauncy.niochet.server.actions;

import com.chauncy.nionetframework.entity.NetMessageType;
import com.chauncy.niochet.entity.User;
import com.chauncy.nionetframework.entity.MessageNode;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * 处理注册消息
 * Created by chauncy on 17-3-29.
 */
public class RegisterAction extends BaseAction {
	private static Logger logger = Logger.getLogger(RegisterAction.class);

	public RegisterAction() {
		super(NetMessageType.REGISTER);
	}

	@Override
	public MessageNode execute(MessageNode node) {
		User user = (User) node.getMessage().obj;
		String res;
		if (getUserService().addUser(user)) {
			res = "注册成功!";
		} else {
			res = "注册失败!";
		}
		return new MessageNode(node.getIp(), node.getPort(), NetMessageType.RETURN, res);
	}
}