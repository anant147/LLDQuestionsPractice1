package com.practice.ticTacToe;

public class Board {
	
	int boardSize;
	PieceType[][] bd;
	int placesOccupied;
	
	public Board(int n) {
		this.boardSize = n;
		this.bd = new PieceType[n][n];
	}
	
	public boolean isOccupied(int x, int y) {
		if (0<=x && x<boardSize && 0<=y && y<boardSize ) {
			return bd[x][y] != null;
		}
		else {
			throw new RuntimeException(" input are not in range of board");
		}
	}
	
	public boolean boardFilled() {
		return this.placesOccupied == (this.boardSize * this.boardSize);
	}
	
	public boolean mark(int x, int y, PieceType pt) {
		this.bd[x][y] = pt;
		this.placesOccupied++;
		return isGameFinish(x, y, pt);
	}

	private boolean isGameFinish(int x, int y, PieceType pt) {
		
		boolean cond = true;
		
		for (int i=0;i<this.boardSize;i++) {
			if (this.bd[x][i] == null || !this.bd[x][i].equals(pt)) {
				cond = false;
				break;
			}
		}
		
		if (cond) {
			return cond;
		}
		
		cond = true;
		for (int i=0;i<this.boardSize;i++) {
			if (this.bd[i][x] == null || !this.bd[i][x].equals(pt)) {
				cond = false;
				break;
			}
		}
		
		if (cond) {
			return cond;
		}
		
		if (x == y) {
			cond = true;
			for (int i=0;i<this.boardSize;i++) {
				if (this.bd[i][i] == null || !this.bd[i][i].equals(pt)) {
					cond = false;
					break;
				}
			}
			
			if (cond) {
				return cond;
			}
		}
		
		if (x+y == this.boardSize-1) {
			
			cond = true;
			int u = this.boardSize-1;
			
			for (int i=0;i<this.boardSize;i++) {
				if (this.bd[i][u-i] == null || !this.bd[i][u-i].equals(pt)) {
					cond = false;
					break;
				}
			}
			
			if (cond) {
				return cond;
			}
		}
		return false;
	}
	
	public void showBoard() {
		int n = this.boardSize;
		System.out.println("\n");
		for (int i=0;i<n;i++) {
			
			for (int j=0;j<n;j++) {
				String c = this.bd[i][j] == null ? "B" : this.bd[i][j].toString(); 
				System.out.print("| "+c+" |");
			}
			System.out.println();
		}
		
		System.out.println("\n");
	}
	
}
