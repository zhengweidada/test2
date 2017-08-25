package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao.AdminDao;
import org.lanqiao.entity.Admins;
import org.lanqiao.entity.Paging;
import org.lanqiao.entity.Permissions;
import org.lanqiao.entity.Roles;
import org.lanqiao.util.ConnectDB;

public class AdminsDaoImpl{
	
	/*@Override
	public Admins insertAdmin(Admins admins) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admins a = null;
		String sql = "insert into admins(admin_name, admin_loginname, admin_psw, admin_img, admin_phone,"
				+ "admin_email, grant_time, create_by) values(?, ?, ?, ?, ?, ?, (SELECT SYSDATE() AS systemtime), ?)";
		try {
			ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, admins.getAdmin_name());
			ps.setString(2, admins.getAdmin_loginname());
			ps.setString(3, admins.getAdmin_psw());
			ps.setString(4, admins.getAdmin_img());
			ps.setString(5, admins.getAdmin_phone());
			ps.setString(6, admins.getAdmin_email());
			ps.setInt(7, admins.getCreate_by());
			
			if(ps.executeUpdate() > 0){
				rs = ps.getGeneratedKeys();
				if(rs.next())
					a = new Admins(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int insertAdminRole(Admins admins) {
		int rows = 0;
		System.out.println(admins.getAdmin_id()+"--"+admins.getRoles().getRole_id());
		String sql = "insert into admins_roles(admin_id, role_id) values(?, ?)";
		List<Object> obj = new ArrayList<Object>();
		obj.add(admins.getAdmin_id());
		obj.add(admins.getRoles().getRole_id());
		rows = this.update(sql, obj, conn);
		System.out.println("insertAdminRole"+rows);
		return rows;
	}

	
	@Override
	public List<Admins> selectAllAdmins() {
		ResultSet rs = null;
		Connection conn = ConnectDB.getConnection();
		//String sql = "SELECT a.admin_id,a.admin_name,a.admin_loginname, a.admin_phone, a.admin_email,a.grant_time,a_r.role_id, a_r.role_name FROM (SELECT ar.admin_id, ar.role_id,r.role_name FROM admins_roles ar, roles r WHERE ar.role_id = r.role_id)a_r, admins a WHERE a_r.admin_id = a.admin_id";
		String sql = "SELECT * FROM (SELECT a.*,ar.role_id FROM admins a LEFT JOIN admins_roles ar ON a.admin_id = ar.admin_id) a_r LEFT JOIN roles r ON a_r.role_id = r.role_id ORDER BY admin_id LIMIT 0, 8;";
		
		rs = this.query(sql, null, conn);
		List<Admins> list = adminsIterator2(rs);
		return list;
	}

	@Override
	public List<Permissions> selectPermitByRoles(Roles roles) {
		Connection conn = ConnectDB.getConnection();
		ResultSet rs = null;
		List<Permissions> pList = new ArrayList<Permissions>();
		String sql = "SELECT * FROM roles_permissions rp, permissions p WHERE rp.`per_id`=p.`per_id` AND rp.`role_id` = ?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(roles.getRole_id());
		rs = this.query(sql, obj, conn);
		Permissions per = null;
		try {
			while(rs.next()){
				per = new Permissions();
				per.setPer_id(rs.getInt("per_id"));
				per.setPer_name(rs.getString("pername"));
				pList.add(per);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}

	@Override
	public int updateAdmin(Admins admins) {
		int rows = 0;
		Connection conn = ConnectDB.getConnection();
		String sql = "update admins set admin_name=?,admin_loginname=?,admin_phone=?, admin_email=? where admin_id=?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(admins.getAdmin_name());
		obj.add(admins.getAdmin_loginname());
		obj.add(admins.getAdmin_phone());
		obj.add(admins.getAdmin_email());
		obj.add(admins.getAdmin_id());
		rows = this.update(sql, obj, conn);
		return rows;
	}

	@Override
	public int deleteAdminFromRelation(Admins admins, Connection conn) {
		ResultSet rs = null;
		int rows = 0;
		String sql1 = "select * from admins_roles where admin_id = "+admins.getAdmin_id();
		rs = this.query(sql1, null, conn);
		try {
			if(rs.next()){
				String sql = "delete from admins_roles where admin_id = ?";
				List<Object> obj = new ArrayList<Object>();
				obj.add(admins.getAdmin_id());
				rows = this.update(sql, obj, conn);
			}
			else{
				return 1;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	@Override
	public List<Permissions> perOfAdmin(Admins admins) {
		Connection conn = ConnectDB.getConnection();
		ResultSet rs = null;
		List<Permissions> pList = new ArrayList<Permissions>();
		String sql = "SELECT * FROM permissions WHERE per_id IN(SELECT rp.`per_id` FROM roles_permissions rp WHERE rp.`role_id` IN (SELECT ar.`role_id` FROM admins_roles ar WHERE ar.`admin_id`=?))";
		List<Object> obj = new ArrayList<Object>();
		obj.add(admins.getAdmin_id());
		rs = this.query(sql, obj, conn);
		Permissions per = null;
		try {
			while(rs.next()){
				per = new Permissions();
				per.setPer_id(rs.getInt("per_id"));
				per.setPer_name(rs.getString("pername"));
				per.setPurl(rs.getString("purl"));
				per.setPclass(rs.getString("pclass"));
				pList.add(per);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pList;
	}
	
	private Admins adminIterator(ResultSet rs){
		Admins admins2 = null;
		try {
			while(rs.next()){
				admins2 = new Admins();
				admins2.setAdmin_id(rs.getInt("admin_id"));
				admins2.setAdmin_name(rs.getString("admin_name"));
				admins2.setAdmin_loginname(rs.getString("admin_loginname"));
				admins2.setAdmin_phone(rs.getString("admin_phone"));
				admins2.setAdmin_email(rs.getString("admin_email"));
				admins2.setGrant_time(rs.getDate("grant_time"));
				admins2.setRoles(new Roles(rs.getInt("role_id"), rs.getString("role_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admins2;
	}
	
	public List<Admins> adminsIterator2(ResultSet rs){
		List<Admins> list = new ArrayList<Admins>();
		Admins admins = null;
		Roles roles = null;
		try {
			while(rs.next()){
				admins = new Admins();
				roles = new Roles();
				admins.setAdmin_id(rs.getInt("admin_id"));
				admins.setAdmin_name(rs.getString("admin_name"));
				admins.setAdmin_loginname(rs.getString("admin_loginname"));
				admins.setAdmin_phone(rs.getString("admin_phone"));
				admins.setAdmin_email(rs.getString("admin_email"));
				admins.setGrant_time(rs.getDate("grant_time"));
				roles.setRole_id(rs.getInt("role_id"));
				roles.setRole_name(rs.getString("role_name"));
				List<Permissions> pList = this.selectPermitByRoles(roles);
				roles.setList(pList);
				admins.setRoles(roles);
				list.add(admins);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list; 
	}

	
	@Override
	public Admins selectAdminByLoginName(Admins admins) {
		Connection conn = ConnectDB.getConnection();
		ResultSet rs = null;
		String sql = "SELECT * FROM admins a,(SELECT ar.admin_id, r.role_id, r.role_name FROM admins_roles ar, roles r WHERE ar.role_id =  r.role_id) a_r WHERE a.admin_id=a_r.admin_id AND admin_loginname = ? AND admin_psw = ?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(admins.getAdmin_loginname());
		obj.add(admins.getAdmin_psw());
		rs = this.query(sql, obj, conn);
		return adminIterator(rs);
	}

	@Override
	public Admins selectAdminsById(Admins admins) {
		Connection conn = ConnectDB.getConnection();
		ResultSet rs = null;
		String sql = "SELECT * FROM admins a,(SELECT ar.admin_id, r.role_id, r.role_name FROM admins_roles ar, roles r WHERE ar.role_id =  r.role_id) a_r WHERE a.admin_id=a_r.admin_id AND a.admin_id = ?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(admins.getAdmin_id());
		rs = this.query(sql, obj, conn);
		return adminIterator(rs);
	}

	@Override
	public Admins selectAdminsByPsw(Admins admins) {
		Connection conn = ConnectDB.getConnection();
		ResultSet rs = null;
		String sql = "select * from admins where admin_id = ? and admin_psw = ?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(admins.getAdmin_id());
		obj.add(admins.getAdmin_psw());
		rs = this.query(sql, obj, conn);
		Admins admins2 = null;
		try {
			while(rs.next()){
				admins2 = new Admins();
				admins2.setAdmin_id(rs.getInt("admin_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admins2;
	}

	@Override
	public int updateAdminPsw(List<Admins> list, Connection conn) {
		int rows[] = {};
		String sql = "update admins set admin_psw = ? where admin_id = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			for(Admins a:list){
				ps.setString(1, a.getAdmin_psw());
				ps.setInt(2, a.getAdmin_id());
				ps.addBatch();
			}
			rows = ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows.length;
	}

	@Override
	public List<Admins> selectAdminsOfRoles(Roles roles) {
		Connection conn = ConnectDB.getConnection();
		ResultSet rs = null;
		String sql = "SELECT * FROM admins a,(SELECT ar.admin_id, r.role_id, r.role_name FROM admins_roles ar, roles r WHERE ar.role_id =  r.role_id) a_r WHERE a.admin_id=a_r.admin_id AND role_name LIKE '%"+roles.getRole_name()+"%'";
		rs = this.query(sql, null, conn);
		List<Admins> list = adminsIterator2(rs);
		return list;
	}

	@Override
	public int deleteAdmin(Admins admins) {
		Connection conn = ConnectDB.getConnection();
		int rows = 0;
		String sql = "delete from admins where admin_id = ?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(admins.getAdmin_id());
		rows = this.update(sql, obj, conn);
		return rows;
	}

	@Override
	public int updateAdminPsw(Admins admins) {
		int rows = 0;
		String sql = "update admins set admin_psw = ? where admin_id = ?";
		Connection conn = ConnectDB.getConnection();
		List<Object> obj = new ArrayList<Object>();
		obj.add(admins.getAdmin_psw());
		obj.add(admins.getAdmin_id());
		rows = this.update(sql, obj, conn);
		return rows;
	}

	@Override
	public List<Admins> selectAllAdmins(Paging page) {
		Connection conn = ConnectDB.getConnection();
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT a.*,ar.role_id FROM admins a LEFT JOIN admins_roles ar ON a.admin_id = ar.admin_id) a_r LEFT JOIN roles r ON a_r.role_id = r.role_id ORDER BY admin_id LIMIT ?, ?;";
		List<Object> obj = new ArrayList<Object>();
		obj.add((page.getCurrPage()-1)*page.getPageSize());
		obj.add(page.getPageSize());
		rs = this.query(sql, obj, conn);
		List<Admins> list = adminsIterator2(rs);
		return list;
	}
*/
}
