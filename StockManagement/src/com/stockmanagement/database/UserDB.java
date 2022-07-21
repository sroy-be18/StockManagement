package com.stockmanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.stockmanagement.beans.User;

public class UserDB {
	String url="jdbc:mysql://localhost:3306/stockmanagement";
	String uname="root";
	String pwd="r00t";
	
	public void addUser(User user) {
		String query="INSERT INTO USER (ID,NAME,PASSWORD,EMAIL,MOBILE) VALUES(?,?,?,?,?)";
		try(Connection con=DriverManager.getConnection(url, uname, pwd)){
			PreparedStatement statement=con.prepareStatement(query);
			statement.setInt(1,user.getId());
			statement.setString(2,user.getName());
			statement.setString(3,user.getPassword());
			statement.setString(4,user.getEmail());
			statement.setString(5,user.getMobile());
			int rows =statement.executeUpdate();
			if(rows>0) {
				System.out.println("User Details Inserted into Table");
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void viewAllUsers() {
		String query ="SELECT * FROM USER";
		try (Connection con = DriverManager.getConnection(url, uname, pwd)){
			Statement statement= con.createStatement();
			ResultSet resultSet=statement.executeQuery(query);
			System.out.println(String.format("%-10s %-10s %-15s %-20s %-10s","UserId","UserName","UserPassword","UserEmail","UserNUmber"));
			while(resultSet.next()) {
				int id=resultSet.getInt(1);
				String name=resultSet.getString(2);
				String password=resultSet.getString(3);
				String email=resultSet.getString(4);
				String number=resultSet.getString(5);
				String output="%-10d %-10s %-15s %-20s %-10s";
				System.out.println(String.format(output,id, name,password,email,number));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void viewUser(int uid) {
		String query ="SELECT * FROM USER WHERE ID = "+uid;
		try (Connection con = DriverManager.getConnection(url, uname, pwd)){
			Statement statement= con.createStatement();
			ResultSet resultSet=statement.executeQuery(query);
			
			while(resultSet.next()) {
				int id=resultSet.getInt(1);
				String name=resultSet.getString(2);
				String password=resultSet.getString(3);
				String email=resultSet.getString(4);
				String number=resultSet.getString(5);
				String output="%-10d %-10s %-10s %-10s %-10s";
				System.out.println(String.format(output,id, name,password,email,number));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public void deleteUser(int uid) {
		String query="DELETE FROM USER WHERE ID = "+uid;
		try(Connection con=DriverManager.getConnection(url, uname, pwd)){
			PreparedStatement statement=con.prepareStatement(query);
			int rows =statement.executeUpdate();
			if(rows>0) {
				System.out.println("User Deleted");
			}
			else {
				System.out.println(rows+" rows changed ");
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
