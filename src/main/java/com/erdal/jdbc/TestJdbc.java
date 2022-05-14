package com.erdal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String[] args) throws SQLException {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		Connection myConn = null;

		try {
			System.out.println("Connecting to database: " + jdbcUrl);

			myConn = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("Connection successful!!!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (myConn != null)
				myConn.close();
		}

	}

}
