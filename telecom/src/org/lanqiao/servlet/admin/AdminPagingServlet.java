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
import org.lanqiao.util.QueryPage;

/**
 * Servlet implementation class PagingServlet
 */
@WebServlet("/admin/adminPagingServlet")
public class AdminPagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPagingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String index = request.getParameter("index");
		System.out.println("index---------:"+index);
		Paging page = new Paging(Integer.parseInt(index));
		
		/*AdminService adminService = new AdminsServiceImpl();
		List<Admins> aList = adminService.getAdminPage(page);
		Paging p= adminService.getAdminPageInfo(page);
		List<Integer> totalPage = new ArrayList<Integer>();
		for(int i=1; i<=p.getTotalPage(); i++){
			totalPage.add(i);
		}*/
		/*for(Admins a:aList){
			System.out.println(a);
		}*/
		
		//HttpSession session = request.getSession();
		/*request.setAttribute("aList", aList);
		request.setAttribute("page", p);
		request.setAttribute("totalPage", totalPage);
		//response.sendRedirect(request.getContextPath()+"/view/admin/admin_list.jsp");
		request.getRequestDispatcher("/view/admin/admin_list.jsp").forward(request, response);
		*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
