package com.practice.parkingLot;

import java.util.List;

public abstract class ParkingStrategy {
	
	abstract ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpots);
}
