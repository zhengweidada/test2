package org.lanqiao.servlet.admin;

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
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//管理员登录
		//依靠现在的技术进行表单的验证，返回值都很不方便，当使用ajax时，轻松地解析返回值，给与提示更好
		
		String uname = request.getParameter("uname");
		String upsw = request.getParameter("upsw");
		
		PrintWriter out = response.getWriter();
		if(uname !=null && !"".equals(uname) && upsw != null && !"".equals(upsw)){
			AdminService adminService = new AdminsServiceImpl();
			Admins currLoginAdmins = adminService.adminLogin(new Admins(uname, upsw));
			
			if(currLoginAdmins != null){
				HttpSession session = request.getSession();
				session.setAttribute("currLoginAdmins", currLoginAdmins);
				out.print(1);
			}
		}else{
			
			out.print(-1);
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
