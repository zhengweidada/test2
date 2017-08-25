package org.lanqiao.servlet.account;

import java.io.IOException;
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
 * Servlet implementation class SearchAccountServlet
 */
@WebServlet("/account/searchAccountServlet")
public class SearchAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condi_id_card = request.getParameter("condi_id_card");
		String condi_name = request.getParameter("condi_name");
		String condi_login_name = request.getParameter("condi_login_name");
		String condi_status = request.getParameter("condi_status");
		
		Account account = new Account(condi_name, condi_login_name, condi_id_card, Integer.parseInt(condi_status));
		AccountService accountService = new AccountServiceImpl();
		List<Account> aList = accountService.getAccountByCondition(account);
		request.setAttribute("aList", aList);
		request.setAttribute("condi_account", account);
		request.getRequestDispatcher("/view/account/account_list.jsp").forward(request, response);;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
