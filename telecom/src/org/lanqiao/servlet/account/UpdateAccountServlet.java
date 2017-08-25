package org.lanqiao.servlet.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Account;
import org.lanqiao.service.AccountService;
import org.lanqiao.service.impl.AccountServiceImpl;

/**
 * Servlet implementation class UpdateAccountServlet
 */
@WebServlet("/account/updateAccountServlet")
public class UpdateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		AccountService accountService = new AccountServiceImpl();
		
		if("show".equals(op)){
			Account account = accountService.gettAccountById(new Account(Integer.parseInt(id)));
			
			request.setAttribute("account", account);
			request.getRequestDispatcher("/view/account/account_modi.jsp").forward(request, response);;
		}else if("del".equals(op)){
			if(accountService.delAccount(new Account(Integer.parseInt(id))))
				response.sendRedirect(request.getContextPath()+"/account/accountListServlet");
			else
				response.sendRedirect(request.getContextPath()+"/view/error.jsp");
		}else if("detail".equals(op)){
			Account account = accountService.gettAccountById(new Account(Integer.parseInt(id)));
			request.setAttribute("account", account);
			request.getRequestDispatcher("/view/account/account_detail.jsp").forward(request, response);;
		}else if("pause".equals(op)){
			if(accountService.pauseAccountStatus(new Account(Integer.parseInt(id))))
				response.sendRedirect(request.getContextPath()+"/account/accountListServlet");
			else 
				response.sendRedirect(request.getContextPath()+"/view/error.jsp");
			
		}else if("open".equals(op)){
			if(accountService.openAccountAgain(new Account(Integer.parseInt(id))))
				response.sendRedirect(request.getContextPath()+"/account/accountListServlet");
			else 
				response.sendRedirect(request.getContextPath()+"/view/error.jsp");
			
		}else if("modi".equals(op)){
			String account_id = request.getParameter("account_id"); 
			String user_name = request.getParameter("user_name");
			String user_idcard = request.getParameter("user_idcard");
			String user_login_name = request.getParameter("user_login_name");
			String[] ckPsw = request.getParameterValues("ckPsw");
			List<String> pswList = null;
			if(ckPsw != null){
				String user_psw = request.getParameter("user_psw");
				String user_new_psw = request.getParameter("user_new_psw");
				String user_new_rpsw = request.getParameter("user_new_rpsw");
				
				pswList = new ArrayList<String>();
				pswList.add(user_psw);
				pswList.add(user_new_psw);
				pswList.add(user_new_rpsw);
			}
			
			String user_phone = request.getParameter("user_phone");
			String referee_idcard = request.getParameter("referee_idcard");
			String birth = request.getParameter("birth");
			String email = request.getParameter("email");
			String job = request.getParameter("job");
			String sex = request.getParameter("sex");
			String address = request.getParameter("address");
			String user_code = request.getParameter("user_code");
			String qq = request.getParameter("qq");
			
			Account account = new Account(Integer.parseInt(account_id), user_name, user_login_name, user_idcard, 
					birth, Integer.parseInt(sex), user_phone, email, qq, job, address, user_code, referee_idcard);
			
			if(accountService.modiAccount(account, pswList))
				response.sendRedirect(request.getContextPath()+"/account/accountListServlet");
			else
				response.sendRedirect(request.getContextPath()+"/view/error.jsp");
			
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
