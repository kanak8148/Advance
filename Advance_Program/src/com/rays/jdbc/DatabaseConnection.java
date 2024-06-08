package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DatabaseConnection {

	public static Connection getConnection() throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");

		Class.forName(rb.getString("driver"));

		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("password"));

		return conn;
	}

	public static void main(String[] args) throws Exception {

		Connection conn = getConnection();

		Statement stmt = conn.createStatement();

		System.out.println("connection successfully....");

	}

}
