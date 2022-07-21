package com.stockmanagement;

import java.util.*;

import com.stockmanagement.controller.AdminController;
import com.stockmanagement.controller.UserController;

public class StockManagement {

	public static void main(String[] args) {
		AdminController adminController = new AdminController();
		UserController userController = new UserController();

		System.out.println("Welcome to Stock Management System");
		System.out.println("1.New Admin");
		System.out.println("2.Existing Admin");
		System.out.println("3.New User");
		System.out.println("4.Existing User");
		System.out.println("5.Exit");

		Scanner keyInput = new Scanner(System.in);

		int choice = keyInput.nextInt();
		keyInput.nextLine();

		while (choice > 0 && choice < 5) {
			switch (choice) {
			case 1:
				adminController.createAdmin();
				break;
			case 2:
				adminController.oldAdminController();
				break;
			case 3:
				userController.createUser();
				break;
			case 4:
				userController.oldUserController();
				break;

			}
			System.out.println("Welcome to Stock Management System");
			System.out.println("1.New Admin");
			System.out.println("2.Existing Admin");
			System.out.println("3.New User");
			System.out.println("4.Existing User");
			System.out.println("5.Exit");
			choice = keyInput.nextInt();
			keyInput.nextLine();
		}
		System.out.println("Exiting the Program");

	}

}
