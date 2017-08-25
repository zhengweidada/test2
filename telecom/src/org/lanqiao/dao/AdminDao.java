package org.lanqiao.dao;

import java.util.List;
import java.util.Map;

import org.lanqiao.entity.Admins;
import org.lanqiao.entity.Permissions;
import org.lanqiao.entity.Roles;

public interface AdminDao {
	/**
	 * 往管理员表插入管理员信息，直接返回添加管理员的主键
	 * @param admins
	 * @return
	 */
	public int insertAdmin(Admins admins);
	/**
	 * 往管理员-角色表插入管理员-角色对应信息，与insertAdmin方法在同一事务下
	 * @param admins
	 * @param roles
	 * @return
	 */
	public int insertAdminRole(Map<String, Object> map);
	/**
	 * 根据管理员的id查询管理员的信息
	 * @param admins
	 * @return
	 */
	public Admins selectAdminsById(Admins admins);
	
	/**
	 * 查询所有管理员信息，初始化查前8条
	 * @return
	 */
	public List<Admins> selectAllAdmins();
	/**
	 * 分页查管理员信息
	 * @param page
	 * @return
	 */
	public List<Admins> selectAllAdmins2(Map<String, Integer> map);
	/**
	 * 通过登录名查询管理员
	 * @param admins
	 * @return
	 */
	public Admins selectAdminByLoginName(Admins admins);
	/**
	 * 根据角色id查询其所拥有的权限
	 * @param roles
	 * @return
	 */
	public List<Permissions> selectPermitByRoles(Roles roles);
	/**
	 * 更新管理员
	 * @param admins
	 * @return
	 */
	public int updateAdmin(Admins admins);
	/**
	 * 删除管理员
	 * @param admins
	 * @return
	 */
	public int deleteAdminFromRelation(Admins admins);
	/**
	 * 在登录时需该查询管理员所拥有的权限
	 * @param admin
	 * @return
	 */
	public List<Permissions> perOfAdmin(Admins admins);
	/**
	 * 管理员修改密码
	 * @param admins
	 * @return
	 */
	public Admins selectAdminsByPsw(Admins admins);
	/**
	 * 批量修改修改管理员密码
	 * @param admins
	 * @return
	 */
	public int updateAdminPsw2(Map<String, Object> map);
	/**
	 * 非批量修改管理员密码
	 * @param admins
	 * @return
	 */
	public int updateAdminPsw(Admins admins);
	
	/**
	 * 查询拥有某个角色的管理员
	 * @param roles
	 * @return
	 */
	public List<Admins> selectAdminsOfRoles(Map<String, Object> map);
	/**
	 * 删除管理员
	 * @param admins
	 * @return
	 */
	public int deleteAdmin(Admins admins);
	
	
	
	
	

}
