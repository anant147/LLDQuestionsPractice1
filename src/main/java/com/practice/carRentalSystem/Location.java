package com.practice.carRentalSystem;

public class Location {
	
	int locationId;
	String city;
	
	public Location(int id, String city) {
		this.locationId = id;
		this.city  = city;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
