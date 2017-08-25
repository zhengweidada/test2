package org.lanqiao.entity;

import java.util.List;

/**
 * 角色实体类
 * @author Administrator
 *
 */
public class Roles {
	//角色id
	private int role_id;
	//角色名
	private String role_name;
	private List<Permissions> list;
	
	
	public Roles() {
		super();
	}
	
	public Roles(int role_id) {
		super();
		this.role_id = role_id;
	}

	

	public Roles(String role_name) {
		super();
		this.role_name = role_name;
	}

	public Roles(int role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
	}

	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	

	public List<Permissions> getList() {
		return list;
	}

	public void setList(List<Permissions> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Roles [role_id=" + role_id + ", role_name=" + role_name + ", list=" + list + "]";
	}

	
	
	
}
