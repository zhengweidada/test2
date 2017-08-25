package org.lanqiao.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.service.AdminService;
import org.lanqiao.service.impl.AdminsServiceImpl;

/**
 * Servlet implementation class ResetAllAdminServlet
 */
@WebServlet("/admin/resetAllAdminServlet")
public class ResetAllAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetAllAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id_choose = request.getParameter("id_choose");
        String a[] = id_choose.split(",");
        AdminService adminService = new AdminsServiceImpl();
        PrintWriter out = response.getWriter();
        if(adminService.modifyAdminPsw(a)){
        	System.out.println("重置成功");
        	out.print("1");
        	//response.sendRedirect(request.getContextPath()+"/view/admin/admin_list.jsp");
        }else{
        	System.out.println("重置失败");
        	out.print("-1");
        	//response.sendRedirect(request.getContextPath()+"/view/error.jsp");
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
