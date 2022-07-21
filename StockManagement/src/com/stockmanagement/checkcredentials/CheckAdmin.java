package com.stockmanagement.checkcredentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckAdmin {

	String url = "jdbc:mysql://localhost:3306/stockmanagement";
	String uname = "root";
	String pwd = "r00t";

	public boolean checkCreds(String aName, String aPwd) {

		String query = "SELECT * FROM ADMIN WHERE NAME = '" + aName + "'";
		try (Connection con = DriverManager.getConnection(url, uname, pwd)) {

			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
			//fetching password from database to validate
			String pwd = resultSet.getString(3);
			if (pwd.equals(aPwd)) {
				System.out.println("Admin Exists");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

}
