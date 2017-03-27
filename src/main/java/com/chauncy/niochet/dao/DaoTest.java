package com.chauncy.niochet.dao;

import com.chauncy.niochet.entity.User;
import com.chauncy.niochet.entity.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chauncy on 17-3-25.
 */
public class DaoTest {
	private SqlSessionFactory factory;
	private SqlSession sqlSession;

	@Before
	public void before() {
		factory = new SqlSessionFactoryBuilder()
				.build(ClassLoader.getSystemResourceAsStream("com/chauncy/niochet/dao/mybatis-config.xml"));
		sqlSession = factory.openSession();
	}

	@Test
	public void test() {
		User user = sqlSession.selectOne("niochet.UserMapper.selectUser", "110");
		System.out.println(user);
	}
}
