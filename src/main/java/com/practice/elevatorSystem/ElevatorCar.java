package com.practice.elevatorSystem;

public class ElevatorCar {
	
	int eid;
	Display display;
	int currentFloor;
	Direction direction;
	Status status;
	InternalButton internalButton;
	
	public ElevatorCar(int eid) {
		this.eid = eid;
		this.direction = Direction.UP;
		this.status = Status.IDLE;
		this.currentFloor = 0;
		this.display = new Display();
		this.internalButton = new InternalButton(eid);
	}
	
	public void setInternalButtonDispatcher(InternalButtonDispatcher internalDispatcher) {
		this.internalButton.setInternalButtonDispatcher(internalDispatcher);
	}
	
	public void move(int floor, Direction dir) {
		this.internalButton.pressButton(floor, dir);
	}
	
	public void display() {
		this.display.display(currentFloor, direction);
	}
}
