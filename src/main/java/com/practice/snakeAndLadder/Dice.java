package com.practice.snakeAndLadder;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Dice {
	
	static List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
	static Random random = new Random();
	
	public static int getValue() {
		int index = random.nextInt(list.size());
		return list.get(index);
	}
	
}
