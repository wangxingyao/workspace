package com.yaoge;

import java.io.UnsupportedEncodingException;

public class UserBean {
	String logname;
	String password;
	String email;
	String phone;
	String message;
	
	public UserBean() {
		logname  = "";
		password = "";
		email    = "";
		phone    = "";
		message  = "";
	}
	
	public void setLogname(String s) throws UnsupportedEncodingException {
		logname = s;
	}
	public String getLogname() {
		return logname;
	}
	public void setPassword(String s) throws UnsupportedEncodingException {
		password = s;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String s) throws UnsupportedEncodingException {
		email = s;
	}
	public String getEmail() {
		return email;
	}
	public void setPhone(String s) throws UnsupportedEncodingException {
		phone = s;
	}
	public String getPhone() {
		return phone;
	}
	public void setMessage(String s) throws UnsupportedEncodingException {
		message = s;
	}
	public String getMessage() {
		return message;
	}
}
