package com.stockmanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.stockmanagement.beans.Product;

public class ProductDB {
	String url="jdbc:mysql://localhost:3306/stockmanagement";
	String uname="root";
	String pwd="r00t";
	public void addProduct(Product product) {
		String query="INSERT INTO PRODUCT (ID,NAME,QUANTITY,PRICE) VALUES(?,?,?,?)";
		try(Connection con=DriverManager.getConnection(url, uname, pwd)){
			PreparedStatement statement=con.prepareStatement(query);
			statement.setInt(1,product.getId());
			statement.setString(2,product.getName());
			statement.setInt(3,product.getQuantity());
			statement.setFloat(4,product.getPrice());
			int rows =statement.executeUpdate();
			if(rows>0) {
				System.out.println("Product Details Inserted into Table");
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void viewAllProducts() {
		String query ="SELECT * FROM PRODUCT";
		try (Connection con = DriverManager.getConnection(url, uname, pwd)){
			Statement statement= con.createStatement();
			ResultSet resultSet=statement.executeQuery(query);
			System.out.println(String.format("%-10s %-15s %-10s %-10s","ProductId","ProductName","Quantity","Price" ));
			while(resultSet.next()) {
				int id=resultSet.getInt(1);
				String name=resultSet.getString(2);
				int quantity=resultSet.getInt(3);
				float price =resultSet.getFloat(4);
				String output="%-10d %-15s %-10d %.2f";
				System.out.println(String.format(output,id, name,quantity,price));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void viewProduct(int pId) {
		String query ="SELECT * FROM PRODUCT WHERE ID = "+pId;
		try (Connection con = DriverManager.getConnection(url, uname, pwd)){
			Statement statement= con.createStatement();
			ResultSet resultSet=statement.executeQuery(query);
			
			System.out.println(String.format("%-10s %-15s %-10s %-10s","ProductId","ProductName","Quantity","Price" ));
			while(resultSet.next()) {
				int id=resultSet.getInt(1);
				String name=resultSet.getString(2);
				int quantity=resultSet.getInt(3);
				float price =resultSet.getFloat(4);
				String output="%-10d %-15s %-10d %.2f";
				System.out.println(String.format(output,id, name,quantity,price));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Product fetchProduct(int pId) {
		String query ="SELECT * FROM PRODUCT WHERE ID = "+pId;
		try (Connection con = DriverManager.getConnection(url, uname, pwd)){
			Statement statement= con.createStatement();
			ResultSet resultSet=statement.executeQuery(query);
			
			while(resultSet.next()) {
				int id=resultSet.getInt(1);
				String name=resultSet.getString(2);
				int quantity=resultSet.getInt(3);
				float price =resultSet.getFloat(4);
				Product product =new Product(id,name,quantity,price);
				String output="%-10d %-10s %-10d %.2f";
				System.out.println(String.format(output,id, name,quantity,price));
				return product;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteProduct(int pId) {
		String query="DELETE FROM PRODUCT WHERE ID = "+pId;
		try(Connection con=DriverManager.getConnection(url, uname, pwd)){
			PreparedStatement statement=con.prepareStatement(query);
			int rows =statement.executeUpdate();
			if(rows>0) {
				System.out.println("Product Deleted");
			}
			else {
				System.out.println(rows+" rows changed ");
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	public void updateProduct() {
		
	}
	public void updateProductQuantity(int id, int quantity) {
		String query = "UPDATE PRODUCT SET QUANTITY = " +quantity+" WHERE ID = "+id;
		try(Connection con=DriverManager.getConnection(url, uname, pwd)){
			PreparedStatement statement=con.prepareStatement(query);
			int rows =statement.executeUpdate();
			if(rows>0) {
				System.out.println("Quantity Updated");
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
