package com.practice.bookMyShow;

import java.util.HashMap;
import java.util.ArrayList;

public class Screen {
	int screenId;
	HashMap<SeatCategory, ArrayList<Seat>> seatCategoryMap;
	HashMap<Integer, Seat> seatMap;
	int threatreId;
	
	public Screen(int id, int threatreId) {
		this.screenId = id;
		this.threatreId = threatreId;
		this.seatMap = new HashMap<>();
		this.seatCategoryMap = new HashMap<>();
	}
	
	public void add(Seat seat) {
		if (seatCategoryMap.containsKey(seat.category)) {
			seatCategoryMap.get(seat.category).add(seat);
		}
		else {
			ArrayList<Seat> seats  = new ArrayList<>();
			seats.add(seat);
			seatCategoryMap.put(seat.category, seats);
		}
		this.seatMap.put(seat.seatId, seat);
	}
	
	public Seat getSeat(int id) {
		return this.seatMap.get(id);
	}
}
