package org.lanqiao.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.entity.Admins;
import org.lanqiao.service.AdminService;
import org.lanqiao.service.impl.AdminsServiceImpl;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/user/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String admin_id = request.getParameter("admin_id");
		String admin_loginname = request.getParameter("admin_loginname");
		String admin_name = request.getParameter("admin_name");
		String admin_phone = request.getParameter("admin_phone");
		String admin_email = request.getParameter("admin_email");
		
		
		if(admin_name != null && !"".equals(admin_name) && admin_phone != null && !"".equals(admin_phone) && admin_email != null && !"".equals(admin_email)){
			Admins admins = new Admins(Integer.parseInt(admin_id),admin_name,admin_loginname,admin_phone,admin_email);
			AdminService adminService = new AdminsServiceImpl();
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
			if(adminService.modifyAdminInfo(admins)){
				Admins admins2 = adminService.getAdminsById(admins);
				session.setAttribute("currLoginAdmins", admins2);
				
				out.print(1);
				//response.sendRedirect(request.getContextPath()+"/view/user/user_info.jsp");
				//request.getRequestDispatcher("/view/user/user_info.jsp").forward(request, response);
				
			}else {
				out.print(-1);
				//request.setAttribute("errMess", 0);
				//response.sendRedirect(request.getContextPath()+"/view/user/user_info.jsp");
				//request.getRequestDispatcher("/view/user/user_info.jsp").forward(request, response);
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
