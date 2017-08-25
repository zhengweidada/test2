package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao.AccountDao;
import org.lanqiao.entity.Account;
import org.lanqiao.util.ConnectDB;
import org.lanqiao.util.Const;

public class AccountDaoImpl{
/*
	@Override
	public int insertAccount(Account account) {
		Connection conn = ConnectDB.getConnection();
		int rows = 0;
		String sql = "INSERT INTO userinfo(user_name, user_login_name, user_psw, "
				+ "user_idcard, birth, sex, user_phone, email, qq, job, user_createtime, "
				+ "user_status, address, user_code, referee_id, referee_idcard)"
				+ "values(?,?,?,?,?,?,?,?,?,?,(select sysdate()),?,?,?,?,?)";
		
		List<Object> obj = new ArrayList<Object>();
		obj.add(account.getUser_name());
		obj.add(account.getUser_login_name());
		obj.add(account.getUser_psw());
		obj.add(account.getUser_idcard());
		obj.add(account.getBirth());
		obj.add(account.getSex());
		obj.add(account.getUser_phone());
		obj.add(account.getEmail());
		obj.add(account.getQq());
		obj.add(account.getJob());
		obj.add(Const.EXP_STATUS_OPEN_CODE);
		obj.add(account.getAddress());
		obj.add(account.getUser_code());
		obj.add(account.getReferee_id());
		obj.add(account.getReferee_idcard());
		rows = this.update(sql, obj, conn);
		return rows;
	}

	@Override
	public Account selectAccountByIdCard(Account account) {
		Connection conn = ConnectDB.getConnection();
		ResultSet rs = null;
		String sql = "SELECT account_id FROM userinfo WHERE user_idcard = ?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(account.getReferee_idcard());
		rs = this.query(sql, obj, conn);
		try {
			if(rs.next())
				account.setReferee_id(rs.getInt(1));
			else {
				account.setReferee_id(0);
				account.setReferee_idcard("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	
	@Override
	public List<Account> selectAllAccount() {
		Connection conn = ConnectDB.getConnection();
		String sql = "select * from userinfo";
		ResultSet rs = this.query(sql, null, conn);
		List<Account> list = accountIterator(rs);
		return list;
	}
	
	private List<Account> accountIterator(ResultSet rs){
		List<Account> list = new ArrayList<Account>();
		Account account = null;
		try {
			while(rs.next()){
				account = new Account();
				account.setAccount_id(rs.getInt("account_id"));
				account.setUser_name(rs.getString("user_name"));
				account.setUser_login_name(rs.getString("user_login_name"));
				account.setUser_psw(rs.getString("user_psw"));
				account.setUser_idcard(rs.getString("user_idcard"));
				account.setBirth(rs.getString("birth"));
				account.setSex(rs.getInt("sex"));
				account.setUser_phone(rs.getString("user_phone"));
				account.setEmail(rs.getString("email"));
				account.setQq(rs.getString("qq"));
				account.setUser_createtime(rs.getTimestamp("user_createtime"));
				account.setUser_status(Const.changeStatusToString(rs.getInt("user_status")));
				list.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	

	@Override
	public Account selectAccountById(Account account) {
		Connection conn = ConnectDB.getConnection();
		ResultSet rs = null;
		String sql = "select * from userinfo where account_id = ?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(account.getAccount_id());
		rs = this.query(sql, obj, conn);
		Account account2 = null;
		try {
			if(rs.next()){
				account2 = new Account();
				account2.setAccount_id(rs.getInt("account_id"));
				account2.setUser_name(rs.getString("user_name"));
				account2.setUser_login_name(rs.getString("user_login_name"));
				account2.setUser_psw(rs.getString("user_psw"));
				account2.setUser_idcard(rs.getString("user_idcard"));
				account2.setBirth(rs.getString("birth"));
				account2.setSex(rs.getInt("sex"));
				account2.setUser_phone(rs.getString("user_phone"));
				account2.setEmail(rs.getString("email"));
				account2.setQq(rs.getString("qq"));
				account2.setUser_createtime(rs.getTimestamp("user_createtime"));
				account2.setUser_status(Const.changeStatusToString(rs.getInt("user_status")));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account2;
	}

	@Override
	public int deleteAccount(Account account) {
		Connection conn = ConnectDB.getConnection();
		int rows = 0;
		String sql = "update userinfo set user_status = ?, service_time = (select sysdate()) where account_id = ?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(Const.EXP_STATUS_DEL_CODE);
		obj.add(account.getAccount_id());
		rows = this.update(sql, obj, conn);
		return rows;
	}

	@Override
	public int updateAccount(Account account) {
		Connection conn = ConnectDB.getConnection();
		int rows = 0;
		String sql = "UPDATE userinfo SET user_name=?,user_login_name=?,"
				+ "user_psw=?,user_idcard=?,birth=?,sex=?,user_phone=?,email=?,"
				+ "qq=?,job=?,address=?,user_code=?,referee_id=?,referee_idcard=? "
				+ "WHERE account_id=?;";
		
		List<Object> obj = new ArrayList<Object>();
		obj.add(account.getUser_name());
		obj.add(account.getUser_login_name());
		obj.add(account.getUser_psw());
		obj.add(account.getUser_idcard());
		obj.add(account.getBirth());
		obj.add(account.getSex());
		obj.add(account.getUser_phone());
		obj.add(account.getEmail());
		obj.add(account.getQq());
		obj.add(account.getJob());
		obj.add(account.getAddress());
		obj.add(account.getUser_code());
		obj.add(account.getReferee_id());
		obj.add(account.getReferee_idcard());
		obj.add(account.getAccount_id());
		rows = this.update(sql, obj, conn);
		return rows;
	}

	@Override
	public int pauseAccountStatus(Account account) {
		Connection conn = ConnectDB.getConnection();
		int rows = 0;
		String sql = "UPDATE userinfo SET user_status = ?, service_time = (SELECT SYSDATE()) WHERE account_id = ?;";
		List<Object> obj = new ArrayList<Object>();
		obj.add(Const.EXP_STATUS_PAUSE_CODE);
		obj.add(account.getAccount_id());
		rows = this.update(sql, obj, conn);
		return rows;
	}

	@Override
	public int openAccountAgain(Account account) {
		Connection conn = ConnectDB.getConnection();
		int rows = 0;
		String sql = "UPDATE userinfo SET user_status = ?, service_time = NULL WHERE account_id = ?;";
		List<Object> obj = new ArrayList<Object>();
		obj.add(Const.EXP_STATUS_OPEN_CODE);
		obj.add(account.getAccount_id());
		rows = this.update(sql, obj, conn);
		return rows;
	}

	@Override
	public List<Account> selectAccountByCondition(String sql, List<Object> obj) {
		Connection conn = ConnectDB.getConnection();
		 ResultSet rs = this.query(sql, obj, conn);
		List<Account> list = accountIterator(rs);
		return list;
	}

	@Override
	public Account selectAccountByIdCard2(Account account) {
		Connection conn = ConnectDB.getConnection();
		ResultSet rs = null;
		String sql = "SELECT * FROM userinfo WHERE user_idcard = ?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(account.getUser_idcard());
		rs = this.query(sql, obj, conn);
		Account account2 = null;
		try {
			while(rs.next()){
				account2 = new Account();
				account2.setAccount_id(rs.getInt("account_id"));
				account2.setUser_name(rs.getString("user_name"));
				account2.setUser_login_name(rs.getString("user_login_name"));
				account2.setUser_idcard(rs.getString("user_idcard"));
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account2;
	}
*/
}
