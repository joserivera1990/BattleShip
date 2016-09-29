package com.josecode.battleship.board;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;



public class Board<L, R> {
  
	private Cell [][] cells;
	Set<Pair<L,R>> cellsAdded;
	
	public Board(final int length) {
		cells = new Cell[length][length];
		cellsAdded = new HashSet<>();
	} 
		
	public  void addCell(int x, int y, Cell cell){
		cells[x][y] = cell;
	}
	public Cell[][] getCells() {
		return cells;
	}
	
	public void printBoard(){
		System.out.print("    A B C D E F G H I J\n");
		System.out.print("  + - - - - - - - - - -\n");	
		for (int i = 0; i < cells.length; i++) {	
			System.out.print(i + " | ");
			for (int j = 0; j < cells.length; j++) {
				System.out.print(cells[i][j].getCode()+ " ");
			}
			System.out.println("\n");
		}
	}
	
	public Set<Pair<L, R>> getCellsAdded() {
		return cellsAdded;
	}

	public void setCellsAdded(Set<Pair<L, R>> cellsAdded) {
		this.cellsAdded = cellsAdded;
	}
}	
