package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Account;

public interface AccountService {
	/**
	 * 添加帐户
	 * @param account
	 * @return
	 */
	public boolean addAccount(Account account);
	/**
	 * 查询所有帐户
	 * @return
	 */
	public List<Account> getAllAccount();
	/**
	 * 根据id获取帐户
	 * @param account
	 * @return
	 */
	public Account gettAccountById(Account account);
	/**
	 * 删除帐号
	 * @param account
	 * @return
	 */
	public boolean delAccount(Account account);
	/**
	 * 修改账户信息
	 * @param account
	 * @param list
	 * @return
	 */
	public boolean modiAccount(Account account, List<String> list);
	/**
	 * 更改账户状态
	 * @param account
	 * @return
	 */
	public boolean pauseAccountStatus(Account account);
	/**
	 * 重新开启账户状态
	 * @param account
	 * @return
	 */
	public boolean openAccountAgain(Account account);
	/**
	 * 动态拼接sql
	 * 根据条件查询
	 * @param account
	 * @return
	 */
	public List<Account> getAccountByCondition(Account account);
	/**
	 * 根据身份证号获取账户
	 * @param account
	 * @return
	 */
	public Account getAccountByIdCard(Account account);
}
