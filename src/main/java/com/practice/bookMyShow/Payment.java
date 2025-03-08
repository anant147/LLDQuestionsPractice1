package com.practice.bookMyShow;

public class Payment {
	
	int paymentId;
	PaymentStatus paymentStatus;
	
	public Payment(int id) {
		this.paymentId = id;
		this.paymentStatus = PaymentStatus.INITIATED;
	}
	
	public void donePayment() {
		this.paymentStatus = PaymentStatus.DONE;
		System.out.println(" booking for payment done");
	}
	
	
	public static enum PaymentStatus{
		INITIATED,
		DONE;
	}
}
