package com.practice.carRentalSystem;

import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Store {
	
	int storeid;
	String storeName;
	Location location;
	HashSet<VehicleType> availableVehicleTypes;
	HashMap<VehicleType, VehicleInventory> vehicleInventories;
	HashMap<Integer, Reservation> reservationMap;
	HashMap<Integer, Bill> billMap;
	
	public Store(int storeId, String storeName, Location loc, HashSet<VehicleType> vts) {
		this.storeid = storeId;
		this.storeName = storeName;
		this.location = loc;
		this.availableVehicleTypes = vts;
		addVehicleInventoreis();
		this.reservationMap = new HashMap<>();
		this.billMap = new HashMap<>();
	}

	private void addVehicleInventoreis() {
		this.vehicleInventories = new HashMap<>();
		for (VehicleType vt : this.availableVehicleTypes) {
			this.vehicleInventories.put(vt, VehicleInventoryFactory.getVehicleInventory(vt));
		}
	}
	
	public void AddVehicles(ArrayList<Vehicle> vehicles) {
		
		for (Vehicle vc : vehicles) {
			if (this.vehicleInventories.containsKey(vc.vehicleType)) {
				this.vehicleInventories.get(vc.vehicleType).addVehicle(vc);
			}
		}
	}
	
	public List<Vehicle> getAvailableVehicles(VehicleType vt){
		List<Vehicle> vehicles = new ArrayList<>();
		
		if (this.vehicleInventories.containsKey(vt)) {
			VehicleInventory vi = this.vehicleInventories.get(vt);
			return vi.getAvailableVehicles();
		}
		return vehicles;
	}
	
	public Reservation reserveVehicle(int rid, List<Vehicle> vc,  User user) {
		
		for (Vehicle vehicle : vc) {
			this.vehicleInventories.get(vehicle.getVehicleType()).reserveVehicle(vehicle.vehicleId);
		}
		
		Reservation reservation = new Reservation(rid, this.storeid, user.userid);
		reservation.addVehciles(vc);
		this.reservationMap.put(rid, reservation);
		return reservation;
	}
	
	public Bill payBill(int id, Reservation reservation) {
		reservation.completeReservation();
		Bill bill = new Bill(id, reservation, this.storeid, reservation.userId);
		this.billMap.put(id, bill);
		return bill;
	}
	
}
