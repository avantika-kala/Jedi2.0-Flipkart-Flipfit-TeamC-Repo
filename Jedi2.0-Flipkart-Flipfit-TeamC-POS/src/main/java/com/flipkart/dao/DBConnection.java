package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author: avantika
 */
public class DBConnection {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/Flipfit";

	static final String USER = "root";

	static final String PASS = "";
	
	/**
	 * Execute the given Update/Delete/Insert Query
	 * @param statement
	 * @return
	 */
	
	public static int executeDMLQuery(PreparedStatement statement) {
		if(statement != null) {
			try {
				//System.out.println("Executing Query " + statement);
				return statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	/**
	 * Execute the given fetch query
	 * @param statement
	 * @return result from the execution
	 */
	
	public static ResultSet executeQuery(PreparedStatement statement) {
		ResultSet rs=null;
		try {
			rs = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	/**
	 * Create connection 
	 * @return Connection object
	 */
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			System.out.println("Database could not be connected");
		}
		return conn;

	}
}
