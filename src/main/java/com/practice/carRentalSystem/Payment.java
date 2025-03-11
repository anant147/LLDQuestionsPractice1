package com.practice.carRentalSystem;

public class Payment {
	
	int paymentId;
	PaymentStatus paymentStatus;
	
	public Payment(int id) {
		this.paymentId = id;
		this.paymentStatus = PaymentStatus.DONE;
	}
	
	public static enum PaymentStatus{
		DONE
	}
}
