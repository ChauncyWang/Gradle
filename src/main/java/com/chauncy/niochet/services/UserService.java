package com.chauncy.niochet.services;

import com.chauncy.niochet.dao.UserDao;
import com.chauncy.niochet.entity.User;
import com.chauncy.niochet.entity.UserInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户服务
 * Created by chauncy on 17-3-28.
 */
public class UserService implements UserDao {
	/**
	 * 数据库会话
	 */
	private SqlSession sqlSession;

	public UserService() {
		sqlSession = MybaitsTools.getSqlSession();
	}

	/**
	 * 登录
	 *
	 * @param id       用户id
	 * @param password 用户密码
	 * @return 登录是否成功
	 */
	public boolean login(String id, String password) {
		return getUser(id, password) != null;
	}

	@Override
	public User getUser(String id) {
		return null;
	}

	@Override
	public User getUser(String id, String password) {
		//配置参数map
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("password", password);
		//sql语句所在的mapper的具体位置
		String mapper = "niochet.UserMapper.selectUser";

		User user = sqlSession.selectOne(mapper, map);
		return user;
	}

	@Override
	public UserInfo getUserInfo(String id) {
		String mapper = "niochet.UserMapper.selectInfo";
		return sqlSession.selectOne(mapper, id);
	}
}
