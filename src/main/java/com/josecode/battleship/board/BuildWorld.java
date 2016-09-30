package com.josecode.battleship.board;

import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.CellPopulatedException;
import com.josecode.battleship.exception.OutOfLimitsException;
import com.josecode.battleship.movement.Ahead;
import com.josecode.battleship.movement.IMovement;
import com.josecode.battleship.movement.Right;
import com.josecode.battleship.util.Orientation;
import com.josecode.battleship.util.Util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import org.apache.commons.lang3.tuple.Pair;

public class BuildWorld<L,R> {
	
	/*public static <L, R> void main(String[] args) {				
		
		Board board1 = new Board<L, R>(10);
		board1.setLength(10);
		Ship<L, R> ship = (Ship<L, R>) new BuildWorld<>().buildShipInitial(5,board1,4,7,0);
		ship = (Ship<L, R>) new BuildWorld<>().buildShipInitial(4,board1,5,6,0);
		new BuildWorld<>().buildShipInitial(3,board1,4,4,0);
		new BuildWorld<>().buildShipInitial(3,board1,4,4,0);
		final Iterator itr = board1.getCellsAdded().iterator();
		while (itr.hasNext()) {
			Pair<L, R> lastPosition = (Pair<L, R>) itr.next();
			int x = (int) lastPosition.getLeft();
			int y = (int) lastPosition.getRight();
			Cell cell = new Cell(ship);
			board1.addCell(x, y, cell);
		}

		board1.printBoard();
		
	}*/
	
	public void createWorld(Board board,List<Ship<L, R>> listShip) {
		for (Ship<L, R> ship : listShip) {
			buildShipInitial(board, 0, ship);	
			final Iterator itr = ship.getPosition().iterator();
			while (itr.hasNext()) {
				Pair<L, R> lastPosition = (Pair<L, R>) itr.next();
				Cell cell = new Cell(ship);
				board.addCell(Util.getRight(lastPosition), Util.getLeft(lastPosition), cell);
			}
	    }
		board.printBoard();
	}
	
	
	public  Ship<L, R> buildShipInitial(Board board,int numberTimes,Ship<L, R> ship) {
        int x = Util.getRandomNumber(board.getLength());
        int y = Util.getRandomNumber(board.getLength());		
		System.out.println(x);
		System.out.println(y);
		Pair<L, R> positionStarting = (Pair<L, R>) Pair.of(x,y);
		ship.setPositionStarting(positionStarting);
		List<IMovement<L, R>> listMovement = new ArrayList<>();
		for (int i = 0; i < ship.getLongitude()-1; i++) {
			IMovement<L, R> movement = new Ahead<>();
			listMovement.add(movement);
		}

		try {
			goOverMovements(listMovement,ship,board,numberTimes);
			board.getCellsAdded().addAll(ship.getPosition());
		} catch (CellPopulatedException | OutOfLimitsException  e) {
			    ship.inicializarPosition();//TODO
				numberTimes++;
				System.out.println("repeat"+numberTimes);
				if (numberTimes == 10) {
					throw new AssertionError("No was possible build the world");
				}
				buildShipInitial(board,numberTimes,ship);
		}
		return ship;
	}
	
	public void goOverMovements(List<IMovement<L, R>> listMovement,Ship<L, R> ship,Board board,int numberTimes) 
			throws CellPopulatedException, OutOfLimitsException {
		try {

			for (IMovement<L, R> iMovement : listMovement) {
				iMovement.doMovement(ship,board);
			}
		} catch (OutOfLimitsException | CellPopulatedException e) {
            if (!ship.getOrientation().equals(Orientation.W)) {
            	ship.inicializarPosition();
    			IMovement<L, R> movement = new Right<>();
    	    	movement.doMovement(ship,board);
            	goOverMovements(listMovement, ship,board,numberTimes);            	
            } else {
            	throw new CellPopulatedException("Cell already populated");
            }
		}
	}
	
}
