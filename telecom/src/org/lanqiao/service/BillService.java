package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Bill;
import org.lanqiao.entity.BillDetail;
import org.lanqiao.entity.BillItem;

public interface BillService {
	
	public List<Bill> getAllBills();
	
	public List<BillItem> getItemOfBill(Bill bill);
	
	public List<BillDetail> getDetailOfItem(BillItem billItem);

}
