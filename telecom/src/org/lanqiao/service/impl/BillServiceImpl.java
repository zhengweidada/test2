package org.lanqiao.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.lanqiao.entity.Bill;
import org.lanqiao.entity.BillDetail;
import org.lanqiao.entity.BillItem;
import org.lanqiao.service.BillService;
import org.lanqiao.util.SessionUtil;

public class BillServiceImpl implements BillService {

	@Override
	public List<Bill> getAllBills() {
		SqlSession session = SessionUtil.getSession();
		List<Bill> list = session.selectList("org.lanqiao.dao.BillDao.selectAllBills");
		SessionUtil.closeSession(session);
		return list;
	}

	@Override
	public List<BillItem> getItemOfBill(Bill bill) {
		SqlSession session = SessionUtil.getSession();
		List<BillItem> list = session.selectList("org.lanqiao.dao.BillDao.selectItemOfBill", bill);
		SessionUtil.closeSession(session);
		return list;
	}

	@Override
	public List<BillDetail> getDetailOfItem(BillItem billItem) {
		SqlSession session = SessionUtil.getSession();
		List<BillDetail> list = session.selectList("org.lanqiao.dao.BillDao.selectDetailOfItem", billItem);
		SessionUtil.closeSession(session);
		return list;
	}

}
