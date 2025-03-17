package com.practice.parkingLot;

import java.util.Set;
import java.util.HashSet;

public class ParkingLotMain {

	public static void main(String[] args) {
		
		Set<VehicleType> vehicleTypes = new HashSet<>();
		vehicleTypes.add(VehicleType.TWO_WHEELER);
		vehicleTypes.add(VehicleType.FOUR_WHEELER);
		
		ParkingLot parkingLot = new ParkingLot(vehicleTypes, 3, 3);
		
		parkingLot.addParkingSpot(VehicleType.TWO_WHEELER, 10);
		parkingLot.addParkingSpot(VehicleType.FOUR_WHEELER, 10);
		
		Vehicle bike = VehicleFactory.getVehicle(1, "bike1", VehicleType.TWO_WHEELER);
		ParkingSpot bikeSpot = parkingLot.findParkingSpot(1, bike, new DefaultParkingStrategy());
		Ticket bikeTicket = parkingLot.parkVehicle(1, 1, bikeSpot.id, bike, 0);
		
		System.out.println(" \n \n ticket after parking : " + bikeTicket);
		bikeTicket = parkingLot.removeVehicleFromParkingSpot(1, 10, bikeTicket, new DefaultTicketPriceStrategy());
		System.out.println(" \n \n ticket after removing from parking : " + bikeTicket);

		
		
		Vehicle car = VehicleFactory.getVehicle(2, "car1", VehicleType.FOUR_WHEELER);
		ParkingSpot carSpot = parkingLot.findParkingSpot(2, car, new DefaultParkingStrategy());
		Ticket carTicket = parkingLot.parkVehicle(2, 2, carSpot.id, car, 1);
		
		System.out.println(" \n \n ticket after parking : " + carTicket);
		carTicket = parkingLot.removeVehicleFromParkingSpot(2, 20, carTicket, new DefaultTicketPriceStrategy());
		System.out.println(" \n \n ticket after removing from parking : " + carTicket);
		
	}

}
