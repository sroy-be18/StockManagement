package com.stockmanagement.controller;

import java.util.Scanner;

public class OldAdminController {

	UserController userController = new UserController();
	OrderController orderController = new OrderController();
	PaymentController paymentController = new PaymentController();
	ProductController productController = new ProductController();
	Scanner keyInput = new Scanner(System.in);

	//Module to handle User 
	public void UserModule() {
		System.out.println("1.Add User");
		System.out.println("2.View Users");
		System.out.println("3.View Specific User");
		System.out.println("4.Delete User");
		System.out.println("5.Update User");
		System.out.println("6.Exit");
		System.out.println("Enter you choice");

		int choice = keyInput.nextInt();
		keyInput.nextLine();
		while (choice > 0 && choice < 6) {
			switch (choice) {
			case 1:
				userController.createUser();
				break;
			case 2:
				userController.viewAllUsers();
				break;
			case 3:
				userController.viewUser();
				break;
			case 4:
				userController.deleteUser();
				break;
			case 5:
				userController.updateUser();
				break;
			}
			System.out.println("1.Add User");
			System.out.println("2.View Users");
			System.out.println("3.View Specific User");
			System.out.println("4.Delete User");
			System.out.println("5.Update User");
			System.out.println("6.Exit");
			System.out.println("Enter you choice");
			choice = keyInput.nextInt();
			keyInput.nextLine();
		}
		System.out.println("Exiting from the module");

	}

	//Module to handle Orders
	public void OrderModule() {
		System.out.println("1.View Orders");
		System.out.println("2.View Specific Order");
		System.out.println("3.Exit");
		System.out.println("Enter your choice ");
		int choice = keyInput.nextInt();
		keyInput.nextLine();
		while (choice > 0 && choice < 3) {
			switch (choice) {
			case 1:
				orderController.viewAllOrders();
				break;
			case 2:
				orderController.viewOrder();

			}
			System.out.println("1.View Orders");
			System.out.println("2.View Specific Order");
			System.out.println("3.Exit");
			System.out.println("Enter your choice ");
			choice = keyInput.nextInt();
			keyInput.nextLine();
		}
		System.out.println("Exiting the module");

	}

	//Module to handle Products
	public void ProductModule() {
		System.out.println("1.Add Product");
		System.out.println("2.View Products");
		System.out.println("3.View Specific Product");
		System.out.println("4.Delete Product");
		System.out.println("5.Update Product");
		System.out.println("6. Exit");
		System.out.println("Enter your choice");
		int choice = keyInput.nextInt();
		keyInput.nextLine();
		while (choice > 0 && choice < 6) {
			switch (choice) {
			case 1:
				productController.addProduct();
				break;
			case 2:
				productController.viewAllProducts();
				break;
			case 3:
				productController.viewProduct();
				break;
			case 4:
				productController.deleteProduct();
				break;
			case 5:
				productController.updateProduct();
				break;
			}
			System.out.println("1.Add Product");
			System.out.println("2.View Products");
			System.out.println("3.View Specific Product");
			System.out.println("4.Delete Product");
			System.out.println("5.Update Product");
			System.out.println("6. Exit");
			System.out.println("Enter your choice");
			choice = keyInput.nextInt();
			keyInput.nextLine();
		}
		System.out.println("Exiting the module");

	}

	//Module to handle payments
	public void PaymentModule() {
		System.out.println("1.View Payments");
		System.out.println("2.View Specific Payment");
		System.out.println("3.Exit");
		System.out.println("Enter your choice");
		int choice = keyInput.nextInt();
		keyInput.nextLine();
		while (choice > 0 && choice < 3) {
			switch (choice) {
			case 1:
				paymentController.viewAllPayments();
				break;
			case 2:
				paymentController.viewPayment();
				break;
			}
			System.out.println("1.View Payments");
			System.out.println("2.View Specific Payment");
			System.out.println("3.Exit");
			System.out.println("Enter your choice");
			choice = keyInput.nextInt();
			keyInput.nextLine();
		}
		System.out.println("Exiting Module");

	}

}
