package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransaction {

	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate("insert into marksheet values(10, 'Kirti', 102, 68, 75, 84)");
			i = stmt.executeUpdate("insert into marksheet values(11, 'Kirti', 102, 68, 75, 84)");
			i = stmt.executeUpdate("insert into marksheet values(12, 'Kirti', 102, 68, 75, 84)");

			System.out.println("Data inserted = " + i);

			conn.commit();
			System.out.println("commit");
			conn.close();

		} catch (Exception e) {
			conn.rollback();
			System.out.println("rollBack");
			System.out.println(e.getMessage());
		}

	}

}
