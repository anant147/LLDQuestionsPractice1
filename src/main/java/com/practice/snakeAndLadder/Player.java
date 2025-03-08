package com.practice.snakeAndLadder;

public class Player {
	
	String name;
	int curPos;
	
	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getCurPos() {
		return curPos;
	}

	public void setCurPos(int val) {
		this.curPos =  val;
	}
	
	
}
