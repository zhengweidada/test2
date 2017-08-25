package org.lanqiao.servlet.fee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Expenses;
import org.lanqiao.service.ExpenseService;
import org.lanqiao.service.impl.ExpenseServiceImpl;

/**
 * Servlet implementation class UpdateFeeServlet
 */
@WebServlet("/fee/updateFeeServlet")
public class UpdateFeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String eps_id = request.getParameter("id");
		ExpenseService expenseService = new ExpenseServiceImpl();
		//启用资费
		if("1".equals(op)){
			if(expenseService.startExpense(new Expenses(Integer.parseInt(eps_id)))){
				response.sendRedirect(request.getContextPath()+"/fee/feeListServlet");
			}else {
				response.sendRedirect(request.getContextPath()+"/fee/feeListServlet");
			}
		}else if("show".equals(op)){
			//获取要修改的资费的数据
			Expenses expenses = expenseService.getExpenseById(new Expenses(Integer.parseInt(eps_id)));
			request.setAttribute("expenses", expenses);
			request.getRequestDispatcher("/view/fee/fee_modi.jsp").forward(request, response);
			
		}else if("modi".equals(op)){
			String eps_name = request.getParameter("eps_name");
			String eps_type = request.getParameter("eps_type");
			String eps_duration = request.getParameter("eps_duration");
			String eps_cost = request.getParameter("eps_cost");
			String eps_unitc = request.getParameter("eps_unitc");
			String eps_desc = request.getParameter("eps_desc");
			
			if(eps_name != null && !"".equals(eps_name) && eps_duration != null && !"".equals(eps_duration) &&
					eps_cost != null && !"".equals(eps_cost) && eps_unitc != null && !"".equals(eps_unitc)){
				
				Expenses exp = new Expenses();
				exp.setEps_id(Integer.parseInt(eps_id));
				exp.setEps_name(eps_name);
				exp.setEps_type(Integer.parseInt(eps_type));
				exp.setEps_duration(Integer.parseInt(eps_duration));
				exp.setEps_cost(Double.parseDouble(eps_cost));
				exp.setEps_unitc(Double.parseDouble(eps_unitc));
				exp.setEps_desc(eps_desc);
				if(expenseService.modifyExpense(exp)){
					response.sendRedirect(request.getContextPath()+"/fee/feeListServlet");
				}else{
					response.sendRedirect(request.getContextPath()+"/view/error.jsp");
				}
			}
		}else if("del".equals(op)){
			if(expenseService.delExpense(new Expenses(Integer.parseInt(eps_id)))){
				response.sendRedirect(request.getContextPath()+"/fee/feeListServlet");
			}else{
				response.sendRedirect(request.getContextPath()+"/view/error.jsp");
			}
		}else if("detail".equals(op)){
			Expenses expenses = expenseService.getExpenseById(new Expenses(Integer.parseInt(eps_id)));
			request.setAttribute("expenses", expenses);
			request.getRequestDispatcher("/view/fee/fee_detail.jsp").forward(request, response);
			
			
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
