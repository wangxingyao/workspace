<%@ attribute name="fileDir" required="True" %>
<%@ attribute name="fileName" required="True" %>
<%@ attribute name="fileContent" required="True" %>
<%@ tag import ="java.io.*" %>

<%!
	public void writeContent(String str, File f) {
		try {
			FileWriter outfile = new FileWriter(f);
			outfile.write(str);
			outfile.close();
		} catch (IOException e) {}
	}
%>

<%
	request.setCharacterEncoding("UTF-8");
	String fileDir = request.getParameter("fileDir");
	String fileName = request.getParameter("fileName");
	String fileContent = request.getParameter("fileContent");
	
	if (fileName.equals("")) {
		out.println("文件名字不能为空");
	} else {
		java.io.File f1 = new java.io.File(fileDir, fileName);
		writeContent(fileContent, f1);
		out.print("文件写入成功!" + "<br>");
		out.print("文件所在目录: " + fileDir + "<br>");
		out.print("文件的名字: " + fileName + "<br>");
	}
%>