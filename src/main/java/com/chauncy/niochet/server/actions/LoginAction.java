package com.chauncy.niochet.server.actions;

import com.chauncy.niochet.entity.NetMessageType;
import com.chauncy.niochet.entity.User;
import com.chauncy.niochet.entity.UserInfo;
import com.chauncy.niochet.server.MessageNode;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * 登录
 * Created by chauncy on 17-3-29.
 */
public class LoginAction extends BaseAction {
	private static Logger logger = Logger.getLogger(LoginAction.class);

	public LoginAction() {
		super(NetMessageType.LOGIN);
	}

	@Override
	public void execute(MessageNode node) {
		String[] strs = (String[]) node.getMessage().obj;
		UserInfo user = getUserService().login(strs[0], strs[1]);

		try {
			writeMessage(node.getIp(), node.getPort(), NetMessageType.RETURN, user);
		} catch (IOException e) {
			logger.info(e);
		}
	}
}
