package com.happyhouse.backend.dto;

public class StarBoard {
	private Board board;
	private Star star;
	
	public StarBoard() {
		super();
	}
	public StarBoard(Board board, Star star) {
		super();
		this.board = board;
		this.star = star;
	}
	
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Star getStar() {
		return star;
	}
	public void setStar(Star star) {
		this.star = star;
	}
	
	@Override
	public String toString() {
		return "StarBoard [board=" + board + ", star=" + star + "]";
	}
}
