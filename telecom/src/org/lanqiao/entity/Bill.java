package org.lanqiao.entity;

import java.sql.Date;
/**
 * 账单表
 * @author WJJ
 *
 */
public class Bill {
	private int bill_id;
	private Account account;
	private int bill_cost;
	private Date bill_createtime;
	private int bill_pay;
	private int bill_status;
	private String by1;
	private String by2;
	private String by3;
	private String by4;
	
	public int getBill_id() {
		return bill_id;
	}

	public Bill(int bill_id) {
		super();
		this.bill_id = bill_id;
	}



	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getBill_cost() {
		return bill_cost;
	}

	public void setBill_cost(int bill_cost) {
		this.bill_cost = bill_cost;
	}

	public Date getBill_createtime() {
		return bill_createtime;
	}

	public void setBill_createtime(Date bill_createtime) {
		this.bill_createtime = bill_createtime;
	}

	public int getBill_pay() {
		return bill_pay;
	}

	public void setBill_pay(int bill_pay) {
		this.bill_pay = bill_pay;
	}

	public int getBill_status() {
		return bill_status;
	}

	public void setBill_status(int bill_status) {
		this.bill_status = bill_status;
	}

	public String getBy1() {
		return by1;
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

	public Bill() {
		super();
	}
	
	

}
