package com.chauncy.niochet.server.actions;

import com.chauncy.niochet.entity.User;
import com.chauncy.niochet.server.Session;
import com.chauncy.niochet.server.SessionFactory;
import com.chauncy.niochet.services.UserService;
import com.chauncy.util.ClassScanner;
import com.chauncy.niochet.entity.NetMessage;
import com.chauncy.niochet.entity.NetMessageType;
import org.apache.log4j.Logger;
import org.junit.Test;

import static com.chauncy.util.NetTools.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 所有消息的处理方式都在这里
 * Created by chauncy on 17-3-28.
 */
public class MessageActions {
	private static Logger logger = Logger.getLogger(MessageActions.class);
	private Map<NetMessageType, IAction> actions;
	private UserService userService;
	private SessionFactory sessionFactory;

	@Test
	public void test() {
		ClassScanner.getClasses("com.chauncy.niochet.server.actions");
	}

	public MessageActions() {
		userService = new UserService();
		actions = new HashMap<>();
		sessionFactory = SessionFactory.getSessionFactory();

		// 处理注册事件
		actions.put(NetMessageType.REGISTER, node -> {
			User user = (User) node.getMessage().obj;
			String res;
			if (userService.addUser(user)) {
				res = "注册成功!";
			} else {
				res = "注册失败!";
			}
			NetMessage netMessage = new NetMessage(NetMessageType.RETURN, res);
			Session session = sessionFactory.getSession(node.getIp(), node.getPort());
			try {
				writeObject(session.getSocketChannel(), netMessage);
			} catch (IOException e) {
				logger.info(e);
			}
		});
	}

	/**
	 * 根据消息类型获取 对应处理的处理
	 *
	 * @param type 消息类型
	 * @return 进行处理的函数表达式
	 */
	public IAction getAction(NetMessageType type) {
		return actions.get(type);
	}
}
