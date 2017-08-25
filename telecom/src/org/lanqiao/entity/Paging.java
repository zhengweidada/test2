package org.lanqiao.entity;

/**
 * 分页对象
 * @author Administrator
 *
 */
public class Paging {
	private int currPage;
	private int totalRecord;
	private int totalPage;
	private int pageSize;
	
	public Paging() {
		super();
	}
	
	public Paging(int currPage) {
		super();
		this.currPage = currPage;
	}


	public Paging(int currPage, int totalRecord, int totalPage, int pageSize) {
		super();
		this.currPage = currPage;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
	}

	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "Paging [currPage=" + currPage + ", totalRecord=" + totalRecord + ", totalPage=" + totalPage
				+ ", pageSize=" + pageSize + "]";
	}

}
