package com.chauncy.niochet.services;

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

	public static SqlSession getSqlSession() {
		if (sqlSession == null) {
			String url = "com/chauncy/niochet/services/mybatis-config.xml";
			System.out.println(url);
			InputStream is = ClassLoader.getSystemResourceAsStream(url);

			sqlSession = new SqlSessionFactoryBuilder().build(is).openSession();
		}

		return sqlSession;
	}
}
