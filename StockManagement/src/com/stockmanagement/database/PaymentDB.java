package com.stockmanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PaymentDB {
	String url="jdbc:mysql://localhost:3306/stockmanagement";
	String uname="root";
	String pwd="r00t";
	
	public void insertPayment(int pId, float totalAmount) {
		String query="INSERT INTO PAYMENT (ID,TOTALAMOUNT) VALUES(?,?)";
		try(Connection con=DriverManager.getConnection(url, uname, pwd)){
			PreparedStatement statement=con.prepareStatement(query);
			statement.setInt(1,pId);
			statement.setFloat(2,totalAmount);
			int rows =statement.executeUpdate();
			if(rows>0) {
				System.out.println("Payment Details Inserted into Table");
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void viewAllPayments() {
		String query ="SELECT * FROM PAYMENT";
		try (Connection con = DriverManager.getConnection(url, uname, pwd)){
			Statement statement= con.createStatement();
			ResultSet resultSet=statement.executeQuery(query);
			System.out.println(String.format("%-10s %-20s","PaymentId","TotalAmount" ));
			while(resultSet.next()) {
				int id=resultSet.getInt(1);
				float totalAmount=resultSet.getFloat(2);
				String output="%-10d %.2f";
				System.out.println(String.format(output,id,totalAmount));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void viewPayment(int pId) {
		String query ="SELECT * FROM PAYMENT WHERE ID = "+pId;
		try (Connection con = DriverManager.getConnection(url, uname, pwd)){
			Statement statement= con.createStatement();
			ResultSet resultSet=statement.executeQuery(query);
			
			System.out.println(String.format("%-10s %-20s %-10s","OrderId","OrderQuantity","TotalAmount" ));
			while(resultSet.next()) {
				int id=resultSet.getInt(1);
				float totalAmount=resultSet.getFloat(2);
				String output="%-10d %.2f";
				System.out.println(String.format(output,id,totalAmount));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
