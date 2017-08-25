package org.lanqiao.servlet.fee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Expenses;
import org.lanqiao.service.ExpenseService;
import org.lanqiao.service.impl.ExpenseServiceImpl;

/**
 * Servlet implementation class AddExpServlet
 */
@WebServlet("/fee/addExpServlet")
public class AddExpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String eps_name = request.getParameter("eps_name");
		String eps_type = request.getParameter("eps_type");
		String eps_duration = request.getParameter("eps_duration");
		String eps_cost = request.getParameter("eps_cost");
		String eps_unitc = request.getParameter("eps_unitc");
		String eps_desc = request.getParameter("eps_desc");
		
		
		if(eps_name != null && !"".equals(eps_name)){
			ExpenseService expenseService = new ExpenseServiceImpl();
			Expenses exp = new Expenses();
			exp.setEps_name(eps_name);
			exp.setEps_type(Integer.parseInt(eps_type));
			exp.setEps_duration(Integer.parseInt(eps_duration));
			exp.setEps_cost(Double.parseDouble(eps_cost));
			exp.setEps_unitc(Double.parseDouble(eps_unitc));
			exp.setEps_desc(eps_desc);
			if(expenseService.addExp(exp)){
				response.sendRedirect(request.getContextPath()+"/fee/feeListServlet");
			}else{
				response.sendRedirect(request.getContextPath()+"/view/error.jsp");
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
