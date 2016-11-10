package com.yaoge;

public class MessageBean {
	String logname;
	String password;
	String email;
	String phone;
	String message;
	
	public MessageBean() {
		logname  = new String();
		password = new String();
		email    = new String();
		phone    = new String();
		message  = new String();
	}
	
	public void setLogname(String s) {
		logname = s;
	}
	public String getLogname() {
		return logname;
	}
	public void setPassword(String s) {
		password = s;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String s) {
		email = s;
	}
	public String getEmail() {
		return email;
	}
	public void setPhone(String s) {
		phone = s;
	}
	public String getPhone() {
		return phone;
	}
	public void setMessage(String s) {
		message = s;
	}
	public String getMessage() {
		return message;
	}
}
