package com.practice.elevatorSystem;

public class Floor {
	
	int floorId;
	int buildingId;
	ExternalButton externalButton;
	
	public Floor(int id) {
		this.floorId = id;
		this.externalButton = new ExternalButton();
	}
	
	public void setExternalButtonDispatcher(ExternalButtonDispatcher externalButtonDispatcher) {
		this.externalButton.setExternalButtonDispatcher(externalButtonDispatcher);
	}
	
	public ElevatorCarController pressButton(Direction dir) {
		return this.externalButton.pressButton(this.floorId, dir);
	}
}
