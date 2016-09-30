package com.josecode.battleship.board;

import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.AllOrientationAreBusyException;
import com.josecode.battleship.exception.CellPopulatedException;
import com.josecode.battleship.exception.OutOfLimitsException;
import com.josecode.battleship.movement.Ahead;
import com.josecode.battleship.movement.IMovement;
import com.josecode.battleship.movement.Right;
import com.josecode.battleship.util.Util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import org.apache.commons.lang3.tuple.Pair;

public class BuildWorld<L,R> {
		
	public void createWorld(Board<L, R> board,List<Ship<L, R>> listShip) {
		for (Ship<L, R> ship : listShip) {
			buildShipInitial(board, 0, ship);	
			addCellToBoard(ship, board);
	    }
		board.printBoard();
	}
	
	private void addCellToBoard(Ship<L, R> ship,Board<L, R> board) {
		final Iterator itr = ship.getPosition().iterator();
		while (itr.hasNext()) {
			Pair<L, R> lastPosition = (Pair<L, R>) itr.next();
			Cell cell = new Cell(ship);
			board.addCell(Util.getRight(lastPosition), Util.getLeft(lastPosition), cell);
		}
	}
	
	private  Ship<L, R> buildShipInitial(Board<L, R> board,int numberTimes,Ship<L, R> ship) {
        int x = Util.getRandomNumber(board.getLength());
        int y = Util.getRandomNumber(board.getLength());		
		ship.setPositionStarting((Pair<L, R>) Pair.of(x,y));
		List<IMovement<L, R>> listMovement = new ArrayList<>();
		for (int i = 0; i < ship.getLongitude()-1; i++) {
			IMovement<L, R> movement = new Ahead<>();
			listMovement.add(movement);
		}
		doMovements(listMovement, board, numberTimes, ship);
		return ship;
	}
	
	private void doMovements(List<IMovement<L, R>> listMovement,Board<L, R> board,int numberTimes,Ship<L, R> ship) {
		try {
			goOverMovements(listMovement,ship,board,numberTimes);
			board.getCellsAdded().addAll(ship.getPosition());
		} catch (CellPopulatedException | OutOfLimitsException | AllOrientationAreBusyException e) {
			againBuilShipInitial(listMovement, board, numberTimes, ship);
		}
	}
	
	private void againBuilShipInitial(List<IMovement<L, R>> listMovement,Board<L, R> board,int numberTimes,Ship<L, R> ship) {
	        ship.inicializarPosition();
			numberTimes++;
			System.out.println("repeat"+numberTimes);
			if (numberTimes == 10) {
				throw new AssertionError("No was possible build the world");
			}
			buildShipInitial(board,numberTimes,ship);
	}
	
	private void goOverMovements(List<IMovement<L, R>> listMovement,Ship<L, R> ship,Board<L, R> board,int numberTimes) 
			throws CellPopulatedException, OutOfLimitsException, AllOrientationAreBusyException {
		
		try {		
			for (IMovement<L, R> iMovement : listMovement) {
				iMovement.doMovement(ship,board);
			}
		} catch (OutOfLimitsException | CellPopulatedException e) {
			changeOrientationTryAgain(ship, board, listMovement, numberTimes);            	
		} 
	}
	
	private void changeOrientationTryAgain(Ship<L, R> ship,Board<L, R> board,List<IMovement<L, R>> listMovement,
			int numberTimes) throws OutOfLimitsException, CellPopulatedException, AllOrientationAreBusyException {
    	ship.inicializarPosition();
		IMovement<L, R> movement = new Right<>();
    	movement.doMovement(ship,board);
    	goOverMovements(listMovement, ship,board,numberTimes);    
	}
	
}
