package com.comcast.crm.genericdatabaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {

	Connection con;
	int result = 0;
	public void getConnection(String url, String username, String password) throws Throwable {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {

		}
	}
	
	public void getConnection() throws Throwable {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("dbc:mysql://127.0.0.1:3306/school", "root", "root");
		} catch (Exception e) {

		}
	}

	public void closeConnection() {
		try {
			con.close();
		} catch (Exception e) {

		}
	}

	public ResultSet executeSelectQuery(String query) {
		ResultSet result = null;
		try {
			Statement stat = con.createStatement();
			result = stat.executeQuery(query);
		} catch (Exception e) {

		}
		return result;
	}

	public int executeNonSelectQuery(String query) {
		
		try {
			Statement stat = con.createStatement();
			result = stat.executeUpdate(query);
		} catch (Exception e) {

		}
		return result;
	}
}
