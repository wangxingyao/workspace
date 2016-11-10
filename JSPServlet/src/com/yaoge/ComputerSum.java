package com.yaoge;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ComputerSum
 */
@WebServlet("/ComputerSum")
public class ComputerSum extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Data data;
	
    /**
     * @return 
     * @see HttpServlet#HttpServlet()
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        data = new Data();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Data databean = new Data();
		request.setAttribute("data", databean);
		
		if (request.getParameter("type").equals("dengcha")) {
			double a = Integer.parseInt(request.getParameter("a"));
			double d = Integer.parseInt(request.getParameter("d"));
			double n = Integer.parseInt(request.getParameter("n"));
			double sum = a*n + n*(n-1)*d/2;
			databean.setA(a);
			databean.setD(d);
			databean.setN(n);
			databean.setSum(sum);
			// 设置返回的html信息
			databean.resetMess();
			databean.setMess(
				"<table border=\"1\">"
				+ "<tr>"
				+ "<th>数列的首项</th>"
				+ "<th>等差数列的公差</th>"
				+ "<th>所求项数</th>"
				+ "<th>求和结果</th>"
				+ "</tr>"
				+ "	<tr>"
				+ "<td>" + a + "</td>"
				+ "<td>" + d + "</td>"
				+ "<td>" + n + "</td>"
				+ "<td>" + sum + "</td>"
				+ "</tr>"
				+ "</table>"
			);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("showResult.jsp");
			dispatcher.forward(request, response);
		} else {
			double a = Integer.parseInt(request.getParameter("a"));
			double q = Integer.parseInt(request.getParameter("q"));
			double n = Integer.parseInt(request.getParameter("n"));
			double sum = q==1 ? a*n : (a-a*Math.pow(q, n))/(1-q);
			databean.setA(a);
			databean.setQ(q);
			databean.setN(n);
			databean.setSum(sum);
			// 设置返回的html信息
			databean.resetMess();
			databean.setMess(
				"<table border=\"1\">"
				+ "<tr>"
				+ "<th>数列的首项</th>"
				+ "<th>等比数列的公比</th>"
				+ "<th>所求项数</th>"
				+ "<th>求和结果</th>"
				+ "</tr>"
				+ "	<tr>"
				+ "<td>" + a + "</td>"
				+ "<td>" + q + "</td>"
				+ "<td>" + n + "</td>"
				+ "<td>" + sum + "</td>"
				+ "</tr>"
				+ "</table>"
			);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("showResult.jsp");
			dispatcher.forward(request, response);
		}
	}

}
