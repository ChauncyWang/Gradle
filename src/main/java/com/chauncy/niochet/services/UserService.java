package com.chauncy.niochet.services;

import com.chauncy.niochet.dao.UserDao;
import com.chauncy.niochet.entity.User;
import com.chauncy.niochet.entity.UserInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户服务
 * Created by chauncy on 17-3-28.
 */
public class UserService implements UserDao {

	public boolean login(String id, String password) {
		return getUser(id, password) != null;
	}

	@Override
	public User getUser(String id) {
		return null;
	}

	@Override
	public User getUser(String id, String password) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("password", password);

		User user = MybaitsTools.getSqlSession().selectOne("UserMapper.selectUser", map);
		return user;
	}

	@Override
	public UserInfo getUserInfo(String id) {
		return null;
	}
}
