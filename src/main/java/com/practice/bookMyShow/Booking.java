package com.practice.bookMyShow;

public class Booking {
	int bookingId;
	int showId;
	int seatId;
	Payment payment;
	User user;
	
	public Booking(int bookingId, int showId, int seatId, User user) {
		this.bookingId = bookingId;
		this.showId = showId;
		this.seatId = seatId;
		this.user = user;
		this.payment = new Payment(bookingId);
	}


}
