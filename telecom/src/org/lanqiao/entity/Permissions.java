package org.lanqiao.entity;

/**
 * 权限实体类
 * @author Administrator
 *
 */
public class Permissions {
	//权限id
	private int per_id;
	//权限名
	private String pername;
	private String purl;
	private String pclass;
	
	
	public Permissions() {
		super();
	}
	

	public Permissions(int per_id) {
		super();
		this.per_id = per_id;
	}

	public Permissions(int per_id, String per_name) {
		super();
		this.per_id = per_id;
		this.pername = per_name;
	}
	
	public int getPer_id() {
		return per_id;
	}
	public void setPer_id(int per_id) {
		this.per_id = per_id;
	}
	public String getPer_name() {
		return pername;
	}
	public void setPer_name(String per_name) {
		this.pername = per_name;
	}

	public String getPurl() {
		return purl;
	}

	public void setPurl(String purl) {
		this.purl = purl;
	}


	public String getPclass() {
		return pclass;
	}


	public void setPclass(String pclass) {
		this.pclass = pclass;
	}


	@Override
	public String toString() {
		return "Permissions [per_id=" + per_id + ", per_name=" + pername + ", purl=" + purl + ", pclass=" + pclass
				+ "]";
	}
	
	

}
