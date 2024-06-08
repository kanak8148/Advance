package com.rays.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.util.JDBCDataSource;

public class UserModel {

	public Integer nextPk() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from users");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

			System.out.println("Max Id " + pk);

		}
		conn.close();
		pstmt.close();
		return pk + 1;

	}

	public void add(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into users values(?,?,?,?,?,?,?,?)");

		int pk = nextPk();

		pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getLoginId());
		pstmt.setString(5, bean.getPassword());
		pstmt.setInt(6, bean.getPhoneNo());
		pstmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(8, bean.getGender());

		int i = pstmt.executeUpdate();

		conn.close();
		pstmt.close();

		System.out.println("Data Add Successfully.. " + i);

	}

	public void update(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement(
				"update users set firstName = ?, lastName = ?, loginId = ?, password = ?, phoneNo = ?, dob = ?, gender = ? where id = ?");

		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getLoginId());
		pstmt.setString(4, bean.getPassword());
		pstmt.setInt(5, bean.getPhoneNo());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(7, bean.getGender());
		pstmt.setInt(8, bean.getId());

		int i = pstmt.executeUpdate();

		conn.close();
		pstmt.close();

		System.out.println("Data Update Successfully.. " + i);

	}

	public void delete(int id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("delete from users where id = ?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();

		conn.close();
		pstmt.close();

		if (i != 0) {
			System.out.println("Data Delete Successfully.. " + i);
		} else {
			System.err.println("Data Delete Unccessfully.. " + i);
		}

	}

	public UserBean findByPk(int id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from users where id = ?");

		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setPhoneNo(rs.getInt(6));
			bean.setDob(rs.getDate(7));
			bean.setGender(rs.getString(8));

		}

		conn.close();
		pstmt.close();
		return bean;

	}

	public UserBean findByLogin(String loginId) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from users where loginId = ?");

		pstmt.setString(1, loginId);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setPhoneNo(rs.getInt(6));
			bean.setDob(rs.getDate(7));
			bean.setGender(rs.getString(8));

		}

		conn.close();
		pstmt.close();
		return bean;

	}

	public UserBean authenticate(String loginId, String password) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from users where loginId = ? and password = ?");

		pstmt.setString(1, loginId);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setPhoneNo(rs.getInt(6));
			bean.setDob(rs.getDate(7));
			bean.setGender(rs.getString(8));

		}

		conn.close();
		pstmt.close();
		return bean;

	}

	public List search(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from users where 1=1");

		if (bean != null) {

			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {

				sql.append(" and firstName like '" + bean.getFirstName() + "%'");

			}

			if (bean.getDob() != null && bean.getDob().getTime() > 0) {

				sql.append(" and dob like '" + new java.sql.Date(bean.getDob().getTime()) + "%'");

			}

		}

		System.out.println("sql===> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setPhoneNo(rs.getInt(6));
			bean.setDob(rs.getDate(7));
			bean.setGender(rs.getString(8));
			list.add(bean);

		}

		conn.close();
		pstmt.close();
		return list;

	}

}
