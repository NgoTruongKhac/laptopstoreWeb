package model;

import java.sql.Date;

public class Order {
	
	private int orderId;
	private int userId;
	private String payment;
	private int totalPrice;
	private Date orderDate;
	private String state;
	public Order(int orderId, int userId, String payment, int totalPrice, Date orderDate, String state) {
		this.orderId = orderId;
		this.userId = userId;
		this.payment = payment;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.state = state;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String paymnet) {
		this.payment = paymnet;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String status) {
		this.state = status;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", paymnet=" + payment + ", totalPrice="
				+ totalPrice + ", orderDate=" + orderDate + ", status=" + state + "]";
	}
	
	
	
	

}
