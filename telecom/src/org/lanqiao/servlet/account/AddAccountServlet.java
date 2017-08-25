package org.lanqiao.servlet.account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Account;
import org.lanqiao.service.AccountService;
import org.lanqiao.service.impl.AccountServiceImpl;

/**
 * Servlet implementation class AddAccountServlet
 */
@WebServlet("/account/addAccountServlet")
public class AddAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_name = request.getParameter("user_name");
		String user_idcard = request.getParameter("user_idcard");
		String user_login_name = request.getParameter("user_login_name");
		String user_psw = request.getParameter("user_psw");
		String user_rpsw = request.getParameter("user_rpsw");
		String user_phone = request.getParameter("user_phone");
		String referee_idcard = request.getParameter("referee_idcard");
		String birth = request.getParameter("birth");
		String email = request.getParameter("email");
		String job = request.getParameter("job");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String code = request.getParameter("code");
		String qq = request.getParameter("qq");
		
		Account account = new Account(user_name, user_login_name, user_psw, user_idcard, 
				birth, Integer.parseInt(sex), user_phone, email, qq, job, address, code, referee_idcard);
		
		AccountService accountService = new AccountServiceImpl();
		if(accountService.addAccount(account)){
			response.sendRedirect(request.getContextPath()+"/account/accountListServlet");
		}
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
