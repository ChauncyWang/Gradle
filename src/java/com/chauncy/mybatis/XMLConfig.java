package com.chauncy.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chauncy on 17-3-15.
 */
public class XMLConfig {
	private SqlSessionFactory sqlSessionFactory = null;
	private String url;
	public XMLConfig(String url) {
		this.url = url;
	}
	public SqlSessionFactory getSqlSeesionFactory() throws IOException {
		InputStream is = Resources.getResourceAsStream(url);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		return sqlSessionFactory;
	}
}
