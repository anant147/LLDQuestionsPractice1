package com.practice.carRentalSystem;

import java.util.List;
import java.util.ArrayList;

public class Reservation {
	
	int reservationId;
	int storeId;
	int userId;
	ReservationStatus status;
	int amount;
	List<Vehicle> vehicles;
	
	public Reservation(int reservationId, int storeid, int userid) {
		this.reservationId = reservationId;
		this.storeId = storeid;
		this.userId = userid;
		this.status = ReservationStatus.BOOKED;
		this.vehicles = new ArrayList<>();
	}
	
	public void addVehciles(List<Vehicle> vs) {
		this.vehicles.addAll(vs);
		System.out.println(" no. of vehicles added : " + vs.size());
		calculateCost();
	}
	
	public void addVehicle(Vehicle v) {
		this.vehicles.add(v);
	}
	
	public int calculateCost() {
		int cost = 0;
		
		for (Vehicle v : this.vehicles) {
			cost += v.price;
		}
		this.amount = cost;
		System.out.println(" cost : " + cost);
		return cost;
	}
	
	public void completeReservation() {
		this.status = ReservationStatus.COMPLETED;
	}
	
	public void cancelReservation() {
		this.status = ReservationStatus.CANCELLED;
	}
	
	public int getReservationId() {
		return reservationId;
	}



	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getStoreId() {
		return storeId;
	}



	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public ReservationStatus getStatus() {
		return status;
	}



	public void setStatus(ReservationStatus status) {
		this.status = status;
	}



	public static enum ReservationStatus{
		BOOKED,
		CANCELLED,
		COMPLETED
	}
}
