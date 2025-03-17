package com.practice.parkingLot;

public abstract class ParkingSpot {
	int id;
	String name;
	boolean isEmpty;
	Vehicle vehicle;
	VehicleType vehicleType;
	
	public ParkingSpot(int id, String name, VehicleType vt) {
		this.id = id;
		this.name = name;
		this.vehicleType = vt;
		this.isEmpty = true;
	}
	
	public void parkVehicle(Vehicle vehicle) {
		if (this.vehicleType.equals(vehicle.vehicleType)) {
			this.isEmpty = false;
			this.vehicle = vehicle;
		}
		else {
			System.out.println(" cannot park vehicle : " + vehicle.vehicleType + " in spot of " + this.vehicleType);
		}
	}
	
	public Vehicle removeVehicle() {
		Vehicle vh = this.vehicle;
		this.vehicle = null;
		this.isEmpty = true;
		return vh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
}
