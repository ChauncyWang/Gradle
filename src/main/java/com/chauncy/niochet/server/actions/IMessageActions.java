package com.chauncy.niochet.server.actions;

import com.chauncy.nionetframework.entity.NetMessageType;

/**
 * 处理消息的函数集合 的类都必须实现该借口
 * Created by chauncy on 17-3-31.
 */
public interface IMessageActions {
	IAction getAction(NetMessageType type);
}
