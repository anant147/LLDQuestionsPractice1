package com.practice.parkingLot;

public class Ticket {
	
	int ticketId;
	int parkingSpotId;
	VehicleType vehcleType;
	int vehicleId;
	int entranceGateId;
	int exitGateId;
	int startTime;
	int exitTime;
	TicketStatus ticketStatus;
	int cost;
	PriceStrategy pricingStrategy;
	
	
	public Ticket(int ticketId, VehicleType vt, int parkingSpot, int vehicleId) {
		this.ticketId = ticketId;
		this.vehcleType = vt;
		this.parkingSpotId = parkingSpot;
		this.vehicleId = vehicleId;
		this.ticketStatus = TicketStatus.VALID;
	}
	
	public static enum TicketStatus{
		VALID,
		CLOSED
	}
	
	public int calculateTicketCost(int exitTime, PriceStrategy strategy) {
		this.exitTime = exitTime;
		this.pricingStrategy = strategy;
		this.cost = strategy.getTicketCost(this);
		System.out.println(" price of ticket is " + this.cost + " for " + this.vehcleType + " from time : ( " + this.startTime + " - " + this.exitTime + " ) ");
		return this.cost;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", parkingSpotId=" + parkingSpotId + ", vehcleType=" + vehcleType
				+ ", vehicleId=" + vehicleId + ", entranceGateId=" + entranceGateId + ", exitGateId=" + exitGateId
				+ ", startTime=" + startTime + ", exitTime=" + exitTime + ", ticketStatus=" + ticketStatus + ", cost="
				+ cost + "]";
	}
}
