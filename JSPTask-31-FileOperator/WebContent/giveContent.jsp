<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件读写操作</title>
</head>
<body bgcolor="rgb(248,147,29)">

<a href="http://localhost:8080/JSPTask-31-FileOperator/giveContent.jsp">我要写文件</a>
<a href="http://localhost:8080/JSPTask-31-FileOperator/lookContent.jsp">我要读文件</a>
<form action="writeContent.jsp" method="post" name="form">
	<p>请选择一个目录:
	<select id="fileDir" name="fileDir">
		<option value="D:\mycode\workspace\JSPTask-31-FileOperator\SaveFile">D:\mycode\workspace\JSPTask-31-FileOperator\SaveFile</option>
	</select>
	<br>
	<p>输入保存文件的名字:
	<input type="text" name="fileName"></input>
	<br>
	<p>输入文件的内容: </p>
	<textarea name="fileContent" cols="30" rows="3"></textarea>
	<br>
	<input type="submit" value="提交" name="submit"></input>
</form>

</body>
</html>