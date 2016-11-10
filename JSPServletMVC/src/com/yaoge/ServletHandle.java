package com.yaoge;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletHandle
 */
@WebServlet("/ServletHandle")
public class ServletHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @return 
     * @throws ServletException 
     * @see HttpServlet#HttpServlet()
     */
    public void init() throws ServletException {
        super.init();
        // TODO Auto-generated constructor stub
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
		MessageBean mb = new MessageBean();
		request.setAttribute("message", mb);
		
		String logname = request.getParameter("logname");
		mb.setLogname(logname);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("showRegisterMess.jsp");
		dispatcher.forward(request, response);
	}

}
