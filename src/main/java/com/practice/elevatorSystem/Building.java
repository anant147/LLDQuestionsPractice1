package com.practice.elevatorSystem;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Building {
	
	int id;
	List<Floor> floors;
	Map<Integer, Floor> floorMap;
	List<ElevatorCarController> eccList;
	InternalButtonDispatcher internalButtonDispatcher;
	ExternalButtonDispatcher externalButtonDispatcher;
	
	public Building(int id) {
		this.id = id;
		this.floorMap = new HashMap<>();
		this.floors = new ArrayList<>();
		this.eccList = new ArrayList<>();
		this.internalButtonDispatcher = new InternalButtonDispatcher();
		this.externalButtonDispatcher = new ExternalButtonDispatcher();
	}
	
	public void addFloor(Floor f) {
		this.floorMap.put(f.floorId, f);
		this.floors.add(f);
		f.setExternalButtonDispatcher(this.externalButtonDispatcher);
		f.buildingId = this.id;
	}
	
	public void addElevatorCarController(ElevatorCarController ecc) {
		this.eccList.add(ecc);
		ecc.setInternalButtonDispatcher(this.internalButtonDispatcher);
		this.internalButtonDispatcher.addElevatorCarController(ecc);
		this.externalButtonDispatcher.addElevatorCarController(ecc);
	}
	
	public void setExternalButtonDispatcher(int floorId, ExternalButtonDispatcher dispatcher) {
		if (this.floorMap.containsKey(floorId)) {
			Floor floor = this.floorMap.get(floorId);
			floor.setExternalButtonDispatcher(dispatcher);
		}
		else {
			System.out.println(" floor : " + floorId + " is not in building");
		}
	}
	
	public void moveToDest(int floorId, int destFloorId, Direction dir) {
		if (this.floorMap.containsKey(floorId)) {
			Floor floor = this.floorMap.get(floorId);
			ElevatorCarController e1 = floor.pressButton(dir);
			System.out.println(" elevator selected : " + e1.ecid);
			e1.moveToDest(destFloorId, dir);
		}
		else {
			System.out.println(" floor : " + floorId + " is not in building");
		}
	}
	
	public void processElevatorRequests() {
		for (ElevatorCarController ecc : this.eccList) {
			ecc.processElevatorRequests();
		}
	}
}
