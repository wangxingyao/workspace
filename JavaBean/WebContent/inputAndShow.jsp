<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">

<form>
	<p>汽车牌号:
	<input type="text" name="license">(如: "陕A12345")</input>
	<p>汽车品牌:
	<input type="text" name="brand">(如: "BYD牌")</input>
	<p>生产日期:
	<input type="text" name="date">(如: "2016.10")</input>
	<input type="submit" name="submit" value="提交"></input>
</form>

<jsp:useBean id="query" class="yaoge.QueryBean"> 
   	<jsp:setProperty name="query" property="databaseName" value="yaoge"/>
   	<jsp:setProperty name="query" property="tableName" value="car"/>
   	<jsp:setProperty name="query" property="username" value="root"/>
   	<jsp:setProperty name="query" property="password" value="main"/>
	<jsp:setProperty name="query" property="license" param="license"/>
	<jsp:setProperty name="query" property="brand" param="brand"/>
	<jsp:setProperty name="query" property="date" param="date"/> 
</jsp:useBean>

<%query.insertData(); %>
<jsp:getProperty name="query" property="queryResult"/>




</body>
</html>