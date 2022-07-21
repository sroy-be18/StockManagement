package com.stockmanagement.controller;

import java.util.Scanner;

import com.stockmanagement.database.PaymentDB;

public class PaymentController {
	Scanner keyInput=new Scanner (System.in);
	PaymentDB paymentDb=new PaymentDB();
	public void insertPayment(int pId, float totalAmount) {
		//inserting payment details into database
		paymentDb.insertPayment(pId,totalAmount);
	}
	public void viewAllPayments() {
		//fetching payment details from database
		paymentDb.viewAllPayments();
	}
	
	public void viewPayment() {
		System.out.println("Enter the Id of payment you want to see");
		int id=keyInput.nextInt();
		keyInput.nextLine();
		//fetching payment details of particular id from database
		paymentDb.viewPayment(id);
	}

}
