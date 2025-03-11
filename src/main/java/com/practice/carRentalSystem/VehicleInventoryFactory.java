package com.practice.carRentalSystem;

public class VehicleInventoryFactory {
	
	public static VehicleInventory getVehicleInventory(VehicleType vt) {
		
		if (VehicleType.BIKE.equals(vt)) {
			return new BikeInventory();
		}
		else if (VehicleType.CAR.equals(vt)) {
			return new CarInventory();
		}
		return null;
	}
}
