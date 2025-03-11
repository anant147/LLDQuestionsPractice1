package com.practice.carRentalSystem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class CarRentalSystemMain {

	public static void main(String[] args) {

		Location loc = new Location(1, "Delhi");
		
		HashSet<VehicleType> vts = new HashSet<>();
		vts.add(VehicleType.BIKE);
		vts.add(VehicleType.CAR);
		
		Store store = new Store(1, "Store1", loc, vts);
		
		Vehicle c1 = new Car(11, "car1", 100);
		Vehicle c2 = new Car(12, "car2", 150);
		Vehicle c3 = new Car(13, "car3", 200);
		
		Vehicle b1 = new Bike(21, "bike1", 50);
		Vehicle b2 = new Bike(22, "bike2", 60);
		Vehicle b3 = new Bike(23, "bike3", 70);
		
		ArrayList<Vehicle> vehicles = new ArrayList<>( Arrays.asList(c1, c2, c3, b1, b2, b3) );
		store.AddVehicles(vehicles);
		
		store.getAvailableVehicles(VehicleType.BIKE);
		store.getAvailableVehicles(VehicleType.CAR);
		
		User user = new User(1, "user1");
		
		List<Vehicle> vehiclesToReserve = new ArrayList<>(Arrays.asList(c1, b1));
		
		Reservation reservation = store.reserveVehicle(100, vehiclesToReserve, user);
		System.out.println(" reservation id : " + reservation.reservationId + " , status : " + reservation.getStatus());
		System.out.println(" reservation id : " + reservation.reservationId + " , cost of resevation : " + reservation.calculateCost());
		
		Bill bill = store.payBill(200, reservation);
		System.out.println(" bill : " + bill.billId + " , amount : " + bill.getAmount() + " , reservation status : " + bill.reservation.status );
		
		

	}

}
