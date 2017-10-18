package com.briup.estore.common;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlSessionFactory {
	private static SqlSessionFactory factory;
	public static  SqlSessionFactory getSqlSessionFactory(){
		if(factory==null){
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream("mybatis-config.xml"); 
				factory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e.getCause());
			}
		}
		return factory;
	}
	public static SqlSession openSession() { 
		return openSession(false); 
	}
	public static SqlSession openSession(boolean autoCommit) { 
		return getSqlSessionFactory().openSession(autoCommit); 
	}
}
