package org.lanqiao.dao;


import java.util.List;
import java.util.Map;

import org.lanqiao.entity.Roles;

public interface RoleDao {
	/**
	 * 查询所有的角色信息，只查一张表
	 * @return
	 */
	public List<Roles> selectAllRoles();
	/**
	 * 两次查询，查询所有该角色对应的权限信息
	 * @return
	 */
	public List<Roles> selectAllRoles2();
	/**
	 * 插入角色信息
	 * @param roles
	 * @return
	 */
	public int insertRole(Roles roles);
	/**
	 * 批量向角色-权限添加对应信息
	 * 向roles_permissions添加权限对应关系
	 * @param roles
	 * @param list
	 * @return
	 */
	public int insertRolePer(Map<String, Object> map);
	
	
	/**
	 * 根据姓名查询角色
	 * @param roles
	 * @return
	 */
	//public Roles selectRoleByName(Roles roles, Connection conn);
	
	/**
	 * 删除角色角色权限表信息
	 * @param roles
	 * @return
	 */
	public int deleteRoleFromRolePer(Roles roles);
	
	public int deleteRoleFromRole(Roles roles);
	/**
	 * 修改角色信息
	 * @param roles
	 * @return
	 */
	public int updateRole(Roles roles);
	
	
	
	
	
	

}
