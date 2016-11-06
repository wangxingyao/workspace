<%@ attribute name="number" required="True" %>
<%@ variable name-given="Rs" variable-class="java.sql.ResultSet" scope="AT_END"%>
<%@ tag import="java.io.*,java.util.*,java.sql.*" %>

<%
	Connection con;
	Statement sql;
	ResultSet rs;
	try {
		Class.forName("org.gjt.mm.mysql.Driver");
	} catch (Exception e) {
		out.print("1");
		out.print(e);
	}
	
	try {
		String url = "jdbc:mysql://localhost:3306/RUNOOB?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String user = "root";
		String password = "main";
		
		con = DriverManager.getConnection(url, user, password);
		sql = con.createStatement();
		rs = sql.executeQuery("select * from jsptask32 where number = " + number + ";");
		jspContext.setAttribute("Rs", rs);
	} catch (SQLException e) {
		out.print(e);
	}
%>