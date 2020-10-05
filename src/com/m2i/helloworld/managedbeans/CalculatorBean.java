package com.m2i.helloworld.managedbeans;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;


@ManagedBean
@SessionScoped
public class CalculatorBean {
	
	
	private int a;
	private int b;
	private int result;
	
	public CalculatorBean(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	public CalculatorBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String add(ActionEvent e) {
		System.out.println("public int add()");
		this.result = this.a+this.b;
		return "result";
	}
}
