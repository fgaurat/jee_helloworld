package com.m2i.helloworld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://formation-jee.mysql.database.azure.com:3306/fred?serverTimezone=UTC",
					"admin_mysql@formation-jee", "X5ejhY1reYiBNj58D");
			
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM users");
			
		    while(rs.next()) {
		    	System.out.println(rs.getString("name"));
			}
			
			System.out.println("ok");
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

}
