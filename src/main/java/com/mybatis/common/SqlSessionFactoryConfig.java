package com.mybatis.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//sessionFactory 单例管理
public class SqlSessionFactoryConfig {

	private static SqlSessionFactory sqlSessionFactory = null;
	private static String resource = "conf.xml";

	public static SqlSessionFactory getInsance() {
		if (sqlSessionFactory == null) {
			createSessionFactory();
		}
		return sqlSessionFactory;
	}

	private static synchronized void createSessionFactory() {
		if (sqlSessionFactory != null)
			return;
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
