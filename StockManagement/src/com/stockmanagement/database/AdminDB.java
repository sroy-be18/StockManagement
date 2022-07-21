package com.stockmanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.stockmanagement.beans.Admin;

public class AdminDB {
	
	String url="jdbc:mysql://localhost:3306/stockmanagement";
	String uname="root";
	String pwd="r00t";
	
	public void addAdmin(Admin admin) {
		String query="INSERT INTO ADMIN (ID,NAME,PASSWORD,EMAIL,MOBILE) VALUES(?,?,?,?,?)";
		try(Connection con=DriverManager.getConnection(url, uname, pwd)){
			PreparedStatement statement=con.prepareStatement(query);
			statement.setInt(1,admin.getId());
			statement.setString(2,admin.getName());
			statement.setString(3,admin.getPassword());
			statement.setString(4,admin.getEmail());
			statement.setString(5,admin.getMobile());
			int rows =statement.executeUpdate();
			if(rows>0) {
				System.out.println("Admin Details Inserted into Table");
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
