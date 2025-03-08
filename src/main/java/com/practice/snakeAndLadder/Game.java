package com.practice.snakeAndLadder;

import java.util.Queue;
import java.util.LinkedList;

public class Game {
	
	Board board;
	Queue<Player> players;
	
	public Game(int boardSize, int snakeCount, int ladderCount, int playerCount) {
		this.board = new Board(boardSize,  snakeCount,  ladderCount);
		this.players = new LinkedList<>();
		addPlayers(playerCount);
	}

	private void addPlayers(int playerCount) {
		
		int val=1;
		for (int i=0;i<playerCount;i++) {
			Player player = new Player("p"+val);
			val++;
			this.players.add(player);
		}
	}
	
	public void playGame() {
		
		if (board != null && players != null && players.size()>0) {
			
			System.out.println(" board size : " + board.boardSize + ", target : " + board.target + " , snake count : " + board.snakeCount + " , ladder count : " + board.ladderCount);
			
			boolean progress = true;
			System.out.println("\n starting the game \n");
			
			while (progress) {
				Player pl = players.poll();
				int curPos = pl.getCurPos();
				
				int diceVal = Dice.getValue();
				int newPos = diceVal + curPos;
				System.out.println("player : " + pl.getName() + " , curPos : " + curPos + " , dice : " + diceVal + " , newPos : " + newPos);
				 newPos = board.getEntityPosition(newPos);
				 pl.setCurPos(newPos);
				 System.out.println(" player : " + pl.getName() + " , new pos : " + newPos);
				
				 if (board.target<=newPos) {
					 System.out.println(" player : " + pl.name + " has reached the target and has won the game");
					 progress = false;
					 break;
				 }
				
				players.add(pl);
			}
			
			System.out.println("\n ending the game \n");

		}
		else {
			System.out.println(" cannot play the game, as values are not set properly");
		}
	}
}
