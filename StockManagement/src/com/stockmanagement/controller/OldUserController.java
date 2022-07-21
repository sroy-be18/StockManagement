package com.stockmanagement.controller;

import java.util.Scanner;

public class OldUserController {

	Scanner keyInput = new Scanner(System.in);
	ProductController productController = new ProductController();
	OrderController orderController = new OrderController();

	//Module to handle Products
	public void ProductModule() {
		System.out.println("1.View Products");
		System.out.println("2.View Specific Product");
		System.out.println("3. Exit");
		System.out.println("Enter your choice");
		int choice = keyInput.nextInt();
		keyInput.nextLine();
		while (choice > 0 && choice < 3) {
			switch (choice) {
			case 1:
				productController.viewAllProducts();
				break;
			case 2:
				productController.viewProduct();
				break;
			}
			System.out.println("1.View Products");
			System.out.println("2.View Specific Product");
			System.out.println("3. Exit");
			System.out.println("Enter your choice");
			choice = keyInput.nextInt();
			keyInput.nextLine();
		}
		System.out.println("Exiting the module");

	}

	//Module to handle orders
	public void OrderModule() {
		System.out.println("1.View Specific Order");
		System.out.println("2.Place Order");
		System.out.println("3. Exit");
		System.out.println("Enter your choice");
		int choice = keyInput.nextInt();
		keyInput.nextLine();
		while (choice > 0 && choice < 3) {
			switch (choice) {
			case 1:
				orderController.viewOrder();
				break;
			case 2:
				orderController.placeOrder();
				break;
			}
			System.out.println("1.View Specific Order");
			System.out.println("2.Place Order");
			System.out.println("3. Exit");
			System.out.println("Enter your choice");
			choice = keyInput.nextInt();
			keyInput.nextLine();
		}
		System.out.println("Exiting the module");
	}

}
