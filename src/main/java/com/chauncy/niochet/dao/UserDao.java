package com.chauncy.niochet.dao;

import com.chauncy.niochet.entity.User;

/**
 * 用户dao
 * Created by chauncy on 17-3-26.
 */
public interface UserDao {
	/**
	 * 根据
	 * @param id
	 * @return
	 */
	User getUser(String id);

	/**
	 * @param id
	 * @param password
	 * @return
	 */
	User getUser(String id, String password);
}
