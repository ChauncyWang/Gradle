package com.chauncy.mybatis;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

/**
 * Created by chauncy on 17-3-15.
 */
public class NoXMLConfig {
	public static SqlSessionFactory getSqlSessionFactory() {
		DataSource dataSource = new PooledDataSource("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/Chauncy","root","wangchongcll");
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		return new SqlSessionFactoryBuilder().build(configuration);
	}
}
