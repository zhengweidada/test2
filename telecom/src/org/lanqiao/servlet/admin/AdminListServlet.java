package org.lanqiao.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.entity.Admins;
import org.lanqiao.entity.Paging;
import org.lanqiao.service.AdminService;
import org.lanqiao.service.impl.AdminsServiceImpl;

/**
 * Servlet implementation class AdminListServlet
 */
@WebServlet("/admin/adminListServlet")
public class AdminListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询所有管理员的信息
		AdminService adminService = new AdminsServiceImpl();
		List<Admins> aList= adminService.getAllAdmins();
		
		/*Paging page = adminService.getAdminPageInfo(new Paging(1));
		List<Integer> totalPage = new ArrayList<Integer>();
		for(int i=1; i<=page.getTotalPage(); i++){
			totalPage.add(i);
		}*/
		
		HttpSession session = request.getSession();
		session.setAttribute("aList", aList);
		//session.setAttribute("page", page);
		//session.setAttribute("totalPage", totalPage);
		request.getRequestDispatcher("/view/admin/admin_list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
