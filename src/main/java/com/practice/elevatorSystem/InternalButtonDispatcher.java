package com.practice.elevatorSystem;

import java.util.Map;
import java.util.HashMap;

public class InternalButtonDispatcher {
	
	Map<Integer, ElevatorCarController> elevatorMap;
	
	public InternalButtonDispatcher() {
		this.elevatorMap = new HashMap<>();
	}
	
	public void addElevatorCarController(ElevatorCarController elev) {
		this.elevatorMap.put(elev.ecid, elev);
	}
	
	public void pressButton(int ecid, int destFloorId, Direction dir) {
		if (this.elevatorMap.containsKey(ecid)) {
			ElevatorCarController ecc = this.elevatorMap.get(ecid);
			ecc.submitRequest(destFloorId, dir);
		}
		else {
			System.out.println(" there is no elevator : " + ecid);
		}
	}
}
