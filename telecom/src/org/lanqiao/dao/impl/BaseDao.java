package org.lanqiao.dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.lanqiao.util.ConnectDB;

public class BaseDao<T> {
	
	
	
	
	/**
	 * 查询，使用了泛型和反射
	 * @param sql
	 * @param obj
	 * @param cla
	 * @return
	 */
	public List<T> query(String sql, List<Object> obj, Class<T> cla) {
		List<T> list = new ArrayList<T>();
		Connection conn = ConnectDB.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if(null != conn){
			try {
				ps = conn.prepareStatement(sql);
				if(obj != null){
					for(int i=0; i<obj.size(); i++){
						ps.setObject(i+1, obj.get(i));
					}
				}
				rs = ps.executeQuery();
				// 从结果集中获取元数据
		        ResultSetMetaData rm=rs.getMetaData();
				while(rs.next()){
					T  data = (T) cla.newInstance();
					 //只针对于一行，也就是仅仅创建一个对象  
		            for(int i=0;i<rm.getColumnCount();i++){
		                // 获得列名
		                String columnName=rm.getColumnName(i+1);
		                //System.out.println("列名："+columnName);
		                // 取出表中数据，从数据库中获取的列名必须与实体类的属性必须一一对应，
		                //不然就会报错，这种封装方法还是不如hiberate中的映射文件好用，
		                //全部根据映射文件自动封装，不用将数据库中的列名设置的和实体类的属性一模一样
		                Object value=rs.getObject(i+1);
		                //System.out.println("属性值："+value);
		                // 获取对象的属性，
		                Field field=cla.getDeclaredField(columnName.toLowerCase());
		                
		                // 赋予操作对象私有属性的权限
		                field.setAccessible(true);
		                // 给私有对象赋值
		                field.set(data,value);
		            }
		            list.add(data);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}finally{
				ConnectDB.close(rs);
				ConnectDB.close(ps);
				ConnectDB.close(conn);
			}
		}
		return list;
	}
	
	/**
	 * 普通查询方法
	 * @param sql
	 * @param obj
	 * @return
	 */
	public ResultSet query(String sql, List<Object> obj, Connection conn){
		PreparedStatement ps = null;
		ResultSet rs = null;
		if(conn != null){
			try {
				ps = conn.prepareStatement(sql);
				if(obj != null){
					for(int i=0; i<obj.size(); i++){
						ps.setObject(i+1, obj.get(i));
					}
				}
				rs = ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	
	
	/**
	 * 增删改
	 * @param sql
	 * @param obj
	 * @return
	 */
	public int update(String sql, List<Object> obj, Connection conn) {
		int rows = 0;
		PreparedStatement ps = null;
		if(conn != null){
			try {
				ps = conn.prepareStatement(sql);
				if(obj != null){
					for(int i=0; i<obj.size(); i++){
						ps.setObject(i+1, obj.get(i));
					}
				}
				rows = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}
	
	
	

}
