package com.stockmanagement.beans;

public class Order {
	int id;
	int pId;
	int quantity;
	float totalAmount;
	Product product;
	public Order(int id, int pId, int quantity, float totalAmount, Product product) {
		super();
		this.id = id;
		this.pId=pId;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.product = product;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", pId=" + pId + ", quantity=" + quantity + ", totalAmount=" + totalAmount
				+ ", product=" + product + "]";
	}
	
	

}
