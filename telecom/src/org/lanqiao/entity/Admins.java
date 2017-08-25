package org.lanqiao.entity;

import java.sql.Date;

/**
 * 管理员实体类
 * @author Administrator
 *
 */
public class Admins {
	private int admin_id;
	private String admin_name;
	private String admin_loginname;
	private String admin_psw;
	private String admin_img;
	private String admin_phone;
	private String admin_email;
	private Date grant_time;
	private int create_by;
	private Roles roles;
	private String by1;//备用字段1
	private String by2;//备用字段2
	private String by3;//备用字段3
	
	
	
	public Admins() {
		super();
	}
	
	public Admins(int admin_id) {
		super();
		this.admin_id = admin_id;
	}



	public Admins(int admin_id, String admin_name, String admin_loginname, String admin_phone, String admin_email) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.admin_loginname = admin_loginname;
		this.admin_phone = admin_phone;
		this.admin_email = admin_email;
	}

	

	public Admins(int admin_id, String admin_psw) {
		super();
		this.admin_id = admin_id;
		this.admin_psw = admin_psw;
	}


	public Admins(String admin_loginname, String admin_psw) {
		super();
		this.admin_loginname = admin_loginname;
		this.admin_psw = admin_psw;
	}



	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	
	public String getAdmin_loginname() {
		return admin_loginname;
	}

	public void setAdmin_loginname(String admin_loginname) {
		this.admin_loginname = admin_loginname;
	}

	public String getAdmin_psw() {
		return admin_psw;
	}
	public void setAdmin_psw(String admin_psw) {
		this.admin_psw = admin_psw;
	}
	public String getAdmin_img() {
		return admin_img;
	}
	public void setAdmin_img(String admin_img) {
		this.admin_img = admin_img;
	}
	public String getAdmin_phone() {
		return admin_phone;
	}
	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	
	public Date getGrant_time() {
		return grant_time;
	}

	public void setGrant_time(Date grant_time) {
		this.grant_time = grant_time;
	}

	public int getCreate_by() {
		return create_by;
	}
	public void setCreate_by(int create_by) {
		this.create_by = create_by;
	}
	
	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
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

	@Override
	public String toString() {
		return "Admins [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_loginname=" + admin_loginname
				+ ", admin_psw=" + admin_psw + ", admin_img=" + admin_img + ", admin_phone=" + admin_phone
				+ ", admin_email=" + admin_email + ", grant_time=" + grant_time + ", create_by=" + create_by + "]";
	}
	
	
	
}
