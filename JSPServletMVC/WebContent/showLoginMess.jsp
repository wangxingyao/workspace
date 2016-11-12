<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:useBean id="ub" class="com.yaoge.UserBean" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink">

<div style="text-align: center;">	
	<h2>登陆成功</h2>
	登陆会员名称:<jsp:getProperty property="logname" name="ub"/>
</div>

</body>
</html>