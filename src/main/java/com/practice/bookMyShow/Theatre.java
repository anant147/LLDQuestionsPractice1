package com.practice.bookMyShow;

import java.util.HashMap;

public class Theatre {
	int theatreId;
	String city;
	HashMap<Integer, Screen> screens;
	HashMap<Integer, Show> shows;
	
	public Theatre(int theatreId, String city) {
		this.theatreId = theatreId;
		this.city = city;
		this.screens = new HashMap<>();
		this.shows = new HashMap<>();
	}
	
	public void addScreen(Screen screen) {
		this.screens.put(screen.screenId, screen);
	}
	
	public void addShow(Show show) {
		this.shows.put(show.showId, show);
	}
	
}
