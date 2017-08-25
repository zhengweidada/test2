package org.lanqiao.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.lanqiao.dao.RoleDao;
import org.lanqiao.entity.Permissions;
import org.lanqiao.entity.Roles;
import org.lanqiao.service.RoleService;
import org.lanqiao.util.SessionUtil;


public class RoleServiceImpl implements RoleService {
	

	@Override
	public List<Roles> getAllRoles() {
		SqlSession session = SessionUtil.getSession();
		RoleDao roleDao = session.getMapper(RoleDao.class);
		List<Roles> list = roleDao.selectAllRoles();
		SessionUtil.closeSession(session);
		return list;
	}
	
	
	@Override
	public boolean addRoleAndPermit(Roles roles, String[] permissions) {
		boolean flag = true;
		SqlSession session = SessionUtil.getSession();
		session.insert("org.lanqiao.dao.RoleDao.insertRole", roles);
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Permissions> pList = new ArrayList<Permissions>();
		Permissions per = null;
		try {
			if(permissions != null){
				for(int i=0; i<permissions.length; i++){
					per = new Permissions(Integer.parseInt(permissions[i]));
					pList.add(per);
				}
			}
			map.put("roles", roles);
			map.put("pers", pList);
			session.insert("org.lanqiao.dao.RoleDao.insertRolePer", map);
			session.commit();
			
		} catch (Exception e) {
			flag = false;
			session.rollback();
			e.printStackTrace();
		}finally{
			SessionUtil.closeSession(session);
		}
		return flag;
	}

	@Override
	public List<Roles> getAllRoles2() {
		SqlSession session = SessionUtil.getSession();
		RoleDao roleDao = session.getMapper(RoleDao.class);
		List<Roles> list = roleDao.selectAllRoles2();
		SessionUtil.closeSession(session);
		return list;
	}

	@Override
	public boolean modifyRoleAndPermit(Roles roles, String[] permissions) {
		SqlSession session = SessionUtil.getSession();
		session.update("org.lanqiao.dao.RoleDao.updateRole", roles);
		session.delete("org.lanqiao.dao.RoleDao.deleteRoleFromRolePer", roles);
		boolean flag = true;
		Map<String, Object> map = new HashMap<String, Object>();
		List<Permissions> pList = new ArrayList<Permissions>();
		Permissions per = null;
		try {
			if(permissions != null){
				for(int i=0; i<permissions.length; i++){
					per = new Permissions(Integer.parseInt(permissions[i]));
					pList.add(per);
				}
			}
			map.put("roles", roles);
			map.put("pers", pList);
			session.insert("org.lanqiao.dao.RoleDao.insertRolePer", map);
			session.commit();
		} catch (Exception e) {
			flag = false;
			session.rollback();
			e.printStackTrace();
		}finally{
			SessionUtil.closeSession(session);
		}
		return flag;
	}

	@Override
	public boolean delRoleFromRole(Roles roles) {
		SqlSession session = SessionUtil.getSession();
		boolean flag = true;
		try {
			session.delete("org.lanqiao.dao.RoleDao.deleteRoleFromRole", roles);
			session.commit();
		} catch (Exception e) {
			flag = false;
			session.rollback();
			e.printStackTrace();
		}
		return flag;
	}
	
	

}
