package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Bill;
import org.lanqiao.entity.BillDetail;
import org.lanqiao.entity.BillItem;

public interface BillDao {
	
	public List<Bill> selectAllBills();
	
	public List<BillItem> selectItemOfBill(Bill bill);
	
	public List<BillDetail> selectDetailOfItem(BillItem billItem);

}
