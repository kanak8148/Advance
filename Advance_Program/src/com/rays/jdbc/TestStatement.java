package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestStatement {

	public static void main(String[] args) throws Exception {

//		add();
//		search();
//		update();
		delete();

	}

	private static void delete() throws Exception {

		ResourceBundle rc = ResourceBundle.getBundle("com.rays.bundle.system");

		Class.forName(rc.getString("driver"));

		Connection conn = DriverManager.getConnection(rc.getString("url"), rc.getString("username"),
				rc.getString("password"));

		Statement st = conn.createStatement();

		String sql = "delete from marksheet where rollNo = 101";

		int i = st.executeUpdate(sql);

		conn.close();
		st.close();

		System.out.println("data delete successfulyy.." + i);

	}

	private static void update() throws Exception {

		ResourceBundle rc = ResourceBundle.getBundle("com.rays.bundle.system");

		Class.forName(rc.getString("driver"));

		Connection conn = DriverManager.getConnection(rc.getString("url"), rc.getString("username"),
				rc.getString("password"));

		Statement st = conn.createStatement();

		String sql = "update marksheet set name = 'Susmita', maths = 82 where rollNo = 102";

		int i = st.executeUpdate(sql);

		conn.close();
		st.close();

		System.out.println("data update successfulyy.." + i);

	}

	private static void search() throws Exception {

		ResourceBundle rc = ResourceBundle.getBundle("com.rays.bundle.system");

		Class.forName(rc.getString("driver"));

		Connection conn = DriverManager.getConnection(rc.getString("url"), rc.getString("username"),
				rc.getString("password"));

		Statement st = conn.createStatement();

		String sql = "select * from marksheet";

		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {

			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getInt(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));

		}

		conn.close();
		st.close();

	}

	private static void add() throws Exception {

		ResourceBundle rc = ResourceBundle.getBundle("com.rays.bundle.system");

		Class.forName(rc.getString("driver"));

		Connection conn = DriverManager.getConnection(rc.getString("url"), rc.getString("username"),
				rc.getString("password"));

		Statement st = conn.createStatement();

		String sql = "insert into marksheet values(2, 'Kirti', 102, 68, 75, 84)";

		int i = st.executeUpdate(sql);

		conn.close();
		st.close();

		System.out.println("data inserted successfullyy.." + i);

	}

}
