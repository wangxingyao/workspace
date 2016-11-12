<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:useBean id="ub" class="com.yaoge.UserBean" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
#left {
    width:480px;
    float:left;
    padding:5px;	      
}
#right {
    width:250px;
    float:left;
    padding:10px;	 	 
}
</style>
</head>
<body bgcolor="pink">
<jsp:include page="head.txt" />

<div id="left">
</div>
<div id="right">
	注册成功<br>
	注册的会员名称:<jsp:getProperty property="logname" name="ub"/><br>
	注册的电子邮件:<jsp:getProperty property="email" name="ub"/><br>
	注册的联系电话:<jsp:getProperty property="phone" name="ub"/><br>
	您的简历和交友标准:<br>
	<textarea rows="5" cols="27">
	<jsp:getProperty property="message" name="ub"/>
	</textarea>
</div>

</body>
</html>