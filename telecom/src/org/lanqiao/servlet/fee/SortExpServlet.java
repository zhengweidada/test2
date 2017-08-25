package org.lanqiao.servlet.fee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Expenses;
import org.lanqiao.service.ExpenseService;
import org.lanqiao.service.impl.ExpenseServiceImpl;

/**
 * Servlet implementation class SortExpServlet
 */
@WebServlet("/fee/sortExpServlet")
public class SortExpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortExpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sort = request.getParameter("sort");
		String field = request.getParameter("field");
		
		ExpenseService expenseService = new ExpenseServiceImpl();
		List<Expenses> eList = expenseService.sortExpense(sort, field);
		request.setAttribute("eList", eList);
		request.getRequestDispatcher("/view/fee/fee_list.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
