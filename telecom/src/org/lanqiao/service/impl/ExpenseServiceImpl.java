package org.lanqiao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.lanqiao.dao.ExpenseDao;
import org.lanqiao.entity.Expenses;
import org.lanqiao.service.ExpenseService;
import org.lanqiao.util.SessionUtil;

public class ExpenseServiceImpl implements ExpenseService {
	
	@Override
	public boolean addExp(Expenses exp) {
		SqlSession session = SessionUtil.getSession();
		int rows = session.insert("org.lanqiao.dao.ExpenseDao.insertExp", exp);
		session.commit();
		SessionUtil.closeSession(session);
		if(rows > 0)
			return true;
		return false;
	}

	@Override
	public List<Expenses> getAllExpense() {
		SqlSession session = SessionUtil.getSession();
		ExpenseDao expenseDao = session.getMapper(ExpenseDao.class);
		List<Expenses> list = expenseDao.selectAllExpense();
		for(Expenses e:list){}
		
		session.commit();
		SessionUtil.closeSession(session);
		return list;
	}

	@Override
	public boolean startExpense(Expenses exp) {
		SqlSession session = SessionUtil.getSession();
		int rows = session.update("org.lanqiao.dao.ExpenseDao.startExpense", exp);
		session.commit();
		SessionUtil.closeSession(session);
		if(rows >0 )
			return true;
		return false;
	}

	@Override
	public Expenses getExpenseById(Expenses exp) {
		SqlSession session = SessionUtil.getSession();
		ExpenseDao expenseDao = session.getMapper(ExpenseDao.class);
		Expenses expenses = expenseDao.selectExpenseById(exp);
		session.commit();
		SessionUtil.closeSession(session);
		return expenses;
	}

	@Override
	public boolean modifyExpense(Expenses exp) {
		SqlSession session = SessionUtil.getSession();
		int rows = session.update("org.lanqiao.dao.ExpenseDao.updateExpense", exp);
		session.commit();
		SessionUtil.closeSession(session);
		if(rows > 0)
			return true;
		return false;
	}

	@Override
	public boolean delExpense(Expenses exp) {
		SqlSession session = SessionUtil.getSession();
		int rows = session.update("org.lanqiao.dao.ExpenseDao.deleteExpense", exp);
		session.commit();
		SessionUtil.closeSession(session);
		if(rows > 0)
			return true;
		return false;
	}

	@Override
	public List<Expenses> sortExpense(String sort, String field) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		if("du".equals(field)){
			map.put("field", 1);
			if("asc".equals(sort)){
				map.put("sort", 0);
			}else{
				map.put("sort", 1);
			}
		}else if("cost".equals(field)){
			map.put("field", 2);
			if("asc".equals(sort)){
				map.put("sort", 0);
			}else{
				map.put("sort", 1);
			}
		}else if("dura".equals(field)){
			map.put("field", 3);
			if("asc".equals(sort)){
				map.put("sort", 0);
			}else{
				map.put("sort", 1);
			}
		}
		SqlSession session = SessionUtil.getSession();
		ExpenseDao expenseDao = session.getMapper(ExpenseDao.class);
		 List<Expenses> list = expenseDao.sortExpenses(map);
		SessionUtil.closeSession(session);
		return list;
	}

}
