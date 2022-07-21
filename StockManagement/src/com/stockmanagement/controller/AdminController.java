package com.stockmanagement.controller;

import java.util.Scanner;

import com.stockmanagement.beans.Admin;
import com.stockmanagement.checkcredentials.CheckAdmin;
import com.stockmanagement.database.AdminDB;

public class AdminController {

	Scanner keyInput = new Scanner(System.in);
	AdminDB adminDb = new AdminDB();
	CheckAdmin checkAdmin = new CheckAdmin();
	OldAdminController oldAdminController = new OldAdminController();

	//Creating new Admin
	public void createAdmin() {
		System.out.println("Enter Admin Id");
		int id = keyInput.nextInt();
		keyInput.nextLine();
		System.out.println("Enter Admin Name");
		String name = keyInput.nextLine();
		System.out.println("Enter Admin Password");
		String password = keyInput.nextLine();
		System.out.println("Enter Admin Email");
		String email = keyInput.nextLine();
		System.out.println("Enter Admin Mobile");
		String mobile = keyInput.nextLine();
		Admin admin = new Admin(id, name, password, email, mobile);
		//Adding admin data to database
		adminDb.addAdmin(admin);
		System.out.println("Admin Created Successfully");
	}

	//Already registered Admin
	public void oldAdminController() {
		System.out.println("Enter Admin Name");
		String name = keyInput.nextLine();
		System.out.println("Enter Admin Password");
		String password = keyInput.nextLine();
		
		//Checking credentials of Admin
		Boolean credentials = checkAdmin.checkCreds(name, password);
		if (credentials == true) {
			System.out.println("1. User Module");
			System.out.println("2. Product Module");
			System.out.println("3. Order Module");
			System.out.println("4. Payment Module");
			System.out.println("5. Exit");
			System.out.println("Enter your choice");
			int choice = keyInput.nextInt();
			keyInput.nextLine();
			while (choice > 0 && choice < 5) {
				switch (choice) {
				case 1:
					oldAdminController.UserModule();
					break;

				case 2:
					oldAdminController.ProductModule();
					break;
				case 3:
					oldAdminController.OrderModule();
					break;
				case 4:
					oldAdminController.PaymentModule();
					break;

				}
				System.out.println("1. User Module");
				System.out.println("2. Product Module");
				System.out.println("3. Order Module");
				System.out.println("4. Payment Module");
				System.out.println("5. Exit");
				System.out.println("Enter your choice");
				choice = keyInput.nextInt();
				keyInput.nextLine();
			}
			System.out.println("Exiting the module");
		}

	}

}
