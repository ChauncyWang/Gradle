package com.chauncy.niochet.server.services;

import com.chauncy.niochet.server.dao.UserDao;
import com.chauncy.niochet.entity.User;
import com.chauncy.niochet.entity.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户服务
 * Created by chauncy on 17-3-28.
 */
public class UserService implements UserDao {
	private static Logger logger = Logger.getLogger(UserService.class);
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
	 * @return 登录的用户信息
	 */
	public UserInfo login(String id, String password) {
		User user = getUser(id, password);
		UserInfo info;
		if(user == null){
			return null;
		}
		return user.getUserInfo();
	}

	/* ********************** Override Method ****************** */
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
		String sql = "niochet.UserMapper.selectUser";

		User user = sqlSession.selectOne(sql, map);
		return user;
	}

	@Override
	public UserInfo getUserInfo(String id) {
		String sql = "niochet.UserMapper.selectUserInfo";
		return sqlSession.selectOne(sql, id);
	}

	@Override
	public boolean addUser(User user) {
		String sql1 = "niochet.UserMapper.insertUser";
		String sql2 = "niochet.UserMapper.insertUserInfo";

		try {
			sqlSession.insert(sql1, user);
			sqlSession.insert(sql2, user.getUserInfo());
			sqlSession.commit();
			return true;
		} catch (Exception e) {
			logger.warn(e);
			return false;
		}
	}
}
