package com.m2i.helloworld.dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.m2i.helloworld.entities.User;

public class UserDAO implements Closeable{
	
	private Connection conn;

	public UserDAO() throws NamingException, SQLException{
		super();
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/jeeDB");
		conn = ds.getConnection();
	
	}
	
	
	public List<User> findAll() throws SQLException{
		List<User> list = new ArrayList<User>();  
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM users");
		
	    while(rs.next()) {
	    	Integer id = rs.getInt("id");
	    	String userName = rs.getString("username");
	    	String firstName = rs.getString("firstname");	    			
	    	String name = rs.getString("name");
	    	String password = rs.getString("password");
	    	User u = new User(id,userName,password,firstName,name);
	    	list.add(u);
	    	
		}
	    
	    return list;
	}
	
	public void close() throws IOException{
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
