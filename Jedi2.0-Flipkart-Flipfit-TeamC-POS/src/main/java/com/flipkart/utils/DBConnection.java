package com.flipkart.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author avantika.kala
 */
public class DBConnection {
	private static Connection connection = null;

	public static Connection getConnection() {
		try {
			if (isValid()) {
				return connection;
			} else {
				try {
					String driver = "com.mysql.jdbc.Driver";
					String url = "jdbc:mysql://localhost:3306/flipfit";
					String user = "root";
					String password = "password";
					Class.forName(driver);
					connection = DriverManager.getConnection(url, user, password);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

	public static boolean isValid() throws SQLException {
		return connection != null && !connection.isClosed();
	}
}
