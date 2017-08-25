package org.lanqiao.servlet.bill;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Bill;
import org.lanqiao.entity.BillDetail;
import org.lanqiao.entity.BillItem;
import org.lanqiao.service.BillService;
import org.lanqiao.service.impl.BillServiceImpl;

/**
 * Servlet implementation class BillDetailServlet
 */
@WebServlet("/bill/billDetailServlet")
public class BillDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		
		System.out.println(op+id);
		
		BillService billService = new BillServiceImpl();
		if("item".equals(op)){
			List<BillItem> items = billService.getItemOfBill(new Bill(Integer.parseInt(id)));
			request.setAttribute("items", items);
			request.getRequestDispatcher("/view/bill/bill_item.jsp").forward(request, response);
		}else if("detail".equals(op)){
			List<BillDetail> details = billService.getDetailOfItem(new BillItem(Integer.parseInt(id)));
			request.setAttribute("details", details);
			request.getRequestDispatcher("/view/bill/bill_service_detail.jsp").forward(request, response);
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
