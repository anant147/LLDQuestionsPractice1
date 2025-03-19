package com.practice.elevatorSystem;

public class InternalButton {
	
	int eid;
	InternalButtonDispatcher internalButtonDispatcher;
	
	public InternalButton(int eid) {
		this.eid = eid;
	}
	
	public void setInternalButtonDispatcher(InternalButtonDispatcher internalDispatcher) {
		this.internalButtonDispatcher = internalDispatcher;
	}
	
	public void pressButton(int destFloorId, Direction dir) {
		if (this.internalButtonDispatcher != null) {
			this.internalButtonDispatcher.pressButton(this.eid, destFloorId, dir);
		}
		else {
			System.out.println(" cannot process requrest as internal button dispatcher not configured.");
		}
	}
}
