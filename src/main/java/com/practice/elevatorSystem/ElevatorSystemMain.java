package com.practice.elevatorSystem;


public class ElevatorSystemMain {

	public static void main(String[] args) {
		
		Building building = new Building(1);
		
		for (int i=0;i<=10;i++) {
			building.addFloor(new Floor(i));
		}
		
		for (int i=1;i<=3;i++) {
			building.addElevatorCarController(new ElevatorCarController(i));
		}
		
		building.moveToDest(1, 3, Direction.UP);
		building.moveToDest(2, 4, Direction.UP);
		
		building.processElevatorRequests();
		
		building.moveToDest(1, 5, Direction.UP);
		building.moveToDest(2, 3, Direction.UP);
		building.moveToDest(3, 1, Direction.DOWN);
		building.moveToDest(3, 2, Direction.DOWN);
		
		building.processElevatorRequests();
	}

}
