package com.practice.parkingLot;

import java.util.Map;

public class ExitGate {

	int id;
	String name;
	Map<VehicleType, ParkingSpotManager> parkingSpotManagerMap;
	
	public ExitGate(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void setParkingSpotManagerMap(Map<VehicleType, ParkingSpotManager> managerMap) {
		this.parkingSpotManagerMap = managerMap;
	}
	
	public Ticket removeVehicleFromParkingSpot(int exitTime, PriceStrategy strategy, Ticket ticket) {
		if (this.parkingSpotManagerMap.containsKey(ticket.vehcleType)) {
			ParkingSpotManager psm = this.parkingSpotManagerMap.get(ticket.vehcleType);
			psm.removeVehicle(ticket);
			ticket.calculateTicketCost(exitTime, strategy);
			System.out.println(" exit time : " + ticket.exitTime);

			return ticket;
		}
		return null;
	}
}
