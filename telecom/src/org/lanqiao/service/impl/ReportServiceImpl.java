package org.lanqiao.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.lanqiao.entity.Report;
import org.lanqiao.service.ReportService;
import org.lanqiao.util.SessionUtil;

public class ReportServiceImpl implements ReportService {

	@Override
	public List<Report> getAllReports() {
		SqlSession session = SessionUtil.getSession();
		List<Report> list = session.selectList("org.lanqiao.dao.ReportDao.selectAllReports");
		SessionUtil.closeSession(session);
		return list;
	}

	@Override
	public List<Report> getReportsByDuration() {
		SqlSession session = SessionUtil.getSession();
		List<Report> list = session.selectList("org.lanqiao.dao.ReportDao.selectReportsByDuration");
		SessionUtil.closeSession(session);
		return list;
	}

}
