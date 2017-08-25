package org.lanqiao.dao.impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao.ExpenseDao;
import org.lanqiao.entity.Expenses;
import org.lanqiao.util.ConnectDB;
import org.lanqiao.util.Const;

public class ExpenseDaoImpl{

	/*@Override
	public int insertExp(Expenses exp) {
		Connection conn = ConnectDB.getConnection();
		int rows = 0;
		String sql = "insert into expenses(eps_name, eps_type, eps_duration, eps_cost, eps_unitc, eps_desc, eps_createtime, eps_status)"
				+ "values(?, ?, ?, ?, ?, ?, (SELECT SYSDATE() AS systemtime), ?)";
		List<Object> obj = new ArrayList<Object>();
		obj.add(exp.getEps_name());
		obj.add(exp.getEps_type());
		obj.add(exp.getEps_duration());
		obj.add(exp.getEps_cost());
		obj.add(exp.getEps_unitc());
		obj.add(exp.getEps_desc());
		obj.add(Const.EXP_STATUS_PAUSE_CODE);
		rows = this.update(sql, obj, conn);
		return rows;
	}

	
	@Override
	public List<Expenses> selectAllExpense() {
		Connection conn = ConnectDB.getConnection();
		ResultSet rs = null;
		List<Expenses> list = new ArrayList<Expenses>();
		String sql = "SELECT * FROM expenses;";
		rs = this.query(sql, null, conn);
		Expenses exp = null;
		try {
			while(rs.next()){
				exp = new Expenses();
				exp.setEps_id(rs.getInt("eps_id"));
				exp.setEps_name(rs.getString("eps_name"));
				exp.setEps_type(rs.getInt("eps_type"));
				exp.setEps_duration(rs.getInt("eps_duration"));
				exp.setEps_cost(rs.getDouble("eps_cost"));
				exp.setEps_unitc(rs.getDouble("eps_unitc"));
				exp.setEps_desc(rs.getString("eps_desc"));
				exp.setEps_createtime(rs.getTimestamp("eps_createtime"));
				exp.setEps_starttime(rs.getTimestamp("eps_starttime"));
				exp.setEps_status(Const.changeStatusToString(rs.getInt("eps_status")));
				list.add(exp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(rs);
			ConnectDB.close(conn);
		}
		return list;
	}


	
	@Override
	public int startExpense(Expenses exp) {
		Connection conn = ConnectDB.getConnection();
		int rows = 0;
		String sql = "update expenses set eps_starttime = (SELECT SYSDATE() AS systemtime), eps_status = ? where eps_id = ?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(Const.EXP_STATUS_OPEN_CODE);
		obj.add(exp.getEps_id());
		rows = this.update(sql, obj, conn);
		return rows;
	}


	@Override
	public Expenses selectExpenseById(Expenses exp) {
		Connection conn = ConnectDB.getConnection();
		ResultSet rs = null;
		String sql = "select * from expenses where eps_id = ?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(exp.getEps_id());
		rs = this.query(sql, obj, conn);
		try {
			while(rs.next()){
				exp = new Expenses();
				exp.setEps_id(rs.getInt("eps_id"));
				exp.setEps_name(rs.getString("eps_name"));
				exp.setEps_type(rs.getInt("eps_type"));
				exp.setEps_duration(rs.getInt("eps_duration"));
				exp.setEps_cost(rs.getDouble("eps_cost"));
				exp.setEps_unitc(rs.getDouble("eps_unitc"));
				exp.setEps_desc(rs.getString("eps_desc"));
				exp.setEps_createtime(rs.getTimestamp("eps_createtime"));
				exp.setEps_starttime(rs.getTimestamp("eps_starttime"));
				exp.setEps_status(Const.changeStatusToString(rs.getInt("eps_status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exp;
	}


	@Override
	public int updateExpense(Expenses exp) {
		Connection conn = ConnectDB.getConnection();
		int rows = 0;
		String sql = "update expenses set eps_name=?, eps_type=?, eps_duration=?,"
				+ " eps_cost=?, eps_unitc=?, eps_desc=? where eps_id=?";
		
		List<Object> obj = new ArrayList<Object>();
		obj.add(exp.getEps_name());
		obj.add(exp.getEps_type());
		obj.add(exp.getEps_duration());
		obj.add(exp.getEps_cost());
		obj.add(exp.getEps_unitc());
		obj.add(exp.getEps_desc());
		obj.add(exp.getEps_id());
		rows = this.update(sql, obj, conn);
		return rows;
	}


	@Override
	public int deleteExpense(Expenses exp) {
		Connection conn = ConnectDB.getConnection();
		int rows = 0;
		String sql = "update expenses set eps_status = 2 where eps_id = ?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(exp.getEps_id());
		rows = this.update(sql, obj, conn);
		return rows;
	}


	@Override
	public List<Expenses> sortExpenses(String sql) {
		Connection conn = ConnectDB.getConnection();
		List<Expenses> list = new ArrayList<Expenses>();
		ResultSet rs = this.query(sql, null, conn);
		Expenses exp = null;
		try {
			while(rs.next()){
				exp = new Expenses();
				exp.setEps_id(rs.getInt("eps_id"));
				exp.setEps_name(rs.getString("eps_name"));
				exp.setEps_type(rs.getInt("eps_type"));
				exp.setEps_duration(rs.getInt("eps_duration"));
				exp.setEps_cost(rs.getDouble("eps_cost"));
				exp.setEps_unitc(rs.getDouble("eps_unitc"));
				exp.setEps_desc(rs.getString("eps_desc"));
				exp.setEps_createtime(rs.getTimestamp("eps_createtime"));
				exp.setEps_starttime(rs.getTimestamp("eps_starttime"));
				exp.setEps_status(Const.changeStatusToString(rs.getInt("eps_status")));
				list.add(exp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectDB.close(rs);
			ConnectDB.close(conn);
		}
		return list;
	}
*/
}
