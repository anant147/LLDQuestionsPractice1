package com.practice.carRentalSystem;

import java.util.List;
import java.util.ArrayList;

public class User {
	
	int userid;
	String username;
	List<Reservation> reservations;
	
	public User(int userid, String username) {
		this.userid = userid;
		this.username = username;
		this.reservations = new ArrayList<>();
	}
	
	public void addReservation(Reservation reservation) {
		this.reservations.add(reservation);
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
