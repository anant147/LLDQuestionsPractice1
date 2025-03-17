package com.practice.parkingLot;

import java.util.Map;

public class EntranceGate {
	
	int id;
	String name;
	Map<VehicleType, ParkingSpotManager> parkingSpotManagerMap;
	
	public EntranceGate(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void setParkingSpotManagerMap(Map<VehicleType, ParkingSpotManager> managerMap) {
		this.parkingSpotManagerMap = managerMap;
	}
	
	public ParkingSpot findParkingSpot(VehicleType vehicleType, ParkingStrategy parkingStrategy) {
		if (this.parkingSpotManagerMap.containsKey(vehicleType)) {
			ParkingSpotManager psm = this.parkingSpotManagerMap.get(vehicleType);
			psm.setParkingStrategy(parkingStrategy);
			return psm.findParkingSpot();
		}
		return null;
	}
	
	public Ticket parkVehicle(int ticketId, int parkingId, Vehicle vehicle) {
		if (this.parkingSpotManagerMap.containsKey(vehicle.getVehicleType())) {
			ParkingSpotManager psm = this.parkingSpotManagerMap.get(vehicle.vehicleType);
			Ticket ticket =  psm.parkVehicle(ticketId, parkingId, vehicle);
			ticket.entranceGateId = this.id;
			return ticket;
		}
		return null;
	}
	
	
}
