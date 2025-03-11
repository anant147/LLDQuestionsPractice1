package com.practice.carRentalSystem;

public abstract class Vehicle {
	
	int vehicleId;
	String vehicleName;
	int price;
	VehicleType vehicleType;
	Status status;
	
	public Vehicle(int id, String name, int price, VehicleType vt) {
		this.vehicleId = id;
		this.vehicleName = name;
		this.vehicleType = vt;
		this.price = price;
		this.status = Status.AVAILABLE;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}
	
	public void reverseVehicle() {
		this.status = Status.RESERVED;
	}
	
	public void makeVehicleAvailable() {
		this.status = Status.AVAILABLE;
	}
	
}
