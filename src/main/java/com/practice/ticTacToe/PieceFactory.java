package com.practice.ticTacToe;

public class PieceFactory {
	
	public static Piece getPiece(PieceType pt) {
		
		if (PieceType.X.equals(pt)) {
			return new PieceX();
		}
		else if (PieceType.O.equals(pt)) {
			return new PieceO();
		}
		return null;
	}
}
