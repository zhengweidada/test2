package org.lanqiao.servlet.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Account;
import org.lanqiao.entity.Bussess;
import org.lanqiao.entity.Expenses;
import org.lanqiao.service.BussessService;
import org.lanqiao.service.ExpenseService;
import org.lanqiao.service.impl.BussessServiceImpl;
import org.lanqiao.service.impl.ExpenseServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class UpdateServiceServlet
 */
@WebServlet("/service/updateServiceServlet")
public class UpdateServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		
		BussessService bussessService = new BussessServiceImpl();
		PrintWriter out = response.getWriter();
		
		if("pause".equals(op)){
			if(bussessService.changeBussessStatus(new Bussess(Integer.parseInt(id), 0))){
				
				out.print(1);
			}else{
				out.print(-1);
			}
				
		}else if("del".equals(op)){
			if(bussessService.changeBussessStatus(new Bussess(Integer.parseInt(id), 2))){
				out.print(1);
			}else{
				out.print(-1);
			}
			
		}else if("open".equals(op)){
			if(bussessService.changeBussessStatus(new Bussess(Integer.parseInt(id), 1))){
				out.print(1);
			}else{
				out.print(-1);
			}
		}else if("show".equals(op)){
			Bussess bussess = bussessService.getedBussessById(new Bussess(Integer.parseInt(id)));
			request.setAttribute("bussess", bussess);
			request.getRequestDispatcher("/view/service/service_modi.jsp").forward(request, response);;
		}else if("modi".equals(op)){
			String eps_id = request.getParameter("eps_id");
			Bussess bussess = new Bussess();
			bussess.setBuss_id(Integer.parseInt(id));
			bussess.setExpenses(new Expenses(Integer.parseInt(eps_id)));
			if(bussessService.modifyBussess(bussess))
				out.print(1);
			else
				out.print(-1);
		}else if("esearch".equals(op)){
			String json = "";
			List<Expenses> list = new ExpenseServiceImpl().getAllExpense();
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(list);
			out.print(json);
		}else if("condi".equals(op)){
			System.out.println("条件搜索");
			String os_account = request.getParameter("os_account");
			String server_ip = request.getParameter("server_ip");
			String user_idcard = request.getParameter("user_idcard");
			String bus_status = request.getParameter("bus_status");
			
			System.out.println(os_account+server_ip+user_idcard+bus_status);
			
			Bussess bussess = new Bussess();
			bussess.setOs_account(os_account);
			bussess.setServer_ip(server_ip);
			bussess.setAccount(new Account(user_idcard));
			bussess.setBuss_status(Integer.parseInt(bus_status));
			List<Bussess> bList = new BussessServiceImpl().getBussessByCondition(bussess);
			request.setAttribute("bList", bList);
			request.getRequestDispatcher("/view/service/service_list.jsp").forward(request, response);
			
			
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
