package com.practice.carRentalSystem;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public abstract class VehicleInventory {
	
	VehicleType vehicleType;
	int vehicleCount;
	int availableVehicles;
	int reserveVehicles;
	HashMap<Integer, Vehicle> vehicles;
	HashMap<Integer, Vehicle> reservedVehicles;
	
	public VehicleInventory(VehicleType vt) {
		this.vehicleType = vt;
		this.vehicles = new HashMap<>();
		this.reservedVehicles = new HashMap<>();
	}
	
	public void addVehicles(List<Vehicle> vehicles) {
		
		for (Vehicle v : vehicles) {
			this.vehicles.put(v.vehicleId, v);
		}
		
		this.vehicleCount = this.vehicles.size();
	}
	
	public void addVehicle(Vehicle vehicle) {
		this.vehicles.put(vehicle.vehicleId, vehicle);
		System.out.println(" vehicle : " + vehicle.vehicleId + " added");
		this.vehicleCount = this.vehicles.size();
	}
	
	public List<Vehicle> getAvailableVehicles(){
		
		if (this.availableVehicles == 0) {
			return new ArrayList<>();
		}
		
		List<Vehicle> availables = new ArrayList<>();
		
		
		for (Integer id : this.vehicles.keySet()) {
			Vehicle v = this.vehicles.get(id);
			
			if (v != null && Status.AVAILABLE.equals(v.status)) {
				availables.add(v);
			}
		}
		
		this.availableVehicles = availables.size();
		
		return availables;

	}
	
	public boolean reserveVehicle(int id) {
		
		if (this.vehicles.containsKey(id)) {
			Vehicle v = this.vehicles.get(id);
			if (!Status.RESERVED.equals(v.status)) {
				v.reverseVehicle();
				this.reservedVehicles.put(v.vehicleId, v);
				this.reserveVehicles++;
				this.availableVehicles--;
				System.out.println(" vehicle : " + id + " , type : " + this.vehicleType + " is reserved");
			}
			else {
				System.out.println(" vehicle : "+ id + " already reserved ");
			}
		}
		else {
			System.out.println(" vehicle : " + id + " not found");
		}
		return false;
	}
	
	public boolean makeVehicleAvailable(int id) {
		if (this.reservedVehicles.containsKey(id)) {
			Vehicle v = this.reservedVehicles.get(id);
			v.makeVehicleAvailable();
			this.reservedVehicles.remove(id);
			this.reserveVehicles--;
			this.availableVehicles++;
		}
		else {
			System.out.println(" vehicle : " + id + " is not in reserverd");
		}
		return false;
	}
	
}
