package com.yaoge;

public class Data {
	double a;
	double d;
	double q;
	double n;
	double sum;
	StringBuffer mess;
	
	public Data() {
		mess = new StringBuffer();
	}
	
	public void setA(double a) {
		this.a = a;
	}
	public double getA() {
		return a;
	}
	public void setD(double d) {
		this.d = d;
	}
	public double getD() {
		return d;
	}
	public void setQ(double q) {
		this.q = q;
	}
	public double getQ() {
		return q;
	}
	public void setN(double n) {
		this.n = n;
	}
	public double getN() {
		return n;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public double getSum() {
		return sum;
	}
	
	public void setMess(String s) {
		mess.append(s);
	}
	public void resetMess() {
		mess.setLength(0);
	}
	public String getMess() {
		return mess.toString();
	}
}
