package com.chauncy.niochet.server.dao;

import com.chauncy.niochet.entity.User;
import com.chauncy.niochet.entity.UserInfo;

/**
 * 用户dao
 * Created by chauncy on 17-3-26.
 */
public interface UserDao {
	/**
	 * 根据根据id获取完整用户信息
	 *
	 * @param id 用户id
	 * @return 用户信息
	 */
	User getUser(String id);

	/**
	 * 根据根据id,pw获取完整用户信息
	 *
	 * @param id       用户id
	 * @param password 密码
	 * @return 用户信息
	 */
	User getUser(String id, String password);

	/**
	 * 根据id获取用户信息
	 *
	 * @param id 用户id
	 * @return 用户信息
	 */
	UserInfo getUserInfo(String id);

	/**
	 * 添加 用户
	 *
	 * @param user 用户对象
	 * @return 影响的数据条数
	 */
	boolean addUser(User user);
}
