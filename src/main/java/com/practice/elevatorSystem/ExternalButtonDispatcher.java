package com.practice.elevatorSystem;

import java.util.List;
import java.util.ArrayList;

public class ExternalButtonDispatcher {
	
	List<ElevatorCarController> elevList;
	
	public ExternalButtonDispatcher() {
		this.elevList = new ArrayList<>();
	}
	
	public void addElevatorCarController(ElevatorCarController elev) {
		this.elevList.add(elev);
	}
	
	public ElevatorCarController getElevator(int floor, Direction dir) {
		if (this.elevList != null && this.elevList.size()>0) {
			
			ElevatorCarController sel = null;
			
			for (ElevatorCarController elev : this.elevList) {
				int currentFloor = elev.elevator.currentFloor;
				Direction curDir = elev.elevator.direction;
				
				if (floor == currentFloor 
						|| ( currentFloor < floor && dir == curDir && dir == Direction.UP )
						|| ( currentFloor > floor && dir == curDir && dir == Direction.DOWN)
						) {
					sel = elev;
					break;
				}
			}
			
			return sel != null ? sel : this.elevList.get(0);
		}
		else {
			System.out.println(" elevator controllers are not configured to external button dispatcher");
			return null;
		}
	}
}
