package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Roles;

public interface RoleService {
	/**
	 * 获取所有角色
	 * @return
	 */
	public List<Roles> getAllRoles();
	
	/**
	 * 事务操作
	 * 添加角色和角色-权限信息
	 * @param roles
	 * @param permissions
	 * @return
	 */
	public boolean addRoleAndPermit(Roles roles, String[] permissions);
	/**
	 * 获取所有角色对应的权限信息
	 * @return
	 */
	public List<Roles> getAllRoles2();
	/**
	 * 事务操作
	 * 修改角色和权限
	 * @param roles
	 * @param permissions
	 * @return
	 */
	public boolean modifyRoleAndPermit(Roles roles, String[] permissions);
	/**
	 * 删除角色
	 * @param roles
	 * @return
	 */
	public boolean delRoleFromRole(Roles roles);
	
	

}
