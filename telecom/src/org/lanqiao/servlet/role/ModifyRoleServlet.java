package org.lanqiao.servlet.role;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Roles;
import org.lanqiao.service.RoleService;
import org.lanqiao.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class ModifyRoleServlet
 */
@WebServlet("/role/modifyRoleServlet")
public class ModifyRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyRoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("role_id");
		
		int role_id = Integer.parseInt(id);
		String role_name = request.getParameter("role_name");
		String[] per = request.getParameterValues("permissions");
		
		RoleService roleService = new RoleServiceImpl();
		if(roleService.modifyRoleAndPermit(new Roles(role_id, role_name), per))
			response.sendRedirect(request.getContextPath()+"/role/roleListServlet");
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
