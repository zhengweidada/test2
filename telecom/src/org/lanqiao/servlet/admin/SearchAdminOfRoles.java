package org.lanqiao.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.entity.Admins;
import org.lanqiao.entity.Roles;
import org.lanqiao.service.AdminService;
import org.lanqiao.service.impl.AdminsServiceImpl;

/**
 * Servlet implementation class SearchAdminOfRoles
 */
@WebServlet("/admin/searchAdminOfRoles")
public class SearchAdminOfRoles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAdminOfRoles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role_name = request.getParameter("search_role_name");
		String selModules = request.getParameter("selModules");
		System.out.println(role_name+"--"+selModules);
		
		
		AdminService adminService = new AdminsServiceImpl();
		List<Admins> aList = adminService.getAdminsOfRoles(new Roles(role_name), Integer.parseInt(selModules));
		HttpSession session = request.getSession();
		session.setAttribute("aList", aList);
		response.sendRedirect(request.getContextPath()+"/view/admin/admin_list.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
