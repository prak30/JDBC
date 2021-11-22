package com.Jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class DBdemo {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
		String userName = "root";
		String password = "1234";
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded!");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("cannot find driver in classpath!", e);
		}

		listDrivers();

		try {
			System.out.println("Connecting to database:" + jdbcURL);
			con = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("connection is successfull!!!!!!" + con);
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	private static void listDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName());

		}

	}

}
