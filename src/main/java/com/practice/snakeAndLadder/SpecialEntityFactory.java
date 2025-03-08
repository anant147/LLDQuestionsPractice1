package com.practice.snakeAndLadder;

public class SpecialEntityFactory {
	
	public static SpecialEntity getEntity(int x, int y, SpecialEntityType spet) {
		
		if (SpecialEntityType.LADDER.equals(spet)) {
			return new Ladder(x, y);
		}
		else if (SpecialEntityType.SNAKE.equals(spet)) {
			return new Snake(x, y);
		}
		return null;
	}
}
