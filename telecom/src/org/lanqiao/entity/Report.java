package org.lanqiao.entity;

public class Report {
	private Account account;
	private BillItem billItem;
	
	public Report() {
		super();
	}
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public BillItem getBillItem() {
		return billItem;
	}
	public void setBillItem(BillItem billItem) {
		this.billItem = billItem;
	}

}
