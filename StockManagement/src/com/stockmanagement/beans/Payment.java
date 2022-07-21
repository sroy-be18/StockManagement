package com.stockmanagement.beans;

public class Payment {
	int id;
	float totalAmount;
	public Payment(int id, float totalAmount) {
		super();
		this.id = id;
		this.totalAmount = totalAmount;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", totalAmount=" + totalAmount + "]";
	}
	
	

}
