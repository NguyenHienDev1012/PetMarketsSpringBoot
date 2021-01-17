package com.petmarkets2020.model;

public class TransactionHistory {
	private double amount;
	private String payments;
	private String status;
	private String time;
	public TransactionHistory(double amount, String payments, String status, String time) {
		super();
		this.amount = amount;
		this.payments = payments;
		this.status = status;
		this.time = time;
	}
	public TransactionHistory() {
		super();
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPayments() {
		return payments;
	}
	public void setPayments(String payments) {
		this.payments = payments;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "TransactionHistory [amount=" + amount + ", payments=" + payments + ", status=" + status + ", time="
				+ time + "]";
	}
	
}
