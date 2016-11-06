package yaoge;

import java.sql.*;
import java.io.*;

public class QueryBean {
	String databaseName = "";
	String tableName = "";
	String username = "";
	String password = "";
	StringBuffer queryResult;
	String license = "";
	String brand = "";
	String date = "";
	
	public QueryBean() {
		queryResult = new StringBuffer();
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (Exception e) {}
	}
	
	public void setDatabaseName(String s) {
		databaseName = s.trim();
		queryResult = new StringBuffer();
	}
	
	public String getDatabaseName() {
		return databaseName;
	}
	
	public void setTableName(String s) {
		tableName = s.trim();
		queryResult = new StringBuffer();
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public void setUsername(String s) {
		username = s.trim();
		queryResult = new StringBuffer();
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String s) {
		password = s.trim();
		queryResult = new StringBuffer();
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setLicense(String s) throws UnsupportedEncodingException {
		license = new String(s.getBytes("iso-8859-1"), "utf-8");
	}
	
	public String getLicense() {
		return license;
	}
	
	public void setBrand(String s) throws UnsupportedEncodingException {
		brand = new String(s.getBytes("iso-8859-1"), "utf-8");
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setDate(String s) throws UnsupportedEncodingException {
		date = new String(s.getBytes("iso-8859-1"), "utf-8");
	}
	
	public String getDate() {
		return date;
	}
	
	public void insertData() {
		if (license == "" || brand == "" || date == "") {
			System.out.println("插入数据不完整");
			return ;
		}
		Connection con;
		Statement sql;
		ResultSet rs;

		try {
			String url = "jdbc:mysql://localhost:3306/"+ databaseName +"?useUnicode=true&characterEncoding=utf-8&useSSL=false";			
			con = DriverManager.getConnection(url, username, password);
			sql = con.createStatement();
			String str = "insert into "+tableName+" (license, brand, date) values ('"+license+"', '"+brand+"', '"+date+"');";
			System.out.println(str);
			sql.execute(str);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public StringBuffer getQueryResult() {
		Connection con;
		Statement sql;
		ResultSet rs;
		
		try {
			String url = "jdbc:mysql://localhost:3306/"+ databaseName +"?useUnicode=true&characterEncoding=utf-8&useSSL=false";			
			con = DriverManager.getConnection(url, username, password);
			sql = con.createStatement();
			rs = sql.executeQuery("select * from "+tableName+";");
			
			rs.last();
			queryResult.append("最后一个提交的数据为:<BR>");
			queryResult.append("  车牌号:\""+rs.getString(2)+", 品牌:\""+rs.getString(3)+", 生产日期:\""+rs.getString(4)+"<BR><BR>");
			
			queryResult.append("目前已登记车辆共"+rs.getRow()+"辆:");
			
			queryResult.append("<table border=2>");
			queryResult.append("<tr>");
			queryResult.append("<th width=100>" + " ");
			queryResult.append("<th width=100>" + "车牌号");
			queryResult.append("<th width=100>" + "品牌");
			queryResult.append("<th width=100>" + "生产日期");
			queryResult.append("</tr>");
			int i=1;
			if (rs.first()) {
				queryResult.append("<tr>");
				queryResult.append("<td>" + i + "</td>");
				queryResult.append("<td>" + rs.getString(2) + "</td>");
				queryResult.append("<td>" + rs.getString(3) + "</td>");
				queryResult.append("<td>" + rs.getString(4) + "</td>");	
				queryResult.append("</tr>");
			}
			while (rs.next()) {
				++i;
				queryResult.append("<tr>");
				queryResult.append("<td>" + i + "</td>");
				queryResult.append("<td>" + rs.getString(2) + "</td>");
				queryResult.append("<td>" + rs.getString(3) + "</td>");
				queryResult.append("<td>" + rs.getString(4) + "</td>");	
				queryResult.append("</tr>");
			}
		} catch (SQLException e) {
			System.out.print(e);
		}
		
		return queryResult;
	}
}
