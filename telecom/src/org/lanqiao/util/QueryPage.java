package org.lanqiao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class QueryPage {
	private static Connection conn = ConnectDB.getConnection();
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public QueryPage(){
		
	}
	
	//获取数据库记录数
	public static int getRecord(String tableName){
		int record = -1;
		String sql = "select count(*) from "+tableName;
		Connection conn = ConnectDB.getConnection();
		if(conn != null){
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					record = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				ConnectDB.releaseResource(rs, ps, conn);
			}
		}
		return record;
	}
	
	//分发
	/*public List<Object> selectData(Paging page){
		List<Object> obj = new ArrayList<Object>();
		if("mysql".equals(ConnectDB.getDB())){
			//String sql1 = "select * from "+tableName+" limit ?, ?";
			//obj.add(tableName);
			obj.add((page.getCurrPage()-1)*page.getPageSize());
			obj.add(page.getPageSize());
			list = selectPageData(sql1, obj, cla);
			
		}else{
			String sql2 = "select a.aid, a.aname, a.apsw from (select s.*, rownum as rn from admins s where rownum <= ?) a where rn > ?";
			
			//obj.add(tableName);
			obj.add(page.getCurrPage()*page.getPageSize());
			obj.add((page.getCurrPage()-1)*page.getPageSize());
			list = selectPageData(sql2, obj, cla);
			
		}
		return list;
	}*/
	
	
	
	
}
