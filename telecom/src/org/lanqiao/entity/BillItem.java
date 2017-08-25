package org.lanqiao.entity;

/**
 * 账单明细表
 * @author WJJ
 *
 */
public class BillItem {
	private int item_id;
	private double item_duration;
	private double item_cost;
	private Bussess bussess;
	private Expenses expenses;
	private Bill bill;
	public BillItem() {
		super();
	}
	
	
	public BillItem(int item_id) {
		super();
		this.item_id = item_id;
	}


	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public double getItem_duration() {
		return item_duration;
	}
	public void setItem_duration(double item_duration) {
		this.item_duration = item_duration;
	}
	public double getItem_cost() {
		return item_cost;
	}
	public void setItem_cost(double item_cost) {
		this.item_cost = item_cost;
	}
	public Bussess getBussess() {
		return bussess;
	}
	public void setBussess(Bussess bussess) {
		this.bussess = bussess;
	}
	public Expenses getExpenses() {
		return expenses;
	}
	public void setExpenses(Expenses expenses) {
		this.expenses = expenses;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	

}
