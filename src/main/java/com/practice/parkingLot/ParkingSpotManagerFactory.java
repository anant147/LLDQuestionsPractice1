package com.practice.parkingLot;

public class ParkingSpotManagerFactory {
	
	public static ParkingSpotManager getParkingSpotManager( VehicleType vt) {
		
		if (vt.equals(VehicleType.TWO_WHEELER)) {
			return new TwoWheelerParkingSpotMananger();
		}
		else if (vt.equals(VehicleType.FOUR_WHEELER)) {
			return new FourWheelerParkingSpotManager();
		}
		return null;
	}
}
