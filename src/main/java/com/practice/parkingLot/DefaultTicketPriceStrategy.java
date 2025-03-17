package com.practice.parkingLot;

import java.util.Map;
import java.util.HashMap;

public class DefaultTicketPriceStrategy extends PriceStrategy {
	
	Map<VehicleType, Integer> map;
	
	public DefaultTicketPriceStrategy() {
		this.map = new HashMap<>();
		this.map.put(VehicleType.TWO_WHEELER, 10);
		this.map.put(VehicleType.FOUR_WHEELER, 20);
		
	}
	
	@Override
	public int getTicketCost(Ticket ticket) {
		int costForVehicle = this.map.getOrDefault(ticket.vehcleType, 5);
		System.out.println(" ticket : " + ticket.ticketId + " , starttime : " + ticket.startTime + " , ticket exit time : " + ticket.exitTime);;
		return (ticket.exitTime - ticket.startTime) * costForVehicle;
	}

}
