package com.practice.parkingLot;

import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ParkingLot {
	
	Set<VehicleType> vehicleTypes;
	Map<VehicleType, ParkingSpotManager> parkingSpotManagers;
	Map<Integer, EntranceGate> entranceGates;
	Map<Integer, ExitGate> exitGates;
	Map<Integer, Ticket> validTickets;
	Map<Integer, Ticket> closedTickets;
	
	public ParkingLot(Set<VehicleType> vehicleTypes, int entranceGates, int exitGates) {
		this.vehicleTypes = vehicleTypes;
		this.parkingSpotManagers = new HashMap<>();
		fillParkingSpotManagers();
		this.entranceGates = new HashMap<>();
		this.exitGates = new HashMap<>();
		this.validTickets = new HashMap<>();
		this.closedTickets = new HashMap<>();
		makeEntryAndExitGates(entranceGates, exitGates);
	}

	private void makeEntryAndExitGates(int entranceGates, int exitGates) {
		for (int i=1;i<=entranceGates;i++) {
			EntranceGate entGate = new EntranceGate(i, "ent"+i);
			entGate.setParkingSpotManagerMap(parkingSpotManagers);
			this.entranceGates.put(i, entGate);
		}
		
		for (int i=1;i<=exitGates;i++) {
			ExitGate exitGate = new ExitGate(i, "exit"+i);
			exitGate.setParkingSpotManagerMap(parkingSpotManagers);
			this.exitGates.put(i, exitGate);
		}
	}

	private void fillParkingSpotManagers() {
		for (VehicleType vt : this.vehicleTypes) {
			this.parkingSpotManagers.put(vt, ParkingSpotManagerFactory.getParkingSpotManager(vt));
		}
	}
	
	public void addParkingSpot(VehicleType vehicleType, int count) {
		ParkingSpotManager manager = parkingSpotManagers.get(vehicleType);
		if (manager != null) {
			for (int i=1;i<=count;i++) {
				String name = vehicleType.toString()+"i";
				manager.addParkingSpot(ParkingSpotFactory.getParkingSpot(i, name, vehicleType));
			}
		}
		else {
			System.out.println(" parking spot for vehicle type : " + vehicleType + " not available");
		}
	}
	
	public List<Integer> getEntranceGatesId(){
		return new ArrayList<>(this.entranceGates.keySet());
	}
	
	public List<Integer> getExitGatesId(){
		return new ArrayList(this.exitGates.keySet());
	}
	
	public ParkingSpot findParkingSpot(int entranceId, Vehicle vehicle, ParkingStrategy parkingStrategy) {
		if (this.entranceGates.containsKey(entranceId)) {
			EntranceGate entGate = this.entranceGates.get(entranceId);
			return entGate.findParkingSpot( vehicle.vehicleType, parkingStrategy);
		}
		return null;
	}
	
	
	public Ticket parkVehicle(int entranceId, int ticketId, int parkingId, Vehicle vehicle, int startTime) {
		if (this.entranceGates.containsKey(entranceId)) {
			EntranceGate entGate = this.entranceGates.get(entranceId);
			Ticket ticket = entGate.parkVehicle(ticketId, parkingId, vehicle);
			ticket.startTime = startTime;
			this.validTickets.put(ticketId, ticket);
			return ticket;
		}
		return null;
	}
	
	public Ticket removeVehicleFromParkingSpot(int exitGateId, int exitTime, Ticket ticket, PriceStrategy strategy) {
		if (this.exitGates.containsKey(exitGateId)) {
			ExitGate exitGate = this.exitGates.get(exitGateId);
			ticket.exitGateId = exitGateId;
			ticket = exitGate.removeVehicleFromParkingSpot(exitTime, strategy, ticket);
			this.validTickets.remove(ticket.ticketId);
			this.closedTickets.put(ticket.ticketId, ticket);
			return ticket;
		}
		return null;
	}
}
