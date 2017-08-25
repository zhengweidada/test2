package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Account;

public interface AccountDao {
	/**
	 * 添加新用户
	 * @param account
	 * @return
	 */
	public int insertAccount(Account account);
	/**
	 * 根据身份证号查询用户
	 * @param account
	 * @return
	 */
	public Account selectAccountByIdCard(Account account);
	/**
	 * 根据身份证号查询用户
	 * @param account
	 * @return
	 */
	public Account selectAccountByIdCard2(Account account);
	/**
	 * 查询所有的帐户
	 * @return
	 */
	public List<Account> selectAllAccount();
	/**
	 * 根据id查询用户
	 * @param account
	 * @return
	 */
	public Account selectAccountById(Account account);
	/**
	 * 删除帐号
	 * @param account
	 * @return
	 */
	public int deleteAccount(Account account);
	/**
	 * 删除该账户下的所有业务
	 * @param account
	 * @return
	 */
	public int deleteBussessOfAccount(Account account);
	
	/**
	 * 修改账号信息
	 * @param account
	 * @return
	 */
	public int updateAccount(Account account);
	/**
	 * 更改账户为暂停状态
	 * @param account
	 * @return
	 */
	public int pauseAccountStatus(Account account);
	/**
	 * 暂停该账户下的所有的业务的状态
	 * @param account
	 * @return
	 */
	public int pauseBussessOfAccount(Account account);
	
	
	/**
	 * 重新开启账务账号
	 * @param account
	 * @return
	 */
	public int openAccountAgain(Account account);
	
	public List<Account> selectAccountByCondition(String sql, List<Object> obj);
	
}
