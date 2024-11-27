package com.techdenovo.papps.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private String url = "http://localhost:8080/LibraryManagementUsingServletJsp/";
	private String username = "local_library_management";
	private String password = "local_library_management";
	
	public Connection getDbConnection(){
		Connection connection = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
