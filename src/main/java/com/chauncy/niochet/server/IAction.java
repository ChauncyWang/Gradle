package com.chauncy.niochet.server;


/**
 * 所有要处理消息类型所对应的函数表达式
 */
@FunctionalInterface
public interface IAction {
	void execture(Node node);
}
