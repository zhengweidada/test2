package org.lanqiao.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.lanqiao.dao.RoleDao;
import org.lanqiao.entity.Permissions;
import org.lanqiao.entity.Roles;
import org.lanqiao.util.ConnectDB;
public class RoleDaoImpl extends BaseDao<Roles>{
	ResultSet rs = null;
	
	
	/*@Override
	public Roles insertRole(Roles roles, Connection conn) {
		PreparedStatement ps = null;
		String sql = "insert into roles(role_name) values(?)";
		try {
			ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, roles.getRole_name());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next())
				roles.setRole_id(rs.getInt(1));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}
*/
	/*@Override
	public Roles selectRoleByName(Roles roles, Connection conn) {
		Roles r = null;
		String sql = "select role_id, role_name from roles where role_name = ?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(roles.getRole_name());
		List<Roles> list =  this.query(sql, obj, Roles.class);
		if(list != null){
			if(list.size() == 1)
				r = list.get(0);
		}
		
		return r;
	}*/

	/*@Override
	public int deleteRoleFromRolePer(Roles roles, Connection conn) {
		int rows = 0;
		String sql = "delete from roles_permissions where role_id = ?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(roles.getRole_id());
		rows = this.update(sql, obj, conn);
		return rows;
	}*/

/*	@Override
	public int updateRole(Roles roles, Connection conn) {
		int rows = 0;
		String sql = "update roles set role_name = ? where role_id = ?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(roles.getRole_name());
		obj.add(roles.getRole_id());
		rows = this.update(sql, obj, conn);
		return rows;
	}*/

	/*@Override
	public List<Roles> selectAllRoles() {
		Connection conn = ConnectDB.getConnection();
		List<Roles> list = new ArrayList<Roles>();
		String sql = "select role_id, role_name from roles";
		ResultSet rs = this.query(sql, null, conn);
		Roles r = null;
		try {
			while(rs.next()){
				r = new Roles();
				r.setRole_id(rs.getInt("role_id"));
				r.setRole_name(rs.getString("role_name"));
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
*/

	/*@Override
	public int insertRolePer(Roles roles, List<Permissions> list, Connection conn) {
		int rows[] = {};
		String sql = "insert into roles_permissions(role_id, per_id) values(?, ?);";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			for(Permissions per:list){
				ps.setInt(1, roles.getRole_id());
				ps.setInt(2, per.getPer_id());
				ps.addBatch();
			}
			rows = ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows.length;
	}
*/
	/*@Override
	public List<Roles> selectAllRoles2() {
		String sql1 = "SELECT * FROM roles;";
		String sql2 = "SELECT * FROM roles_permissions ap LEFT JOIN permissions p ON ap.`per_id`=p.`per_id` WHERE ap.`role_id`=?";
		
		List<Roles> rList = this.query(sql1, null, Roles.class);
		System.out.println(rList);
		List<Permissions> pList = null;
		List<Object> obj = null;
		Connection conn2 = ConnectDB.getConnection();
		for(Roles r:rList){
			obj = new ArrayList<Object>();
			obj.add(r.getRole_id());
			rs = this.query(sql2, obj, conn2);
			Permissions p = null;
			pList = new ArrayList<Permissions>();
			try {
				while(rs.next()){
					p = new Permissions();
					p.setPer_id(rs.getInt("per_id"));
					p.setPer_name(rs.getString("pername"));
					p.setPurl(rs.getString("purl"));
					p.setPclass(rs.getString("pclass"));
					pList.add(p);
					r.setList(pList);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rList;
	}
*/
	/*@Override
	public int deleteRoleFromRole(Roles roles, Connection conn) {
		int rows = 0;
		String sql = "delete from roles where role_id = ?";
		List<Object> obj = new ArrayList<Object>();
		obj.add(roles.getRole_id());
		rows = this.update(sql, obj, conn);
		return rows;
	}*/
	
	

}
