package org.lanqiao.entity;


import java.sql.Date;
import java.sql.Timestamp;

/**
 * 用户信息实体类
 * @author WJJ
 *
 */
public class Account {
	private int account_id;
	private String user_name;
	private String user_login_name;
	private String user_psw;
	private String user_idcard;
	private String birth;
	private int sex;
	private String user_phone;
	private String email;
	private String qq;
	private Date user_createtime;
	private int user_status;
	private Timestamp service_time;
	private Timestamp last_login_time;
	private String last_login_ip;
	private String job;
	private String address;
	private String user_code;
	private int referee_id;
	private String referee_idcard;
	private String by1;
	private String by2;
	private String by3;
	private String by4;
	
	public Account() {
		super();
	}
	
	public Account(int account_id) {
		super();
		this.account_id = account_id;
	}
	
	public Account(String user_idcard) {
		super();
		this.user_idcard = user_idcard;
	}

	public Account(String user_name, String user_login_name, String user_psw, String user_idcard, String birth, int sex,
			String user_phone, String email, String qq, String job, String address, String code,
			String referee_idcard) {
		super();
		this.user_name = user_name;
		this.user_login_name = user_login_name;
		this.user_psw = user_psw;
		this.user_idcard = user_idcard;
		this.birth = birth;
		this.sex = sex;
		this.user_phone = user_phone;
		this.email = email;
		this.qq = qq;
		this.job = job;
		this.address = address;
		this.user_code = code;
		this.referee_idcard = referee_idcard;
	}

	
	public Account(String user_name, String user_login_name, String user_idcard, int user_status) {
		super();
		this.user_name = user_name;
		this.user_login_name = user_login_name;
		this.user_idcard = user_idcard;
		this.user_status = user_status;
	}

	public Account(int account_id, String user_name, String user_login_name, String user_idcard, String birth, int sex,
			String user_phone, String email, String qq, String job, String address, String user_code,
			String referee_idcard) {
		super();
		this.account_id = account_id;
		this.user_name = user_name;
		this.user_login_name = user_login_name;
		this.user_idcard = user_idcard;
		this.birth = birth;
		this.sex = sex;
		this.user_phone = user_phone;
		this.email = email;
		this.qq = qq;
		this.job = job;
		this.address = address;
		this.user_code = user_code;
		this.referee_idcard = referee_idcard;
	}

	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_login_name() {
		return user_login_name;
	}
	public void setUser_login_name(String user_login_name) {
		this.user_login_name = user_login_name;
	}
	public String getUser_psw() {
		return user_psw;
	}
	public void setUser_psw(String user_psw) {
		this.user_psw = user_psw;
	}
	public String getUser_idcard() {
		return user_idcard;
	}
	public void setUser_idcard(String user_idcard) {
		this.user_idcard = user_idcard;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Date getUser_createtime() {
		return user_createtime;
	}
	public void setUser_createtime(Date timestamp) {
		this.user_createtime = timestamp;
	}
	
	
	public int getUser_status() {
		return user_status;
	}

	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}



	public String getLast_login_ip() {
		return last_login_ip;
	}
	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUser_code() {
		return user_code;
	}
	
	public Timestamp getService_time() {
		return service_time;
	}

	public void setService_time(Timestamp service_time) {
		this.service_time = service_time;
	}



	public Timestamp getLast_login_time() {
		return last_login_time;
	}



	public void setLast_login_time(Timestamp last_login_time) {
		this.last_login_time = last_login_time;
	}



	
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public int getReferee_id() {
		return referee_id;
	}
	public void setReferee_id(int referee_id) {
		this.referee_id = referee_id;
	}
	public String getReferee_idcard() {
		return referee_idcard;
	}
	public void setReferee_idcard(String referee_idcard) {
		this.referee_idcard = referee_idcard;
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

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", user_name=" + user_name + ", user_login_name=" + user_login_name
				+ ", user_psw=" + user_psw + ", user_idcard=" + user_idcard + ", birth=" + birth + ", sex=" + sex
				+ ", user_phone=" + user_phone + ", email=" + email + ", qq=" + qq + ", user_createtime="
				+ user_createtime + ", user_status=" + user_status + ", service_time=" + service_time
				+ ", last_login_time=" + last_login_time + ", last_login_ip=" + last_login_ip + ", job=" + job
				+ ", address=" + address + ", user_code=" + user_code + ", referee_id=" + referee_id
				+ ", referee_idcard=" + referee_idcard + "]";
	}
	
	
	

}
