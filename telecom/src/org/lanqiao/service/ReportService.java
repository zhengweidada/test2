package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Report;

public interface ReportService {
	
	/**
	 * 获取所有的报表信息
	 * @return
	 */
	public List<Report> getAllReports();
	
	public List<Report> getReportsByDuration();

}
