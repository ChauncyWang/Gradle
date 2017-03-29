package com.chauncy.niochet.server.services;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Mybaits 的服务层实现所用的 Mybatis 会话
 * 使用单例模式
 * Created by chauncy on 17-3-28.
 */
public class MybaitsTools {
	private static SqlSession sqlSession = null;

	/**
	 * 获取数据库session
	 *
	 * @return 数据库会话
	 */
	public synchronized static SqlSession getSqlSession() {
		if (sqlSession == null) {
			//配置文件位置
			String url = "com/chauncy/niochet/server/services/mybatis-config.xml";
			InputStream is = ClassLoader.getSystemResourceAsStream(url);
			sqlSession = new SqlSessionFactoryBuilder().build(is).openSession();
		}

		return sqlSession;
	}
}
