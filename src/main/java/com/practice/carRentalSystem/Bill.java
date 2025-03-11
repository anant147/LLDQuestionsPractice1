package com.practice.carRentalSystem;

public class Bill {
	
	int billId;
	Reservation reservation;
	int storeid;
	int userid;
	int amount;
	Payment payment;
	
	public Bill(int id, Reservation reservation, int storeid, int userid) {
		this.billId = id;
		this.reservation = reservation;
		this.storeid = storeid;
		this.userid = userid;
		this.amount = reservation.calculateCost();
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public int getStoreid() {
		return storeid;
	}

	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}
