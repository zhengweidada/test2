package org.lanqiao.servlet.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Account;
import org.lanqiao.entity.Bussess;
import org.lanqiao.entity.Expenses;
import org.lanqiao.service.AccountService;
import org.lanqiao.service.BussessService;
import org.lanqiao.service.ExpenseService;
import org.lanqiao.service.impl.AccountServiceImpl;
import org.lanqiao.service.impl.BussessServiceImpl;
import org.lanqiao.service.impl.ExpenseServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Servlet implementation class AddServiceServlet
 */
@WebServlet("/service/addServiceServlet")
public class AddServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String user_idcard = request.getParameter("idcard");
		if("search".equals(op)){
			AccountService accountService = new AccountServiceImpl();
			Account a = new Account();
			a.setUser_idcard(user_idcard);
			Account account = accountService.getAccountByIdCard(a);
			if(account != null){
				
				String json = ""; 
				try{  
		            ObjectMapper mapper = new ObjectMapper(); 
		            json = mapper.writeValueAsString(account);  
		            //System.out.println(json);  
		        }catch(Exception e){  
		            e.printStackTrace();  
		        }
				response.setContentType("text/html");
				request.setAttribute("search_account_json", json);
				response.getWriter().print(json);;
				//request.setAttribute("search_account", account);
				//request.getRequestDispatcher("/view/service/service_add.jsp").forward(request, response);
			}else{
				response.sendRedirect(request.getContextPath()+"/view/account/account_add.jsp");
			}
		}else if("sefe".equals(op)){
			ExpenseService expenseService = new ExpenseServiceImpl();
			List<Expenses> list = expenseService.getAllExpense();
			request.setAttribute("eList", list);
			request.getRequestDispatcher("/view/service/service_add.jsp").forward(request, response);
			
		}else if("add".equals(op)){
			String account_id = request.getParameter("account_id");
			String eps_id = request.getParameter("eps_id");
			String server_ip = request.getParameter("server_ip");
			String os_account = request.getParameter("os_account");
			String os_psw = request.getParameter("os_psw");
			Bussess bussess = new Bussess(new Account(Integer.parseInt(account_id)), os_account, os_psw, server_ip, new Expenses(Integer.parseInt(eps_id)));
			BussessService bussessService = new BussessServiceImpl();
			if(bussessService.addBussess(bussess))
				response.sendRedirect(request.getContextPath()+"/service/serviceListServlet");
			else
				response.sendRedirect(request.getContextPath()+"/service/serviceListServlet");
			
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
