package com.stockmanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.stockmanagement.beans.Order;

public class OrderDB {
	String url="jdbc:mysql://localhost:3306/stockmanagement";
	String uname="root";
	String pwd="r00t";
	
	//function to insert order details into database
	public void placeOrder(Order order) {
		String query="INSERT INTO ORDERDETAILS (ID,PID,QUANTITY,TOTALAMOUNT) VALUES(?,?,?,?)";
		try(Connection con=DriverManager.getConnection(url, uname, pwd)){
			PreparedStatement statement=con.prepareStatement(query);
			statement.setInt(1,order.getId());
			statement.setInt(2, order.getpId());
			statement.setInt(3, order.getQuantity());
			statement.setFloat(4,order.getTotalAmount());
			int rows =statement.executeUpdate();
			if(rows>0) {
				System.out.println("Order Details Inserted into Table");
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}	
	public void viewAllOrders() {
		String query ="SELECT * FROM ORDERDETAILS";
		try (Connection con = DriverManager.getConnection(url, uname, pwd)){
			Statement statement= con.createStatement();
			ResultSet resultSet=statement.executeQuery(query);
			System.out.println(String.format("%-10s %-15s %-10s %-10s","OrderId","OrderQuantity","ProductId","TotalAmount" ));
			while(resultSet.next()) {
				int id=resultSet.getInt(1);
				int quantity =resultSet.getInt(2);
				int pId=resultSet.getInt(3);
				float totalAmount=resultSet.getFloat(4);
				String output="%-10d %-15d %-10s %.2f";
				System.out.println(String.format(output,id,quantity,pId,totalAmount));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void viewOrder(int oid) {
		String query ="SELECT * FROM ORDERDETAILS WHERE ID = "+oid;
		try (Connection con = DriverManager.getConnection(url, uname, pwd)){
			Statement statement= con.createStatement();
			ResultSet resultSet=statement.executeQuery(query);
			
			System.out.println(String.format("%-10s %-15s %-10s %-10s","OrderId","OrderQuantity","ProductId","TotalAmount" ));
			while(resultSet.next()) {
				int id=resultSet.getInt(1);
				int quantity =resultSet.getInt(2);
				int pId=resultSet.getInt(3);
				float totalAmount=resultSet.getFloat(4);
				String output="%-10d %-15d %-10s %.2f";
				System.out.println(String.format(output,id,quantity,pId,totalAmount));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
