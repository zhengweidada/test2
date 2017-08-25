package org.lanqiao.servlet.report;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Report;
import org.lanqiao.service.ReportService;
import org.lanqiao.service.impl.ReportServiceImpl;

/**
 * Servlet implementation class OrderReportServlet
 */
@WebServlet("/report/orderReportServlet")
public class OrderReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		
		ReportService  reportService = new ReportServiceImpl();
		List<Report> rList = null;
		if("o1".equals(op)){
			rList = reportService.getAllReports();
			request.setAttribute("rList", rList);
			request.getRequestDispatcher("/view/report/report_list.jsp?op=o1").forward(request, response);
			
		}else if("o2".equals(op)){
			rList = reportService.getReportsByDuration();request.setAttribute("rList", rList);
			request.getRequestDispatcher("/view/report/report_list.jsp?op=o2").forward(request, response);
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
