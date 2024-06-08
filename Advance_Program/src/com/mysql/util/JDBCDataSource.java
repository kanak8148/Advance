package com.mysql.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {

	private static JDBCDataSource dataSource;

	private static ComboPooledDataSource cpds = null;

	private JDBCDataSource() {

	}

	public static JDBCDataSource getInstance() {

		if (dataSource == null) {

			ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.system");

			dataSource = new JDBCDataSource();
			dataSource.cpds = new ComboPooledDataSource();

			try {
				dataSource.cpds.setDriverClass(rb.getString("driver"));
			} catch (PropertyVetoException e) {
				System.out.println(e);
				e.printStackTrace();
			}

			dataSource.cpds.setJdbcUrl(rb.getString("url"));
			System.out.println("URL= " + rb.getString("url"));
			dataSource.cpds.setUser(rb.getString("username"));
			System.out.println("USERNAME= " + rb.getString("username"));
			dataSource.cpds.setPassword(rb.getString("password"));
			System.out.println("PASSWORD= " + rb.getString("password"));
			dataSource.cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialpoolsize")));
			dataSource.cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireincrement")));
			dataSource.cpds.setMaxAdministrativeTaskTime(Integer.parseInt(rb.getString("maxpoolsize")));

		}
		return dataSource;

	}

	public static Connection getConnection() throws Exception {

		System.out.println("in GetConnection");

		return getInstance().cpds.getConnection();

	}

	public static void closeConnection(Connection conn) throws Exception {

		if (conn != null) {

			conn.close();

		}

	}

	public static void trnRollback(Connection conn) throws Exception {

		if (conn != null) {

			conn.rollback();

		}

	}

}
