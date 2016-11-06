<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="number" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JDBC数据库操作</title>
</head>
<body>

<%
	String strNumber = request.getParameter("number");
%>
<number:NumberCondtion number="<%=strNumber%>" />

<p>根据学号<%=strNumber %>查到的记录:</p>
<%
	out.print("<table border=2>");
		out.print("<tr>");
			out.print("<th width=100>" + "number");
			out.print("<th width=100>" + "name");
			out.print("<th width=100>" + "birthday");
			out.print("<th width=100>" + "email");
		out.print("</tr>");
	while (Rs.next()) {
		out.print("<tr>");
			out.print("<td>" + Rs.getString(1) + "</td>");
			out.print("<td>" + Rs.getString(2) + "</td>");
			out.print("<td>" + Rs.getDate("birthday") + "</td>");
			out.print("<td>" + Rs.getString(4) + "</td>");	
		out.print("</tr>");
	}
%>

</body>
</html>