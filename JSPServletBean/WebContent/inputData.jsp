<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink">

<form action="computerSum">
	等差数列求和:<br/>
	输入首项:
	<input type="text" name="a">
	输入公差:
	<input type="text" name="d">
	求和项数:
	<input type="text" name="n">
	<input type="submit" value="提交">
	<input type="hidden" name="type" value="dengcha">
</form>
<br/>
<form action="computerSum">
	等比数列求和:<br/>
	输入首项:
	<input type="text" name="a">
	输入公比:
	<input type="text" name="q">
	求和项数:
	<input type="text" name="n">
	<input type="submit" value="提交">
	<input type="hidden" name="type" value="dengbi">
</form>

</body>
</html>