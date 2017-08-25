package org.lanqiao.servlet.user;

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
 * Servlet implementation class UpdatePswServlet
 */
@WebServlet("/user/updatePswServlet")
public class UpdatePswServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePswServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String admin_id = request.getParameter("admin_id");
		String admin_old_psw = request.getParameter("admin_old_psw");
		String admin_new_psw = request.getParameter("admin_new_psw");
		String admin_new_rpsw = request.getParameter("admin_new_rpsw");
		
		if(admin_id != null && !"".equals(admin_id) && admin_old_psw != null && !"".equals(admin_old_psw) &&
				admin_new_psw != null && !"".equals(admin_new_psw) && admin_new_rpsw != null && !"".equals(admin_new_rpsw)){
			PrintWriter out = response.getWriter();
			if(admin_new_psw.equals(admin_new_rpsw)){
				
				AdminService adminService = new AdminsServiceImpl();
				if(adminService.modifyAdminPsw(new Admins(Integer.parseInt(admin_id), admin_new_psw))){
					out.print("1");
					//response.sendRedirect(request.getContextPath()+"/view/login.jsp");
				}else{
					out.print("-1");
					
				}
			}else{
				out.print("-1");
				
			}
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
