package com.practice.elevatorSystem;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ElevatorCarController {
	
	int ecid;
	ElevatorCar elevator;
	PriorityQueue<Integer> upPq ; // minPq
	PriorityQueue<Integer> downPq; // maxPq
	List<Integer> pendingRequests;
	
	public ElevatorCarController(int ecid) {
		this.ecid = ecid;
		this.elevator = new ElevatorCar(ecid);
		this.upPq = new PriorityQueue<>();
		this.downPq = new PriorityQueue<>(Collections.reverseOrder());
		this.pendingRequests = new ArrayList<>();
	}
	
	public void moveToDest(int floor, Direction dir) {
		this.elevator.move(floor, dir);
	}
	
	public void setInternalButtonDispatcher(InternalButtonDispatcher internalDispatcher) {
		this.elevator.setInternalButtonDispatcher(internalDispatcher);
	}
	
	public void submitRequest(int floorId, Direction dir) {
		
		if (this.elevator.status == Status.IDLE) {
			flipStatus();
		}
		
		int currentFloor = this.elevator.currentFloor;
		Direction curDir = this.elevator.direction;
		
		if (currentFloor == floorId) {
			System.out.println(" no need to process the request. as request floor is same as cur floor : " + currentFloor);
		}
		else if (currentFloor < floorId && dir == curDir && curDir == Direction.UP) {
			this.upPq.add(floorId);
			System.out.println("up req, currentFloor : " + currentFloor + " , floorid : " + floorId + " , currentDir : " + curDir);;
		}
		else if (currentFloor > floorId && dir == curDir && curDir == Direction.DOWN) {
			this.downPq.add(floorId);
			System.out.println("down req, currentFloor : " + currentFloor + " , floorid : " + floorId + " , currentDir : " + curDir);;
		}
		else {
			this.pendingRequests.add(floorId);
			System.out.println("pending req, currentFloor : " + currentFloor + " , floorid : " + floorId + " , currentDir : " + curDir);;
		}
	}
	
	public void processElevatorRequests() {
		
		System.out.println(" \n \n processing elevator request of elevator : " + this.ecid);
		
		if (!this.upPq.isEmpty() || !this.downPq.isEmpty() || this.pendingRequests.size()>0) {
			
			System.out.println(" size of up pq : " + this.upPq.size());
			System.out.println(" size of down pq : " + this.downPq.size());
			System.out.println(" size of pending requests : " + this.pendingRequests.size());
			
			while (!this.upPq.isEmpty() || !this.downPq.isEmpty() || this.pendingRequests.size()>0) {
				
				while(!this.upPq.isEmpty() || !this.downPq.isEmpty()) {
					
					if (this.elevator.direction == Direction.UP && this.upPq.size()>0) {
						System.out.println(" going up");
						processRequest(this.upPq);
					}
					else if (this.elevator.direction == Direction.DOWN && this.downPq.size()>0) {
						System.out.println(" going down");
						processRequest(this.downPq);
					}
					
					flipDirection();
				}
			}
			
			if (pendingRequests.size()>0) {
				
				int currentFloor = this.elevator.currentFloor;
				
				for (Integer i : this.pendingRequests) {
					
					if (currentFloor < i) {
						this.upPq.add(i);
						System.out.println(" pending req : " + i + " is added to up pq , currentFloor : " + currentFloor);
					}
					else {
						this.downPq.add(i);
						System.out.println(" pending req : " + i + " is added to down pq , currentFloor : " + currentFloor);
					}
				}
				
				this.pendingRequests.clear();
			}
			else {
				System.out.println(" there is no request for the elevator : " + this.ecid);
			}
			
			flipStatus();
		}
		else {
			System.out.println(" there is no request to process for elevator : " + this.ecid);
		}
		
		System.out.println("\n\n");
	}
	
	private void processRequest(PriorityQueue<Integer> pq) {
		
		while (!pq.isEmpty()) {
			int df = pq.poll();
			this.elevator.currentFloor = df;
			displayCurrentFloor();
		}
	}

	private void displayCurrentFloor() {
		this.elevator.display();
	}

	public void flipStatus() {
		Status oldStatus = this.elevator.status;
		Status newStatus = oldStatus == Status.IDLE ? Status.MOVING : Status.IDLE;
		this.elevator.status = newStatus;
		System.out.println(" status of elevator : " + this.ecid + " is moved from " + oldStatus + " to " + newStatus);
	}
	
	public void flipDirection() {
		Direction oldDir = this.elevator.direction;
		Direction newDir = oldDir == Direction.UP ? Direction.DOWN : Direction.UP;
		this.elevator.direction = newDir;
		System.out.println(" direction of elevator : " + this.ecid + " has changed from " + oldDir + " to " + newDir);
	}
}
