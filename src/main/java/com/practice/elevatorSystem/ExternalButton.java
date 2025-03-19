package com.practice.elevatorSystem;

public class ExternalButton {
	
	ExternalButtonDispatcher externalButtonDispatcher;
	
	public void setExternalButtonDispatcher(ExternalButtonDispatcher externalDispatcher) {
		this.externalButtonDispatcher = externalDispatcher;
	}
	
	public ElevatorCarController pressButton(int floor, Direction dir) {
		if (this.externalButtonDispatcher != null) {
			return this.externalButtonDispatcher.getElevator(floor, dir);
		}
		else {
			System.out.println(" cannot process requests as dispatcher is not attached..");
			return null;
		}
	}
}
