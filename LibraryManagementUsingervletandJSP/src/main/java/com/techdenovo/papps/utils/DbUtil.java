package com.techdenovo.papps.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private String url = "jdbc:mysql://localhost:3306/local_librarymanagement";
	private String username = "root";
	private String password = "Lokesh@12";
	
	public Connection getDbConnection() throws ClassNotFoundException, SQLException{
		Connection connection = null;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
