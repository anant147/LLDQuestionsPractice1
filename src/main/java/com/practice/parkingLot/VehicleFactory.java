package com.practice.parkingLot;

public class VehicleFactory {
	
	public static Vehicle getVehicle(int id, String name, VehicleType vt) {
		
		if (vt.equals(VehicleType.TWO_WHEELER)) {
			return new TwoWheelerVehicle(id, name);
		}
		else if (vt.equals(VehicleType.FOUR_WHEELER)) {
			return new FourWheelerVehicle(id, name);
		}
		return null;
	}
}
