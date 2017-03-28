package com.chauncy.niochet;

import com.chauncy.niochet.entity.User;
import com.chauncy.niochet.entity.UserInfo;
import com.chauncy.niochet.services.UserService;


/**
 * 测试类
 * Created by chauncy on 17-3-20.
 */
public class Test {
	public static void main(String[] args) {
		UserInfo userInfo = new UserInfo("111", "昵称", "签名");
		User user = new User(userInfo.getId(), "密码", userInfo);
		System.out.println(new UserService().addUser(user));

	}
}
