package com.josecode.battleship.board;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

import com.josecode.battleship.element.Ship;
import com.josecode.battleship.element.ThrowBad;
import com.josecode.battleship.util.ShipUtil;

public class Board implements Observer {
  
	private Cell [][] cells;
	private Set<Pair<Integer,Integer>> cellsAdded;
	private final int length;
	
	public Board(final int length) {
		this.cells = new Cell[length][length];
		this.cellsAdded = new HashSet<>();
		this.length = length;
	} 
	
	public  void addCell(int x, int y, Cell cell){
		this.cells[x][y] = cell;
	}

	public void printBoard() {
		System.out.print("    0 1 2 3 4 5 6 7 8 9\n");
		System.out.print("  + - - - - - - - - - -\n");	
		for (int i = 0; i < this.cells.length; i++) {	
			System.out.print(i + " | ");
			for (int j = 0; j < this.cells.length; j++) {
				if (cells[i][j] == null) {
					System.out.print("~"+ " ");
				} else {
					System.out.print(ShipUtil.returnCodePrint(this.cells[i][j].getElement())+ " ");
				}
			}
			System.out.println("\n");
		}
	}
	
	public Set<Pair<Integer, Integer>> getCellsAdded() {
		return cellsAdded;
	}

	public void setCellsAdded(Set<Pair<Integer, Integer>> cellsAdded) {
		this.cellsAdded = cellsAdded;
	}
	
	public int getLength() {
		return length;
	}
	
	public void checkSpecificCell(int x, int y) {
		Cell cell = this.cells[y][x];
        if (cell == null) {
        	this.cells[y][x] = new Cell(new ThrowBad());
        } else if (cell.getElement() instanceof Ship) {
        	((Ship)cell.getElement()).setHit(true);
        }
	}
	
	@Override
    public void update(Observable observable, Object args) {
		if (args instanceof Ship) {
        	ShipUtil.checkPointsShip((Ship) args,this);
        }
    }
	
	public Cell getSpecificCell(int x, int y) {
		return this.cells[y][x];
	}

}	
