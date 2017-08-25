package org.lanqiao.dao;

import java.util.List;
import java.util.Map;

import org.lanqiao.entity.Expenses;



public interface ExpenseDao {
	/**
	 * 添加资费信息
	 * @param exp
	 * @return
	 */
	public int insertExp(Expenses exp);
	/**
	 * 查询所有资费信息
	 * 初始状态下查询前8条
	 * @return
	 */
	public List<Expenses> selectAllExpense();
	/**
	 * 根据不同的条件对资费进行排序
	 * @return
	 */
	public List<Expenses> sortExpenses(Map<String, Integer> map);
	
	/**
	 * 启用资费
	 * @param exp
	 * @return
	 */
	public int startExpense(Expenses exp);
	/**
	 * 根据资费id查询资费
	 * @param exp
	 * @return
	 */
	public Expenses selectExpenseById(Expenses exp);
	/**
	 * 修改资费的信息
	 * @param exp
	 * @return
	 */
	public int updateExpense(Expenses exp);
	/**
	 * 删除资费信息
	 * @param exp
	 * @return
	 */
	public int deleteExpense(Expenses exp);

}
