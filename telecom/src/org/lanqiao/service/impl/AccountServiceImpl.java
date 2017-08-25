package org.lanqiao.service.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.lanqiao.dao.AccountDao;
import org.lanqiao.entity.Account;
import org.lanqiao.service.AccountService;
import org.lanqiao.util.SessionUtil;

public class AccountServiceImpl implements AccountService {
	
	
	@Override
	public boolean addAccount(Account account) {
		SqlSession session = SessionUtil.getSession();
		AccountDao accountDao = session.getMapper(AccountDao.class);
		int rows = -1;
		if(account.getReferee_idcard() != null && !"".equals(account.getReferee_idcard())){
			//Account account2 = session.selectOne("org.lanqiao.dao.AccountDao.selectAccountByIdCard", account);
			Account account2 = accountDao.selectAccountByIdCard(account);
			System.out.println("查询前："+account);
			System.out.println("查询："+account2);
			
			rows = session.insert("org.lanqiao.dao.AccountDao.insertAccount", account2);
		}else{
			rows = session.insert("org.lanqiao.dao.AccountDao.insertAccount", account);
		}
		session.commit();
		SessionUtil.closeSession(session);
		return (rows > 0)?true:false;
	}

	@Override
	public List<Account> getAllAccount() {
		SqlSession session = SessionUtil.getSession();
		List<Account> list = session.selectList("org.lanqiao.dao.AccountDao.selectAllAccount");
		SessionUtil.closeSession(session);
		return list;
	}

	@Override
	public Account gettAccountById(Account account) {
		SqlSession session = SessionUtil.getSession();
		Account account2 = session.selectOne("org.lanqiao.dao.AccountDao.selectAccountById", account);
		SessionUtil.closeSession(session);
		return account2;
	}

	@Override
	public boolean delAccount(Account account) {
		SqlSession session = SessionUtil.getSession();
		boolean flag = true;
		try {
			session.update("org.lanqiao.dao.AccountDao.deleteAccount", account);
			session.update("org.lanqiao.dao.AccountDao.deleteBussessOfAccount", account);
			session.commit();
		} catch (Exception e) {
			flag = false;
			session.rollback();
			e.printStackTrace();
		}finally {
			SessionUtil.closeSession(session);
		}
		return flag;
	}

	@Override
	public boolean modiAccount(Account account, List<String> list) {
		SqlSession session = SessionUtil.getSession();
		boolean flag = true;
		Account account2 = session.selectOne("org.lanqiao.dao.AccountDao.selectAccountById", account);
		
		String old_psw = account2.getUser_psw();
		if(list != null){
			if(old_psw.equals(list.get(0))){
				account.setUser_psw(list.get(1));
			}else{
				account.setUser_psw(old_psw);
			}
		}else{
			account.setUser_psw(old_psw);
		}

		try {
			if(account.getReferee_idcard() != null && !"".equals(account.getReferee_idcard())){
				Account account3 = session.selectOne("org.lanqiao.dao.AccountDao.selectAccountByIdCard", account);
				account.setReferee_id(account3.getAccount_id());
				session.update("org.lanqiao.dao.AccountDao.updateAccount", account);
			}else {
				session.update("org.lanqiao.dao.AccountDao.updateAccount", account);
			}
			session.commit();
		} catch (Exception e) {
			flag = false;
			session.rollback();
			e.printStackTrace();
		}finally {
			SessionUtil.closeSession(session);
		}
		return flag;
	}

	@Override
	public boolean pauseAccountStatus(Account account) {
		SqlSession session = SessionUtil.getSession();
		boolean flag = true;
		try {
			session.update("org.lanqiao.dao.AccountDao.pauseAccountStatus", account);
			session.update("org.lanqiao.dao.AccountDao.pauseBussessOfAccount", account);
			session.commit();
		} catch (Exception e) {
			flag = false;
			session.rollback();
			e.printStackTrace();
		}finally {
			SessionUtil.closeSession(session);
		}
		return flag;
	}

	@Override
	public boolean openAccountAgain(Account account) {
		SqlSession session = SessionUtil.getSession();
		boolean flag = true;
		try {
			session.update("org.lanqiao.dao.AccountDao.openAccountAgain", account);
			session.commit();
		} catch (Exception e) {
			flag = false;
			session.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Account> getAccountByCondition(Account account) {
		SqlSession session = SessionUtil.getSession();
		List<Account> list = session.selectList("org.lanqiao.dao.AccountDao.selectAccountByCondition", account);
		SessionUtil.closeSession(session);
		return list;
	}

	@Override
	public Account getAccountByIdCard(Account account) {
		SqlSession session = SessionUtil.getSession();
		Account account2 = session.selectOne("org.lanqiao.dao.AccountDao.selectAccountByIdCard", account);
		SessionUtil.closeSession(session);
		return account2;
	
	}

}
