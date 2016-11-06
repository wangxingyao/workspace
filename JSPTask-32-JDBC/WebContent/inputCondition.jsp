<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JDBC数据库操作</title>
</head>
<body>

<form action="byNumber.jsp" method="post" name="form">
	<p>根据学号查询</p>
	<p>输入学号:
	<input type="text" name="number"></input>
	<input type="submit" value="提交" name="submit">
</form>

<form action="byName.jsp" method="post" name="form">
	<p>根据姓名(模糊)查询</p>
	<p>姓名含有
	<input type="text" name="name"></input>
	<input type="submit" value="提交" name="submit"></input>
</form>

</body>
</html>