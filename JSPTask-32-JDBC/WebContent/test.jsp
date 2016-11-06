<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
 
<html>
<head>
<title>SELECT 操作</title>
</head>
<body>

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
		rs = sql.executeQuery("SELECT * from jsptask32;");
		while (rs.next()){
            out.print(rs.getString(1));
            out.print(rs.getString(2));
            out.print(rs.getString(3));
            out.print(rs.getString(4) + "<br>");
        }

	} catch (SQLException e) {
		out.print(e);
	}
%>

</body>
</html>