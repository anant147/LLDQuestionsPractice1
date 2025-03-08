package com.practice.bookMyShow;

import java.util.HashMap;
import java.util.ArrayList;

public class Show {
	int showId;
	Screen screen;
	int theatreId;
	Movie movie;
	int startTime;
	HashMap<SeatCategory, ArrayList<Seat>> bookedSeats;
	HashMap<Integer, Seat> bookedSeatMap;
	HashMap<Integer, Booking> bookings;
	
	public Show(int showId, Screen screen, int theatreId, Movie movie, int startTime) {
		this.showId = showId;
		this.screen = screen;
		this.theatreId = theatreId;
		this.movie = movie;
		this.startTime = startTime;
		this.bookedSeats = new HashMap<>();
		this.bookings = new HashMap<>();
		this.bookedSeatMap = new HashMap<>();
	}
	
	public Booking bookSeat(int seatId, int bookId, User user) {
		Seat seat = screen.getSeat(seatId);
		this.bookedSeatMap.put(seat.seatId, seat);
		Booking booking = new Booking(bookId, this.showId, seat.seatId, user);
		this.bookings.put(bookId, booking);
		return booking;
	}
	
}
