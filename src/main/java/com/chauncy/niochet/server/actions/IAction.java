package com.chauncy.niochet.server.actions;


import com.chauncy.nionetframework.entity.MessageNode;

/**
 * 所有要处理消息类型所对应的函数表达式
 */
@FunctionalInterface
public interface IAction {
	MessageNode execute(MessageNode node);
}
