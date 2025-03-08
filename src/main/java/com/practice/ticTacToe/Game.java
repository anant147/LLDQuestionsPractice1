package com.practice.ticTacToe;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
	
	Board board;
	Queue<Player> players;
	
	public Game(int n) {
		this.board = new Board(n);
		addPlayers();
	}

	private void addPlayers() {
		this.players = new LinkedList<>();
		
		int val = 0;
		for (PieceType pt : PieceType.values()) {
			Piece piece = PieceFactory.getPiece(pt);
			Player player = new Player("p"+val, piece);
			this.players.add(player);
			val++;
		}
	}
	
	public void startGame() {
		
		if (this.board != null && this.players != null && this.players.size()>1) {
			
			Scanner sc = new Scanner(System.in);
			boolean progress = true;
			
			while (progress) {
				
				if (board.boardFilled()) {
					System.out.println(" game has been tied");
					progress = false;
					break;
				}
				
				Player pl = players.poll();
				
				boolean ok = false;
				
				while (!ok) {
					System.out.println(" Player : " + pl.name + " enter the value of x : ");
					int x = sc.nextInt();
					System.out.println(" Player : " + pl.name + " enter the value of y : ");
					int y = sc.nextInt();
					
					if (!board.isOccupied(x, y)) {
						ok = true;
						
						if (board.mark(x, y, pl.pt.pieceType)) {
							System.out.println(" \n Player : " + pl.name + " has win the game \n ");
							progress = false;
						}
						
						this.board.showBoard();
					}
					else {
						System.out.println( "Player : " + pl.name + " enter the values again. earlier values are not valid");
					}
					
				}
				
				
				players.add(pl);
			}
			
			
		}
		else {
			System.out.println("game has not been initialized");
		}
	}
}
