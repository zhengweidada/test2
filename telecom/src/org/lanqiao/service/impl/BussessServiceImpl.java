package org.lanqiao.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.lanqiao.entity.Bussess;
import org.lanqiao.service.BussessService;
import org.lanqiao.util.SessionUtil;

public class BussessServiceImpl implements BussessService {
	
	@Override
	public boolean addBussess(Bussess bussess) {
		SqlSession session = SessionUtil.getSession();
		int rows = session.insert("org.lanqiao.dao.BussessDao.insertBussess", bussess);
		session.commit();
		SessionUtil.closeSession(session);
		if(rows > 0)
			return true;
		return false;
	}

	@Override
	public List<Bussess> getAllBussesses() {
		SqlSession session = SessionUtil.getSession();
		List<Bussess> list = session.selectList("org.lanqiao.dao.BussessDao.selectAllBussesses");
		SessionUtil.closeSession(session);
		return list;
	}

	@Override
	public boolean changeBussessStatus(Bussess bussess) {
		SqlSession session = SessionUtil.getSession();
		int rows = session.update("org.lanqiao.dao.BussessDao.changeBussessStatus", bussess);
		if(rows > 0)
			return true;
		return false;
	}

	@Override
	public Bussess getedBussessById(Bussess bussess) {
		SqlSession session = SessionUtil.getSession();
		Bussess bussess2 = session.selectOne("org.lanqiao.dao.BussessDao.selectedBussessById", bussess);
		SessionUtil.closeSession(session);
		return bussess2;
	}

	@Override
	public boolean modifyBussess(Bussess bussess) {
		SqlSession session = SessionUtil.getSession();
		int rows = session.update("org.lanqiao.dao.BussessDao.updateBussess", bussess);
		session.commit();
		SessionUtil.closeSession(session);
		if(rows > 0)
			return true;
		return false;
	}

	@Override
	public List<Bussess> getBussessByCondition(Bussess bussess) {
		SqlSession session = SessionUtil.getSession();
		List<Bussess> list = session.selectList("org.lanqiao.dao.BussessDao.selectBussessByCondition", bussess);
		SessionUtil.closeSession(session);
		return list;
	}

}
