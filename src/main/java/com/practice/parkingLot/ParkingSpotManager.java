package com.practice.parkingLot;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public abstract class ParkingSpotManager {
	
	VehicleType vehicleType;
	List<ParkingSpot> parkingSpots;
	Map<Integer, ParkingSpot> parkingSpotMap;
	ParkingStrategy parkingStrategy;
	
	public ParkingSpotManager(VehicleType vt) {
		this.vehicleType = vt;
		this.parkingSpots = new ArrayList<>();
		this.parkingSpotMap = new HashMap<>();
		this.parkingStrategy = new DefaultParkingStrategy();
	}
	
	public void setParkingStrategy(ParkingStrategy parkingStrategy) {
		this.parkingStrategy = parkingStrategy;
	}
	
	public ParkingSpot findParkingSpot() {
		return this.parkingStrategy.findParkingSpot(this.parkingSpots);
	}
	
	public void addParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpots.add(parkingSpot);
		this.parkingSpotMap.put(parkingSpot.id, parkingSpot);
	}
	
	public Ticket parkVehicle(int ticketId, int parkingId, Vehicle vehicle) {
		Ticket ticket = new Ticket(ticketId, this.vehicleType, parkingId, vehicle.id);
		ParkingSpot ps = this.parkingSpotMap.get(parkingId);
		ps.parkVehicle(vehicle);
		return ticket;
	}
	
	public Vehicle removeVehicle(Ticket ticket) {
		ParkingSpot ps = this.parkingSpotMap.get(ticket.parkingSpotId);
		return ps.removeVehicle();
	}
}
