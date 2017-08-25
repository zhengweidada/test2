package org.lanqiao.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.ibatis.session.SqlSession;
import org.lanqiao.dao.AdminDao;
import org.lanqiao.entity.Admins;
import org.lanqiao.entity.Permissions;
import org.lanqiao.entity.Roles;
import org.lanqiao.service.AdminService;
import org.lanqiao.util.SessionUtil;

public class AdminsServiceImpl implements AdminService {
	
	
	@Override
	public boolean addAdmin(Admins admins) {
		SqlSession session = SessionUtil.getSession();
		boolean flag = true;
		try {
			session.insert("org.lanqiao.dao.AdminDao.insertAdmin", admins);
			System.out.println("addAdmin:"+admins);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("admins", admins);
			map.put("roles", admins.getRoles());
			session.insert("org.lanqiao.dao.AdminDao.insertAdminRole", map);
			session.commit();
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
			session.rollback();
		}finally{
			SessionUtil.closeSession(session);
		}
		return flag;
	}

	@Override
	public List<Admins> getAllAdmins() {
		SqlSession session = SessionUtil.getSession();
		AdminDao adminDao = session.getMapper(AdminDao.class);
		List<Admins> list = adminDao.selectAllAdmins();
		SessionUtil.closeSession(session);
		return list;
	}
	
	@Override
	public Admins getAdminsById(Admins admins) {
		SqlSession session = SessionUtil.getSession();
		AdminDao adminDao = session.getMapper(AdminDao.class);
		Admins admins2 = adminDao.selectAdminsById(admins);
		SessionUtil.closeSession(session);
		return admins2;
	}
	
	@Override
	public Admins adminLogin(Admins admins) {
		SqlSession session = SessionUtil.getSession();
		AdminDao adminDao = session.getMapper(AdminDao.class);
		Admins a = adminDao.selectAdminByLoginName(admins);
		
		/*if(a == null)
			return null;
		else {
			List<Permissions> pList = adminDao.perOfAdmin(a);
			a.getRoles().setList(pList);
		}*/
		SessionUtil.closeSession(session);
		
		return a;
	}
	
	@Override
	public Admins getAdminsByPsw(Admins admins) {
		SqlSession session = SessionUtil.getSession();
		AdminDao adminDao = session.getMapper(AdminDao.class);
		Admins admins2 = adminDao.selectAdminsById(admins);
		if(!admins2.getAdmin_psw().equals(admins.getAdmin_psw()))
			return null;
		SessionUtil.closeSession(session);
		return admins2;
	}
	
	@Override
	public List<Admins> getAdminsOfRoles(Roles roles, int selModules) {
		SqlSession session = SessionUtil.getSession();
		List<Admins> list = null;
		if("".equals(roles.getRole_name()) && selModules == -1){
			System.out.println("条件查询为空");
			list = session.selectList("org.lanqiao.dao.AdminDao.selectAllAdmins");
			
		}else{
			System.out.println("其他条件查询");
			System.out.println(roles.getRole_name()+"--"+selModules);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("roles", roles.getRole_name());
			map.put("pers", selModules);
			list = session.selectList("org.lanqiao.dao.AdminDao.selectAdminsOfRoles", map);
			
		}

		System.out.println(list);
		SessionUtil.closeSession(session);
		return list;
	}



	@Override
	public boolean modifyAdmin(Admins admins, String[] roles) {
		SqlSession session = SessionUtil.getSession();
		boolean flag = true;
		Roles r = new Roles();
		if(roles != null && roles.length > 0 ){
			r.setRole_id(Integer.parseInt(roles[0]));
		}
		
		try {
			int s1 = session.update("org.lanqiao.dao.AdminDao.updateAdmin", admins);
			System.out.println("update："+s1);
			int s2 = session.delete("org.lanqiao.dao.AdminDao.deleteAdminFromRelation", admins);
			System.out.println("update："+s2);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("admins", admins);
			map.put("roles", r);
			int s3 = session.insert("org.lanqiao.dao.AdminDao.insertAdminRole", map);
			System.out.println("update："+s3);
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


	
	/*@Override
	public List<Permissions> perOfAdmin(Admins admins) {
		return adminDao.perOfAdmin(admins);
	}
*/
	

	

	@Override
	public boolean modifyAdminPsw(String aChoose[]) {
		SqlSession session = SessionUtil.getSession();
		boolean flag = true;
		Map<String, Object> map = new HashMap<String, Object>();
		List<Admins> list = new ArrayList<Admins>();
		
		try {
			for(int i=0; i<aChoose.length; i++){
	        	list.add(new Admins(Integer.parseInt(aChoose[i])));
	        }
			map.put("psw", "123");
			map.put("aList", list);
			session.update("org.lanqiao.dao.AdminDao.updateAdminPsw2", map);
			session.commit();
		} catch (Exception e) {
			flag = false;
			session.rollback();
			e.printStackTrace();
		}finally {
			SessionUtil.closeSession(session);
		}
		return flag;
	}

	
	@Override
	public boolean modifyAdminPsw(Admins admins) {
		SqlSession session = SessionUtil.getSession();
		int rows = session.update("org.lanqiao.dao.AdminDao.updateAdminPsw", admins);
		SessionUtil.closeSession(session);
		if(rows > 0)
			return true;
		return false;
	}

	@Override
	public boolean delAdmin(Admins admins) {
		SqlSession session = SessionUtil.getSession();
		int rows = session.update("org.lanqiao.dao.AdminDao.deleteAdmin", admins);
		session.commit();
		SessionUtil.closeSession(session);
		if(rows > 0)
			return true;
		return false;
	}
/*
	@Override
	public boolean updateAdminPsw(Admins admins) {
		if(adminDao.updateAdminPsw(admins) > 0)
			return true;
		return false;
	}*/

	
	@Override
	public boolean modifyAdminInfo(Admins admins) {
		SqlSession session = SessionUtil.getSession();
		int rows = session.update("org.lanqiao.dao.AdminDao.updateAdmin", admins);
		SessionUtil.closeSession(session);
		if(rows > 0)
			return true;
		return false;
	}

	
	//以下方法为分页所需要的方法

	/*@Override
	public List<Admins> getAdminPage(Paging page) {
		page.setPageSize(Integer.parseInt(ConnectDB.getPageSize()));
		return adminDao.selectAllAdmins(page);
	}*/

	/*@Override
	public Paging getAdminPageInfo(Paging page) {
		int record = QueryPage.getRecord("admins");
		int pagesize = Integer.parseInt(ConnectDB.getPageSize());
		int totalpage = (record%pagesize == 0)?record/pagesize:(record/pagesize)+1;
		
		page.setTotalRecord(record);
		page.setPageSize(pagesize);
		page.setTotalPage(totalpage);
		//System.out.println(page);
		return page;
	}*/

}
