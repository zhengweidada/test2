package org.lanqiao.entity;

import java.sql.Timestamp;

/**
 * 账单详单表
 * @author WJJ
 *
 */
public class BillDetail {
	private int detail_id;
	private Timestamp detail_login_time;
	private Timestamp detail_logout_time;
	private double detail_duration;
	private double detail_cost;
	private BillItem billItem;
	
	
	
	public BillDetail() {
		super();
	}
	public int getDetail_id() {
		return detail_id;
	}
	public void setDetail_id(int detail_id) {
		this.detail_id = detail_id;
	}
	public Timestamp getDetail_login_time() {
		return detail_login_time;
	}
	public void setDetail_login_time(Timestamp detail_login_time) {
		this.detail_login_time = detail_login_time;
	}
	public Timestamp getDetail_logout_time() {
		return detail_logout_time;
	}
	public void setDetail_logout_time(Timestamp detail_logout_time) {
		this.detail_logout_time = detail_logout_time;
	}
	public double getDetail_duration() {
		return detail_duration;
	}
	public void setDetail_duration(double detail_duration) {
		this.detail_duration = detail_duration;
	}
	public double getDetail_cost() {
		return detail_cost;
	}
	public void setDetail_cost(double detail_cost) {
		this.detail_cost = detail_cost;
	}
	public BillItem getBillItem() {
		return billItem;
	}
	public void setBillItem(BillItem billItem) {
		this.billItem = billItem;
	}

}
