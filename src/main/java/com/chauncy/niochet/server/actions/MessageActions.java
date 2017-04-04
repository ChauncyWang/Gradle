package com.chauncy.niochet.server.actions;

import com.chauncy.nionetframework.entity.NetMessageType;
import com.chauncy.nionetframework.util.ClassScanner;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 所有消息的处理方式都在这里
 * Created by chauncy on 17-3-28.
 */
public class MessageActions implements IMessageActions {
	private static Logger logger = Logger.getLogger(MessageActions.class);
	/**
	 * 消息 map 消息类型 ---> 函数表达式
	 */
	private Map<NetMessageType, IAction> actions;

	public MessageActions() {
		actions = new HashMap<>();
		scanner();
	}

	/**
	 * 对包进行扫描,获取包中的action类并添加到action map中
	 */
	private void scanner() {
		//进行包扫描
		Set<Class<?>> classSet = ClassScanner.getClasses("com.chauncy.niochet.server.actions");
		//将IAction的实现类进行过滤
		classSet = classSet.stream().filter(aClass -> {
					Class superClass = aClass.getSuperclass();
					return superClass != null &&
							"BaseAction".equals(superClass.getSimpleName());
				}
		).collect(Collectors.toSet());
		//newInstance 类 并添加到 actionMap
		for (Class<?> c : classSet) {
			try {
				//生成新的IAction
				BaseAction action = (BaseAction) c.newInstance();
				//添加到actions 的 Map
				actions.put(action.getMessageType(), action);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
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
