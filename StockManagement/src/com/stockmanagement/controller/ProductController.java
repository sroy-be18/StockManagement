package com.stockmanagement.controller;

import java.util.Scanner;

import com.stockmanagement.beans.Product;
import com.stockmanagement.database.ProductDB;

public class ProductController {

	Scanner keyInput = new Scanner(System.in);
	ProductDB productDb = new ProductDB();

	//function to add products details 
	public void addProduct() {
		System.out.println("Enter Product Id");
		int id = keyInput.nextInt();
		keyInput.nextLine();
		System.out.println("Enter Product Name");
		String name = keyInput.nextLine();
		System.out.println("Enter Product Quantity");
		int quantity = keyInput.nextInt();
		System.out.println("Enter Product Price");
		float price = keyInput.nextFloat();
		keyInput.nextLine();
		Product product = new Product(id, name, quantity, price);
		//adding product details into database
		productDb.addProduct(product);

	}

	public void viewAllProducts() {
		//fetching product details from database
		productDb.viewAllProducts();
	}

	public void viewProduct() {
		System.out.println("Enter the Id of Product you want to see");
		int id = keyInput.nextInt();
		keyInput.nextLine();
		//fetching product details of particular id from database
		productDb.viewProduct(id);
	}
	
	public Product fetchProduct(int id) {
		Product product=productDb.fetchProduct(id);
		return product;
	}

	public void deleteProduct() {
		System.out.println("Enter the Id of Product you want to delete");
		int id = keyInput.nextInt();
		keyInput.nextLine();
		//deleting product from the database
		productDb.deleteProduct(id);

	}

	public void updateProduct() {

	}
	public void updateProductQuantity(int id, int newQuanity) {
		//updating the quantity of products in a database
		productDb.updateProductQuantity(id, newQuanity);

	}
}
