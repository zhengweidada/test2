package org.lanqiao.servlet.role;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Roles;
import org.lanqiao.service.RoleService;
import org.lanqiao.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class AddRoleServlet
 */
@WebServlet("/role/addRoleServlet")
public class AddRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role_name = request.getParameter("role_name");
		String permit = request.getParameter("permit");
		String[] permissions = permit.split(",");
		
		RoleService roleService = new RoleServiceImpl();
		PrintWriter out = response.getWriter();
		if(roleService.addRoleAndPermit(new Roles(role_name), permissions)){
			out.println(1);
			//System.out.println("添加成功");
			//response.sendRedirect(request.getContextPath()+"/role/roleListServlet");
		}
		else{
			out.println(-1);
			//System.out.println("添加失败");
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
