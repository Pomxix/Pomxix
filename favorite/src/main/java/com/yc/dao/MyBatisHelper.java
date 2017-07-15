package com.yc.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisHelper {
	
	private static SqlSessionFactory sqlSessionFactory;
	static{
		try {
			String resource = "mybatisConfiguration.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource); 
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static SqlSession getSession() throws Exception{
		SqlSession session= sqlSessionFactory.openSession();
		return session;
	}

}
