package com.practice.elevatorSystem;

public class Door {
	
	public void open(int elevatorid, int floor) {
		System.out.println(" door of the elevator : " + elevatorid + " opens at floor : " + floor);
	}
	
	public void close(int elevator, int floor) {
		System.out.println(" door of the elevator : " + elevator + " closes at floor : " + floor);
	}
}
