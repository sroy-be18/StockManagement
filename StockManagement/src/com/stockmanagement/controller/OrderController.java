package com.stockmanagement.controller;

import java.util.Scanner;

import com.stockmanagement.beans.Order;
import com.stockmanagement.beans.Product;
import com.stockmanagement.database.OrderDB;

public class OrderController {
	PaymentController paymentController =new PaymentController();
	ProductController productController =new ProductController();
	Scanner keyInput=new Scanner (System.in);
	OrderDB orderDb=new OrderDB();
	
	//Function for placing a order
	public void placeOrder() {
		System.out.println("Enter the Id of Product you want to buy");
		int pId=keyInput.nextInt();
		keyInput.nextLine();
		Product product=productController.fetchProduct(pId);
		System.out.println("Enter the quantity you want to purchase");
		int quantity=keyInput.nextInt();
		int availQuanity=product.getQuantity();
		//checking if the required quantity is less than or equals to stock
		if(availQuanity>quantity) {
			int newQuantity= availQuanity- quantity;
			//setting new quantity after ordering
			product.setQuantity(newQuantity);
			//updating quantity of product in database
			productController.updateProductQuantity(pId,newQuantity);
			System.out.println("Enter the Id for a Order");
			int id=keyInput.nextInt();
			keyInput.nextLine();
			//calculating total amount of order 
			float totalAmount=quantity*product.getPrice();
			Order order =new Order (id,pId,quantity,totalAmount,product);
			//placing order details into orderdetails table
			orderDb.placeOrder(order);
			//placing payment details into payment table
			paymentController.insertPayment(id, totalAmount);
			
		}
		
	}
	
	public void viewAllOrders() {
		//fetching order details from database
		orderDb.viewAllOrders();
	}
	
	public void viewOrder() {
		System.out.println("Enter the Id of Order you want to see");
		int id=keyInput.nextInt();
		keyInput.nextLine();
		//fetching order details of particular order from database
		orderDb.viewOrder(id);
	}

}
