package com.practice.snakeAndLadder;

public abstract class SpecialEntity {
	
	int st;
	int ed;
	SpecialEntityType spet;
	
	public SpecialEntity(int st, int ed, SpecialEntityType spet) {
		this.st = st;
		this.ed = ed;
		this.spet = spet;
	}

	public int getSt() {
		return st;
	}

	public int getEd() {
		return ed;
	}

	public SpecialEntityType getSpet() {
		return spet;
	}
}
