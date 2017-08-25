package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao.BussessDao;
import org.lanqiao.entity.Account;
import org.lanqiao.entity.Bussess;
import org.lanqiao.entity.Expenses;
import org.lanqiao.util.ConnectDB;
import org.lanqiao.util.Const;

public class BussessDaoImpl{

	/*@Override
	public int insertBussess(Bussess bussess) {
		Connection conn = ConnectDB.getConnection();
		int rows = 0;
		String sql = "INSERT INTO bussiness(account_id, os_account, os_psw, buss_status, server_ip, eps_id, bus_create_time) VALUES(?,?,?,?,?,?, (select sysdate()));";
		List<Object> obj = new ArrayList<Object>();
		obj.add(bussess.getAccount().getAccount_id());
		obj.add(bussess.getOs_account());
		obj.add(bussess.getOs_psw());
		obj.add(Const.EXP_STATUS_OPEN_CODE);
		obj.add(bussess.getServer_ip());
		obj.add(bussess.getExpenses().getEps_id());
		rows = this.update(sql, obj, conn);
		return rows;
	}

	@Override
	public List<Bussess> selectAllBussesses() {
		Connection conn = ConnectDB.getConnection();
		ResultSet rs = null;
		List<Bussess> list = new ArrayList<Bussess>();
 		String sql = "SELECT br.*, e.`eps_name`, e.`eps_desc` FROM(SELECT b.`bus_id`, "
				+ "u.`account_id`, u.`user_name`, u.`user_login_name`, u.user_idcard,b.`os_account`, "
				+ "b.`server_ip`, b.`buss_status`, b.`bus_create_time`, b.`eps_id` "
				+ "FROM bussiness b LEFT JOIN userinfo u ON b.`account_id`=u.`account_id`) br "
				+ "LEFT JOIN expenses e ON br.eps_id = e.eps_id;";
 		rs = this.query(sql, null, conn);
 		Bussess bussess = null;
 		Account account = null;
 		Expenses expenses = null;
 		try {
			while(rs.next()){
				bussess = new Bussess();
				bussess.setBuss_id(rs.getInt("bus_id"));
				bussess.setOs_account(rs.getString("os_account"));
				bussess.setBuss_status(rs.getInt("buss_status"));
				bussess.setServer_ip(rs.getString("server_ip"));
				bussess.setBus_create_time(rs.getTimestamp("bus_create_time"));
				account = new Account();
				account.setAccount_id(rs.getInt("account_id"));
				account.setUser_name(rs.getString("user_name"));
				account.setUser_login_name(rs.getString("user_login_name"));
				account.setUser_idcard(rs.getString("user_idcard"));
				expenses = new Expenses();
				expenses.setEps_id(rs.getInt("eps_id"));
				expenses.setEps_name(rs.getString("eps_name"));
				expenses.setEps_desc(rs.getString("eps_desc"));
				bussess.setAccount(account);
				bussess.setExpenses(expenses);
				list.add(bussess);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int changeBussessStatus(Bussess bussess) {
		String sql = "";
		//System.out.println("dao----"+bussess.getBuss_status());
		if(bussess.getBuss_status() == 0){//暂停
			sql = "UPDATE bussiness SET buss_status = 0, service_time=(SELECT SYSDATE()) WHERE bus_id = "+bussess.getBuss_id();
		}else if(bussess.getBuss_status() == 1){//重新开启
			sql = "UPDATE bussiness SET buss_status = 1, service_time=null WHERE bus_id = "+bussess.getBuss_id();	
		}else if(bussess.getBuss_status() == 2){//删除
			sql = "UPDATE bussiness SET buss_status = 2, service_time=(SELECT SYSDATE()) WHERE bus_id = "+bussess.getBuss_id();
		}
		Connection conn = ConnectDB.getConnection();
		int rows = 0;
		rows = this.update(sql, null, conn);
		return rows;
	}

	@Override
	public int updateBussess(Bussess bussess) {
		Connection conn = ConnectDB.getConnection();
		int rows = 0;
		String sql = "update bussiness set eps_id = ? where bus_id = ?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(bussess.getExpenses().getEps_id());
		obj.add(bussess.getBuss_id());
		rows = this.update(sql, obj, conn);
		return rows;
	}

	@Override
	public Bussess selectedBussessById(Bussess bussess2) {
		Connection conn = ConnectDB.getConnection();
		ResultSet rs = null;
		String sql = "SELECT br.*, e.`eps_name`, e.`eps_desc` FROM(SELECT b.`bus_id`, u.`account_id`, u.`user_name`, u.`user_idcard`, u.`user_login_name`, b.`os_account`, b.`server_ip`, b.`buss_status`, b.`bus_create_time`, b.`eps_id` FROM bussiness b LEFT JOIN userinfo u ON b.`account_id`=u.`account_id`) br LEFT JOIN expenses e ON br.eps_id = e.eps_id WHERE br.bus_id = ?;";
		List<Object> obj = new ArrayList<Object>();
		obj.add(bussess2.getBuss_id());
		rs = this.query(sql,obj, conn);
		Bussess bussess = null;
		Account account = null;
		Expenses expenses = null;
		try {
			while(rs.next()){
				bussess = new Bussess();
				bussess.setBuss_id(rs.getInt("bus_id"));
				bussess.setOs_account(rs.getString("os_account"));
				bussess.setBuss_status(rs.getInt("buss_status"));
				bussess.setServer_ip(rs.getString("server_ip"));
				bussess.setBus_create_time(rs.getTimestamp("bus_create_time"));
				account = new Account();
				account.setAccount_id(rs.getInt("account_id"));
				account.setUser_name(rs.getString("user_name"));
				account.setUser_login_name(rs.getString("user_login_name"));
				account.setUser_idcard(rs.getString("user_idcard"));
				expenses = new Expenses();
				expenses.setEps_id(rs.getInt("eps_id"));
				expenses.setEps_name(rs.getString("eps_name"));
				expenses.setEps_desc(rs.getString("eps_desc"));
				bussess.setAccount(account);
				bussess.setExpenses(expenses);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bussess;
	}
*/
}
