package com.practice.ticTacToe;

public class Player {
	
	String name;
	Piece pt;
	
	public Player(String name, Piece pt) {
		this.name = name;
		this.pt = pt;
	}

	public String getName() {
		return name;
	}

	public Piece getPt() {
		return pt;
	}
}
