package org.lanqiao.entity;

import java.sql.Timestamp;
/**
 * 资费实体类
 * @author WJJ
 *
 */
public class Expenses {
	private int eps_id;
	private String eps_name;
	private int eps_type;
	private int eps_duration;
	private double eps_cost;
	private double eps_unitc;
	private String eps_desc;
	private Timestamp eps_createtime;
	private Timestamp eps_starttime;
	private int eps_status;
	private String by1;
	private String by2;
	private String by3;
	private String by4;
	
	
	public Expenses() {
		super();
	}
	
	
	public Expenses(int eps_id) {
		super();
		this.eps_id = eps_id;
	}


	public int getEps_id() {
		return eps_id;
	}


	public void setEps_id(int eps_id) {
		this.eps_id = eps_id;
	}


	public String getEps_name() {
		return eps_name;
	}


	public void setEps_name(String eps_name) {
		this.eps_name = eps_name;
	}


	public int getEps_type() {
		return eps_type;
	}


	public void setEps_type(int eps_type) {
		this.eps_type = eps_type;
	}


	public int getEps_duration() {
		return eps_duration;
	}


	public void setEps_duration(int eps_duration) {
		this.eps_duration = eps_duration;
	}


	public double getEps_cost() {
		return eps_cost;
	}


	public void setEps_cost(double eps_cost) {
		this.eps_cost = eps_cost;
	}


	public double getEps_unitc() {
		return eps_unitc;
	}


	public void setEps_unitc(double eps_unitc) {
		this.eps_unitc = eps_unitc;
	}


	public String getEps_desc() {
		return eps_desc;
	}


	public void setEps_desc(String eps_desc) {
		this.eps_desc = eps_desc;
	}


	public Timestamp getEps_createtime() {
		return eps_createtime;
	}


	public void setEps_createtime(Timestamp eps_createtime) {
		this.eps_createtime = eps_createtime;
	}


	public Timestamp getEps_starttime() {
		return eps_starttime;
	}


	public void setEps_starttime(Timestamp eps_starttime) {
		this.eps_starttime = eps_starttime;
	}


	public int getEps_status() {
		return eps_status;
	}


	public void setEps_status(int eps_status) {
		this.eps_status = eps_status;
	}


	public String getBy1() {
		return by1;
	}


	public void setBy1(String by1) {
		this.by1 = by1;
	}


	public String getBy2() {
		return by2;
	}


	public void setBy2(String by2) {
		this.by2 = by2;
	}


	public String getBy3() {
		return by3;
	}


	public void setBy3(String by3) {
		this.by3 = by3;
	}


	public String getBy4() {
		return by4;
	}


	public void setBy4(String by4) {
		this.by4 = by4;
	}
	
}
