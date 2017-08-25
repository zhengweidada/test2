package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Admins;
import org.lanqiao.entity.Paging;
import org.lanqiao.entity.Permissions;
import org.lanqiao.entity.Roles;

public interface AdminService {
	/**
	 * 事务操作
	 * 添加管理员信息
	 * 并添加管理员与角色的对应信息
	 * @param admins
	 * @return
	 */
	public boolean addAdmin(Admins admins);
	
	//public boolean addAdminRole(Admins admins, Roles roles);
	/**
	 * 获取所有的管理员信息（包括角色权限信息，在dao层已完成所有的操作）
	 * @return
	 */
	public List<Admins> getAllAdmins();
	/**
	 * 通过管理员id查找管理员
	 * @param admins
	 * @return
	 */
	public Admins getAdminsById(Admins admins);
	/**
	 * 事务操作
	 * 修改管理员信息并更改角色
	 * 三步操作，修改管理员信息，从管理员-角色表删除对应关系，在添加管理员角色对应关系
	 * @param admins
	 * @param roles
	 * @return
	 */
	public boolean modifyAdmin(Admins admins, String[] roles);
	/**
	 * 单个修改管理员密码
	 * @param admins
	 * @return
	 */
	public boolean modifyAdminPsw(Admins admins);
	/**
	 * 批量修改管理员密码（重置密码）
	 * @param aChoose
	 * @return
	 */
	public boolean modifyAdminPsw(String aChoose[]);
	/**
	 * 通过管理员的登录名和密码查找匹配的管理员
	 * @param admins
	 * @return
	 */
	public Admins adminLogin(Admins admins);
	/**
	 * 查找管理员所对应的权限
	 * @param admins
	 * @return
	 */
	//public List<Permissions> perOfAdmin(Admins admins);
	
	public Admins getAdminsByPsw(Admins admins);
	
	
	//public boolean updateAdminPsw(Admins admins);
	/**
	 * 搜索功能中查找特定角色的管理员
	 * @param roles
	 * @return
	 */
	public List<Admins> getAdminsOfRoles(Roles roles, int selModules);
	/**
	 * 删除管理员,单个操作
	 * @param admins
	 * @return
	 */
	public boolean delAdmin(Admins admins);
	/**
	 * 修改管理员信息
	 * @param admins
	 * @return
	 */
	public boolean modifyAdminInfo(Admins admins);
	/**
	 * 初始化只查询前8条数据
	 * 当点击分页信息时，通过页面的页数进行下一次的查询，并返回到页面上
	 * @param page
	 * @return
	 */
	//public List<Admins> getAdminPage(Paging page);
	/**
	 * 封装admin分页信息，包括总记录数和总页数和当前页
	 * @param page
	 * @return
	 */
	//public Paging getAdminPageInfo(Paging page);

}
