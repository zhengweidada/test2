package org.lanqiao.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Admins;
import org.lanqiao.service.AdminService;
import org.lanqiao.service.impl.AdminsServiceImpl;

/**
 * Servlet implementation class DeleteAdminServlet
 */
@WebServlet("/admin/deleteAdminServlet")
public class DeleteAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
	
		Admins admins = new Admins(Integer.parseInt(id));
		AdminService adminService = new AdminsServiceImpl();
		PrintWriter out = response.getWriter();
		if(adminService.delAdmin(admins)){
			out.print(1);
			//response.sendRedirect(request.getContextPath()+"/admin/adminListServlet");
		}
		else {
			out.print(-1);
			response.sendRedirect(request.getContextPath()+"/view/error.jsp");
		}
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
