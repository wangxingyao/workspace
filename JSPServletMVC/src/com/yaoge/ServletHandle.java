package com.yaoge;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		UserBean ub = new UserBean();
		request.setAttribute("ub", ub);
		
		request.setCharacterEncoding("utf-8");
		if (request.getParameter("type").equals("register")) {
			String logname = request.getParameter("logname");
			String password = request.getParameter("password");
			if (logname == "") {
				System.out.println("用户名不能为空");
				return ;
			} else if (password == "") {
				System.out.println("密码不能为空");
			}
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String message = request.getParameter("message");
			ub.setLogname(logname);
			ub.setPassword(password);
			ub.setEmail(email);
			ub.setPhone(phone);
			ub.setMessage(message);
			
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection con;
			Statement sql;
			
			try {
				String url = "jdbc:mysql://localhost:3306/yaoge?useUnicode=true&characterEncoding=utf-8&useSSL=false";			
				con = DriverManager.getConnection(url, "root", "main");
				sql = con.createStatement();
				String strPrev = "insert into member (logname, password";
				String strNext = ") values ('"+logname+"', '"+password;
				if (email != "") {
					strPrev += ", email";
					strNext += "', '"+email;
				}
				if (phone != "") {
					strPrev += ", phone";
					strNext += "', '"+phone;
				}
				if (message != "") {
					strPrev += ", message";
					strNext += "', '"+message;
				}
				String str = strPrev + strNext + "');";
				System.out.println(str);
				sql.execute(str);
			} catch (SQLException e) {
				System.out.println(e);
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("showRegisterMess.jsp");
			dispatcher.forward(request, response);			
		} else if (request.getParameter("type").equals("login")) {
			String logname = request.getParameter("logname");
			String password = request.getParameter("password");
			if (logname == "") {
				System.out.println("用户名不能为空");
				return ;
			} else if (password == "") {
				System.out.println("密码不能为空");
			}
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection con;
			Statement sql;
			ResultSet rs;
			
			try {
				String url = "jdbc:mysql://localhost:3306/yaoge?useUnicode=true&characterEncoding=utf-8&useSSL=false";			
				con = DriverManager.getConnection(url, "root", "main");
				sql = con.createStatement();
				String str = "select * from member where logname='"+logname+"' and password='"+password+"';";
				System.out.println("str ==> " + str);
				rs = sql.executeQuery(str);
				if (rs.next()) {
					ub.setLogname(logname);
					System.out.println(rs.getString("logname"));					
				} else {
					System.out.println("用户不存在");
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("showLoginMess.jsp");
			dispatcher.forward(request, response);
		}
	}

}
