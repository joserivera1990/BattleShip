package com.josecode.battleship.board;


import com.josecode.battleship.element.EmptyCell;
import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.CellPopulatedException;
import com.josecode.battleship.exception.OutOfLimitsException;
import com.josecode.battleship.movement.Ahead;
import com.josecode.battleship.movement.IMovement;
import com.josecode.battleship.movement.Right;
import com.josecode.battleship.util.Orientation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

public class BuildWorld<L,R> {

	/*for (int i = 0; i < 10; i++) {
	for (int j = 0; j < 10; j++) {
		Cell cell = new Cell(i, j,null, "N");
		board1.addCell(i, j, cell);
	}
}*/
	
	/*public void createShip(Board board, String parameters) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				board.addCell(new Cell(i, j, new EmptyCell()));
			}
		}	
	}*/
	
	public static <L, R> void main(String[] args) {				
		
		Board board1 = new Board<L, R>(10);
		board1.setLength(10);
		Ship<L, R> ship = (Ship<L, R>) new BuildWorld<>().buildShipInitial(5,board1,4,7,0);
		ship = (Ship<L, R>) new BuildWorld<>().buildShipInitial(4,board1,5,6,0);
		new BuildWorld<>().buildShipInitial(3,board1,4,4,0);
		new BuildWorld<>().buildShipInitial(3,board1,4,4,0);
		new BuildWorld<>().buildShipInitial(5,board1,4,7,0);
		new BuildWorld<>().buildShipInitial(4,board1,5,6,0);
		//new BuildWorld<>().buildShipInitial(3,board1,4,4,0);
		//new BuildWorld<>().buildShipInitial(3,board1,4,4,0);
		/*new BuildWorld<>().buildShipInitial(9,board1);
		new BuildWorld<>().buildShipInitial(5,board1);
		new BuildWorld<>().buildShipInitial(4,board1);
		new BuildWorld<>().buildShipInitial(7,board1);
		new BuildWorld<>().buildShipInitial(5,board1);
		new BuildWorld<>().buildShipInitial(7,board1);
		new BuildWorld<>().buildShipInitial(9,board1);*/

		final Iterator itr = board1.getCellsAdded().iterator();
		while (itr.hasNext()) {
			Pair<L, R> lastPosition = (Pair<L, R>) itr.next();
			int x = (int) lastPosition.getLeft();
			int y = (int) lastPosition.getRight();
			Cell cell = new Cell(x, y, null, "S");
			board1.addCell(x, y, cell);
		}

		board1.printBoard();
		
	}
	
	public  Ship<L, R> buildShipInitial(int lenghtBoard,Board board,int x,int y,int numberTimes) {
		x = (int) (Math.random() * 9) + 1;
		y = (int) (Math.random() * 9) + 1;
		System.out.println(x);
		System.out.println(y);
		Pair<L, R> positionStarting = (Pair<L, R>) Pair.of(x, y);
		Ship<L, R> ship = new Ship<>();
		ship.setPositionStarting(positionStarting);
		ship.setLongitude(10);
		List<IMovement<L, R>> listMovement = new ArrayList<>();
		for (int i = 0; i < lenghtBoard-1; i++) {
			IMovement<L, R> movement = new Ahead<>();
			listMovement.add(movement);
		}

		try {
			goOverMovements(listMovement,ship,board,numberTimes);
			board.getCellsAdded().addAll(ship.getPosition());
			System.out.println(ship.getPosition());
		} catch (CellPopulatedException e) {
				numberTimes++;
				System.out.println("repeat"+numberTimes);
				if (numberTimes == 10) {
					throw new AssertionError("No was possible build the world");
				}
				buildShipInitial(lenghtBoard, board,0,0,numberTimes);
		}
		return ship;
	}
	
	public void goOverMovements(List<IMovement<L, R>> listMovement,Ship<L, R> ship,Board board,int numberTimes) throws CellPopulatedException {
		try {
			IMovement<L, R> movement = new Right<>();
	    	movement.doMovement(ship,board);
			for (IMovement<L, R> iMovement : listMovement) {
				iMovement.doMovement(ship,board);
			}
		} catch (OutOfLimitsException | CellPopulatedException e) {
            if (!ship.getOrientation().equals(Orientation.W)) {
            	ship.inicializarPosition();
            	goOverMovements(listMovement, ship,board,numberTimes);            	
            } else {
            	throw new CellPopulatedException("Cell already populated");
            }
		}
	}
	
}
