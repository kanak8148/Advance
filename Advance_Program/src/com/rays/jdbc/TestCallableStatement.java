package com.rays.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TestCallableStatement {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ncs", "root", "root");

		CallableStatement cs = conn.prepareCall("CALL myprocedure(?,?)");

		cs.setInt(1, 1);
		cs.setString(2, "Sivam");

		ResultSet rs = cs.executeQuery();
		
		while (rs.next()) {
			
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
			
		}

		

	}

}
