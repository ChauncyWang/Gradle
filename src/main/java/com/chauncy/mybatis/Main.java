package com.chauncy.mybatis;

import com.chauncy.mybatis.entity.Classes;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

/**
 * Created by chauncy on 17-3-15.
 */
public class Main {
	public static void main(String[] args) {
		try {
			SqlSessionFactory sqlSessionFactory = new XMLConfig("com/chauncy/mybatis/mybatis-config.xml").getSqlSeesionFactory();
			SqlSession sqlSession = sqlSessionFactory.openSession();
			String statement = "com.chauncy.mybatis.entity.Classes.select2";
			Classes classes = sqlSession.selectOne(statement,1);

			System.out.println(classes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
