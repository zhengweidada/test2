package org.lanqiao.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectDB {
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	private static Properties properties = null;
	static Connection conn = null;

	
	static{
		try {
			//InputStreamReader is = new InputStreamReader(new FileInputStream("conf/database.properties"));
			InputStreamReader is = new InputStreamReader(
					Thread.currentThread().getContextClassLoader().
					getResourceAsStream("database.properties"));
			properties = new Properties();
			properties.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*try {
			Context ctx  = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jndi/"+getDB());
		} catch (NamingException e) {
			e.printStackTrace();
		}*/
		
		
	}
	
	
	//获取配置文件中数据库配置信息
	public static String getDB(){
		return properties.getProperty("database");
	}
	
	
	//获取连接
	public static Connection getConnection(){
		 try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//返回配置文件中的设置的pagesize
	public static String getPageSize(){
		return properties.getProperty("pagesize");
		
	}
	
	
	public static void releaseResource(ResultSet rs, PreparedStatement ps, Connection conn){
		try {
			if(rs != null){
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement ps){
		try {
			if(ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs){
		try {
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn){
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
