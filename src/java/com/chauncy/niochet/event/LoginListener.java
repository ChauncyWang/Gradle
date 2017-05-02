package com.chauncy.niochet.event;

/**
 * 注册,登陆,注销相关的监听器
 * Created by Chauncy on 2017/4/8.
 */
public interface LoginListener {
	/**
	 * 登陆时触发
	 * @param loginEvent 登陆事件
	 */
	void login(LoginEvent loginEvent);

	/**
	 * 注销时触发
	 * @param loginEvent 注销事件
	 */
	void logout(LoginEvent loginEvent);

	/**
	 * 注册时触发
	 * @param loginEvent 注册事件
	 */
	void register(LoginEvent loginEvent);
}
