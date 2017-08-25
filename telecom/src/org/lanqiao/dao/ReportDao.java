package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Report;

public interface ReportDao {
	/**
	 * 查询所有的报表
	 * @return
	 */
	public List<Report> selectAllReports();
	/**
	 * 每台服务器上累计时长最高的前三名客户
	 * 根据服务器ip和时长进行排序
	 * @return
	 */
	public List<Report> selectReportsByDuration();
	/**
	 * 每台服务器每种资费标准的使用次数
	 * @return
	 */
	/*public List<Report> selectReportsByExpense();*/
	
	
	
	

}
