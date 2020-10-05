package com.m2i.helloworld.entities;



public class User {
	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String name;

	
	public User() {
		super();
	}


	public User(int id, String userName, String password, String firstName, String name) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.name = name;
	}


	public User(String userName, String password, String firstName, String name) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.name = name;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", name=" + name + "]";
	}
	
	
	
	
}
