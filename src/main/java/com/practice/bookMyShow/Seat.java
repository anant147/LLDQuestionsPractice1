package com.practice.bookMyShow;

public  class Seat {
	int seatId;
	int row;
	int screenId;
	SeatCategory category;
	
	public Seat(int id, int row, int screenId, SeatCategory category) {
		this.seatId = id;
		this.row = row;
		this.screenId = screenId;
		this.category = category;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public SeatCategory getCategory() {
		return category;
	}

	public void setCategory(SeatCategory category) {
		this.category = category;
	}
}
