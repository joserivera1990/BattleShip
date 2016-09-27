package com.josecode.battleship.board;

import com.josecode.battleship.element.EmptyCell;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class BuildWorld {

	/*public void createShip(Board board, String parameters) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				board.addCell(new Cell(i, j, new EmptyCell()));
			}
		}	
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Random rnd = new Random();
		String test = "A,4";
		System.out.println((int) (Math.random() * 10) + 1);
		System.out.println((int) (Math.random() * 10) + 1);
		
		
		Set<Cell> setCells = new HashSet<>();
		Board board = new Board(10);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Cell cell = new Cell(i, j,null, "N");
				board.addCell(i, j, cell);
				setCells.add(cell);
			}
		}
		
		//setCells.c
		
		
		//board.printBoard();
	}
}
