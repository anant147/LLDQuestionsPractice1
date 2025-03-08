package com.practice.snakeAndLadder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.HashMap;

public class Board {
	
	int boardSize;
	int snakeCount;
	int ladderCount;
	int target;
	List<SpecialEntity> specailEntities;
	HashMap<Integer, SpecialEntity> entityMap;
	HashSet<Integer> set = new HashSet<>();
	Random random = new Random();
	
	public Board(int boardSize, int snakeCount, int ladderCount) {
		this.boardSize = boardSize;
		this.target = boardSize * boardSize;
		this.snakeCount = snakeCount;
		this.ladderCount = ladderCount;
		this.entityMap = new HashMap<>();
		this.specailEntities = new ArrayList<>();
		addSnakeAndLadder();
	}

	private void addSnakeAndLadder() {
		
		List<SpecialEntity> snakes = new ArrayList<>();
		
		while (snakes.size()<snakeCount) {
			int x = random.nextInt(target);
			int y = random.nextInt(target);
			
			if (!set.contains(x) && !set.contains(y) && x!=y) {
				int st = Math.max(x, y);
				int ed = Math.min(x, y);
				SpecialEntity snake = SpecialEntityFactory.getEntity(st, ed, SpecialEntityType.SNAKE );
				snakes.add(snake); 
				this.entityMap.put(st, snake);
				set.add(st); set.add(ed);
			}
		}
		this.specailEntities.addAll(snakes);
		
		List<SpecialEntity> ladders = new ArrayList<>();
		
		while(ladders.size() < ladderCount) {
			
			int x = random.nextInt(target);
			int y = random.nextInt(target);
			
			if (!set.contains(x) && !set.contains(y) && x!=y) {
				int st = Math.min(x, y);
				int ed = Math.max(x, y);
				SpecialEntity ladder = SpecialEntityFactory.getEntity(st, ed, SpecialEntityType.LADDER);
				ladders.add(ladder);
				this.entityMap.put(st, ladder);
				set.add(st); set.add(ed);
			}
		}
		this.specailEntities.addAll( ladders);
		
		for (SpecialEntity se : this.specailEntities) {
			System.out.println(se.spet + " , " + se.st + " , " + se.ed);
		}
	}
	
	public int getEntityPosition(int pos) {
		if (this.entityMap.containsKey(pos)) {
			SpecialEntity se = this.entityMap.get(pos);
			System.out.println(" at pos : " + pos + " , " + se.spet + " is present with end of " + se.ed);
			return se.ed;
		}
		return pos;
	}
}
