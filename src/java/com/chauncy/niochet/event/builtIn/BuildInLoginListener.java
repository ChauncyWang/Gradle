package com.chauncy.niochet.event.builtIn;

import com.chauncy.niochet.entity.StatusSession;
import com.chauncy.niochet.entity.User;
import com.chauncy.niochet.entity.UserInfo;
import com.chauncy.niochet.entity.UserStatus;
import com.chauncy.niochet.event.LoginEvent;
import com.chauncy.niochet.event.LoginListener;
import com.chauncy.niochet.server.services.UserService;

/**
 * 内置的login监听器,登陆相关操作都会触发该Listener
 * Created by Chauncy on 2017/4/8.
 */
public class BuildInLoginListener implements LoginListener {
	/**
	 * 用户服务层
	 */
	private UserService userService = new UserService();
	@Override
	public void login(LoginEvent loginEvent) {
		//获取附加的用户信息
		User t = loginEvent.getUser();
		//检查账户密码是否匹配
		UserInfo userInfo = userService.login(t.getId(),t.getPassword());
		//用户状态
		UserStatus status;
		StatusSession attach = new StatusSession();
		attach.setUser(userInfo);

		if(userInfo!=null) {
			//没有登录成功
			//状态为等待登录
			status = UserStatus.WITHOUT_LOGIN;
		}else {
			//登陆成功后，设置状态为在线
			status = UserStatus.ONLINE;
		}
		attach.setStatus(status);
	}

	@Override
	public void logout(LoginEvent loginEvent) {

	}

	@Override
	public void register(LoginEvent loginEvent) {

	}
}
