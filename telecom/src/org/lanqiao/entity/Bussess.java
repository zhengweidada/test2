package org.lanqiao.entity;

import java.sql.Timestamp;

/**
 * 业务实体类
 * @author WJJ
 *
 */
public class Bussess {
	private int buss_id;
	private Account account;
	private String os_account;
	private String os_psw;
	private int buss_status;
	private String server_ip;
	private Expenses expenses;
	private Timestamp bus_create_time;
	private Timestamp service_time;
	private String by1;
	private String by2;
	private String by3;
	private String by4;
	
	public Bussess() {
		super();
	}
	
	public Bussess(int buss_id) {
		super();
		this.buss_id = buss_id;
	}

	public Bussess(int buss_id, int buss_status) {
		super();
		this.buss_id = buss_id;
		this.buss_status = buss_status;
	}

	public Bussess(Account account, String os_account, String os_psw, String server_ip, Expenses expenses) {
		super();
		this.account = account;
		this.os_account = os_account;
		this.os_psw = os_psw;
		this.server_ip = server_ip;
		this.expenses = expenses;
	}


	public int getBuss_id() {
		return buss_id;
	}
	public void setBuss_id(int buss_id) {
		this.buss_id = buss_id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getOs_account() {
		return os_account;
	}
	public void setOs_account(String os_account) {
		this.os_account = os_account;
	}
	public String getOs_psw() {
		return os_psw;
	}
	public void setOs_psw(String os_psw) {
		this.os_psw = os_psw;
	}
	public int getBuss_status() {
		return buss_status;
	}
	public void setBuss_status(int buss_status) {
		this.buss_status = buss_status;
	}
	public String getServer_ip() {
		return server_ip;
	}
	public void setServer_ip(String server_ip) {
		this.server_ip = server_ip;
	}
	public Expenses getExpenses() {
		return expenses;
	}
	public void setExpenses(Expenses expenses) {
		this.expenses = expenses;
	}
	public String getBy1() {
		return by1;
	}
	
	
	public Timestamp getBus_create_time() {
		return bus_create_time;
	}

	public void setBus_create_time(Timestamp timestamp) {
		this.bus_create_time = timestamp;
	}

	
	public Timestamp getService_time() {
		return service_time;
	}

	public void setService_time(Timestamp service_time) {
		this.service_time = service_time;
	}

	public void setBy1(String by1) {
		this.by1 = by1;
	}
	public String getBy2() {
		return by2;
	}
	public void setBy2(String by2) {
		this.by2 = by2;
	}
	public String getBy3() {
		return by3;
	}
	public void setBy3(String by3) {
		this.by3 = by3;
	}
	public String getBy4() {
		return by4;
	}
	public void setBy4(String by4) {
		this.by4 = by4;
	}

	@Override
	public String toString() {
		return "Bussess [buss_id=" + buss_id + ", account=" + account + ", os_account=" + os_account + ", os_psw="
				+ os_psw + ", buss_status=" + buss_status + ", server_ip=" + server_ip + ", expenses=" + expenses
				+ ", bus_create_time=" + bus_create_time + ", service_time=" + service_time + "]";
	}
	
	
	
}
