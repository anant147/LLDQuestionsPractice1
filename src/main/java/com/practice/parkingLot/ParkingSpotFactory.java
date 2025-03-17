package com.practice.parkingLot;

public class ParkingSpotFactory {
	
	public static ParkingSpot getParkingSpot(int id, String name, VehicleType vt) {
		
		if (vt.equals(VehicleType.TWO_WHEELER)) {
			return new TwoWheelerParkingSpot(id, name);
		}
		else if (vt.equals(VehicleType.FOUR_WHEELER)) {
			return new FourWheelerParkingSpot(id, name);
		}
		return null;
	}
}
