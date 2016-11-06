<%@ attribute name="fileDir" required="True" %>
<%@ attribute name="fileName" required="True" %>
<%@ tag import ="java.io.*" %>

<%
	request.setCharacterEncoding("UTF-8");
	String fileDir = request.getParameter("fileDir");
	String fileName = request.getParameter("fileName");
	
	if (fileName.equals("")) {
		out.print("文件名字不能为空" + "<br>");
	} else {
		try {
			File f1 = new File(fileDir, fileName);
			FileReader freader=new FileReader(f1);
			BufferedReader bfdreader=new BufferedReader(freader);
			String str_line=bfdreader.readLine();
		    while(str_line!=null) {
		       out.println(str_line + "<br>");
		       str_line=bfdreader.readLine();
		    }
		    bfdreader.close();
		    freader.close();
		} catch (IOException e) {
			out.print("文件读取错误" + "<br>");
		}
	}
%>