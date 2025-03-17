package com.practice.parkingLot;

public abstract class Vehicle {
	int id;
	String name;
	VehicleType vehicleType;
	
	public Vehicle(int id, String name, VehicleType vt) {
		this.id = id;
		this.name = name;
		this.vehicleType = vt;
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

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
}
