package org.lanqiao.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtil {
	/**
	 * 获取类型
	 * @param cla
	 * @return
	 */
	/*public T getDaoType(Class<T> cla){
		SqlSession session = getSession();
		T dao = session.getMapper(cla);
		return dao;
	}*/
	
	
	/**
	 * 获取SqlSession
	 * @return
	 */
	public static SqlSession getSession(){
		SqlSession session = null;
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
			session = build.openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	
	/**
	 * 关闭SqlSession 
	 * @param session
	 */
	public static void closeSession(SqlSession session){
		session.close();
	}

}
