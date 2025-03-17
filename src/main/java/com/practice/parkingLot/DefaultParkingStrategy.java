package com.practice.parkingLot;

import java.util.List;

public class DefaultParkingStrategy extends ParkingStrategy{

	@Override
	ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpots) {
		
		for (ParkingSpot ps : parkingSpots) {
			if (ps.isEmpty) {
				return ps;
			}
		}
		
		return null;
	}

}
