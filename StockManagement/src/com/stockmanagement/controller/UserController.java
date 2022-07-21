package com.stockmanagement.controller;

import java.util.Scanner;

import com.stockmanagement.beans.User;
import com.stockmanagement.checkcredentials.CheckUser;
import com.stockmanagement.database.UserDB;

public class UserController {
	Scanner keyInput = new Scanner(System.in);
	OldUserController oldUserController = new OldUserController();
	CheckUser checkUser = new CheckUser();
	UserDB userDb = new UserDB();
	
	//function to create new user 
	public void createUser() {

		System.out.println("Enter User Id");
		int id = keyInput.nextInt();
		keyInput.nextLine();
		System.out.println("Enter User Name");
		String name = keyInput.nextLine();
		System.out.println("Enter User Password");
		String password = keyInput.nextLine();
		System.out.println("Enter User Email");
		String email = keyInput.nextLine();
		System.out.println("Enter User Mobile");
		String mobile = keyInput.nextLine();
		User user = new User(id, name, password, email, mobile);
		//adding user details in a database
		userDb.addUser(user);
		System.out.println("User Created Successfully");

	}

	public void viewUser() {
		System.out.println("Enter the Id of user you want to see");
		int id = keyInput.nextInt();
		keyInput.nextLine();
		//fetching user details of particular id from database
		userDb.viewUser(id);

	}

	public void viewAllUsers() {
		//fetching all users from database
		userDb.viewAllUsers();

	}

	//function to delete user
	public void deleteUser() {
		System.out.println("Enter the Id of user you want to delete");
		int id = keyInput.nextInt();
		keyInput.nextLine();
		//deleting particular user from database
		userDb.deleteUser(id);

	}

	public void updateUser() {

	}

	public void oldUserController() {
		System.out.println("Enter User Name");
		String name = keyInput.nextLine();
		System.out.println("Enter User Password");
		String password = keyInput.nextLine();
		Boolean credentials = checkUser.checkCreds(name, password);
		if (credentials == true) {
			System.out.println("1.Product Module");
			System.out.println("2.Order Module");
			System.out.println("3.Exit");
			System.out.println("Enter your choice");
			int choice = keyInput.nextInt();
			keyInput.nextLine();
			while (choice > 0 && choice < 3) {
				switch (choice) {
				case 1:
					oldUserController.ProductModule();
					break;
				case 2:
					oldUserController.OrderModule();
					break;
				}
				System.out.println("1.Product Module");
				System.out.println("2.Order Module");
				System.out.println("3.Exit");
				System.out.println("Enter your choice");
				choice = keyInput.nextInt();
				keyInput.nextLine();
			}
			System.out.println("Exiting the Module");
		}

	}

}
