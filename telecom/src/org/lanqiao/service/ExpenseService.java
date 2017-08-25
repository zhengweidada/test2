package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Expenses;



public interface ExpenseService {
	/**
	 * 添加资费信息
	 * @param exp
	 * @return
	 */
	public boolean addExp(Expenses exp);
	/**
	 * 查询所有资费信息
	 * @return
	 */
	public List<Expenses> getAllExpense();
	/**
	 * 启用资费
	 * @param exp
	 * @return
	 */
	public boolean startExpense(Expenses exp);
	/**
	 * 根据id查询资费
	 * @param exp
	 * @return
	 */
	public Expenses getExpenseById(Expenses exp);
	/**
	 * 修改资费信息
	 * @param exp
	 * @return
	 */
	public boolean modifyExpense(Expenses exp);
	/**
	 * 删除资费信息
	 * @param exp
	 * @return
	 */
	public boolean delExpense(Expenses exp);
	
	public List<Expenses> sortExpense(String sort, String field);

}
