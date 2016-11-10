<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:useBean id="message" class="com.yaoge.MessageBean" scope="request" />
    
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
#form {
    width:250px;
    float:left;
    padding:10px;	 	 
}
</style>
</head>
<body bgcolor="pink">

<jsp:include page="head.txt" />

<br><br>

<div id="left">
</div>
<div id="form">	
<form action="servletHandle" method="post">
	输入您的信息,会员名字必须由字母和数字组成,带*号必须填写.<br>
	会员名称:
	<input type="text" name="logname">*<br>
	设置密码:
	<input type="text" name="password">*<br>
	电子邮件:
	<input type="text" name="email"><br>
	联系电话:
	<input type="text" name="phone"><br>
	输入您的简历和交友标准:<br>
	<textarea rows="5" cols="27" name="message"></textarea>
	<input type="submit" name="submit" value="提交查询内容">
</form>
</div>


</body>
</html>