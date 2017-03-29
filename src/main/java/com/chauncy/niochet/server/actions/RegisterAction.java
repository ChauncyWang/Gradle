package com.chauncy.niochet.server.actions;

import com.chauncy.niochet.entity.NetMessage;
import com.chauncy.niochet.entity.NetMessageType;
import com.chauncy.niochet.entity.Register;
import com.chauncy.niochet.entity.User;
import com.chauncy.niochet.server.MessageNode;
import com.chauncy.niochet.server.Session;
import org.apache.log4j.Logger;

import java.io.IOException;

import static com.chauncy.util.NetTools.writeObject;

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
	public void execute(MessageNode node) {
		User user = (User) node.getMessage().obj;
		String res;
		if (getUserService().addUser(user)) {
			res = "注册成功!";
		} else {
			res = "注册失败!";
		}
		NetMessage netMessage = new NetMessage(NetMessageType.RETURN, res);
		Session session = getSessionFactory().getSession(node.getIp(), node.getPort());
		try {
			writeObject(session.getSocketChannel(), netMessage);
		} catch (IOException e) {
			logger.info(e);
		}
	}
}