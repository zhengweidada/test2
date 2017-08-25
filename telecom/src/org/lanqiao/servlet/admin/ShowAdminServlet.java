package org.lanqiao.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.entity.Roles;
import org.lanqiao.service.RoleService;
import org.lanqiao.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class ShowAdminServlet
 */
@WebServlet("/admin/showAdminServlet")
public class ShowAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleService rolesService = new RoleServiceImpl();
		List<Roles> rList = rolesService.getAllRoles();
		HttpSession session = request.getSession();
		session.setAttribute("rList", rList);
		request.getRequestDispatcher("/view/admin/admin_modi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
