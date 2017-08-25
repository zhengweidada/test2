package org.lanqiao.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Admins;
import org.lanqiao.service.AdminService;
import org.lanqiao.service.impl.AdminsServiceImpl;
/**
 * Servlet implementation class UpdateAdminServlet
 */
@WebServlet("/admin/updateAdminServlet")
public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String admin_id = request.getParameter("admin_id");
		String admin_name = request.getParameter("admin_name");
		String admin_loginname = request.getParameter("admin_loginname");
		String admin_phone = request.getParameter("admin_phone");
		String admin_email = request.getParameter("admin_email");
		String[] roles = request.getParameterValues("roles");
		
		Admins admins = new Admins(Integer.parseInt(admin_id), admin_name, admin_loginname, admin_phone, admin_email);
	
		AdminService adminService = new AdminsServiceImpl();
		if(adminService.modifyAdmin(admins, roles)){
			response.sendRedirect(request.getContextPath()+"/admin/adminListServlet");
		}
		else 
			response.sendRedirect(request.getContextPath()+"/view/error.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	} 
	
	

}
