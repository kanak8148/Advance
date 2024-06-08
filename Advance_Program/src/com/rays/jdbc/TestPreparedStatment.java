package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestPreparedStatment {

	public static void main(String[] args) throws Exception {

//		add(9, "Sush", 109, 58, 48, 72);
//		search();
//		update(9, "sush", 109, 58, 48, 72);
//		findById(9);
		delete(8);

	}

	private static void add(int id, String name, int rollNo, int maths, int chemistry, int physics) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into marksheet value(?,?,?,?,?,?)");

		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, rollNo);
		ps.setInt(4, maths);
		ps.setInt(5, chemistry);
		ps.setInt(6, physics);

		int i = ps.executeUpdate();

		conn.close();
		ps.close();

		System.out.println("data add successfully.." + i);

	}

	private static void search() {
		// TODO Auto-generated method stub

	}

	private static void update(int id, String name, int rollNo, int maths, int chemistry, int physics)
			throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		PreparedStatement ps = conn.prepareStatement(
				"update marksheet set name = ?, rollNo = ?, maths = ?, chemistry = ?, physics = ? where id = ?");

		ps.setString(1, name);
		ps.setInt(2, rollNo);
		ps.setInt(3, maths);
		ps.setInt(4, chemistry);
		ps.setInt(5, physics);
		ps.setInt(6, id);

		int i = ps.executeUpdate();

		conn.close();
		ps.close();

		System.out.println("data update successfully.." + i);

	}

	private static void findById(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from marksheet where id = ?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getInt(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));

		} else {
			System.out.println("record not fount");
		}

		conn.close();
		ps.close();

	}

	private static void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = ?");

		ps.setInt(1, id);

		int i = ps.executeUpdate();

		conn.close();
		ps.close();

		if (i != 0) {

			System.out.println("data deleted successfully " + i);

		} else {
			System.out.println("id is not available");
		}

	}

}
