package com.josecode.battleship.board;

import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.AllOrientationAreBusyException;
import com.josecode.battleship.exception.CellPopulatedException;
import com.josecode.battleship.exception.OutOfLimitsException;
import com.josecode.battleship.movement.Ahead;
import com.josecode.battleship.movement.IMovement;
import com.josecode.battleship.movement.ITurn;
import com.josecode.battleship.movement.Right;
import com.josecode.battleship.util.Util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

public class BuildWorld<L,R> {
		
	public void createWorld(Board<L, R> board,List<Ship<L, R>> listShip) {
		listShip.stream().forEach( ship -> {
			buildShipInitial(board, 0, ship);	
			addCellToBoard(ship, board);
		});
		board.printBoard();
	}
	
	@SuppressWarnings("unchecked")
	protected  Ship<L, R> buildShipInitial(Board<L, R> board,int numberTimes,Ship<L, R> ship) {
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
	
	protected void doMovements(List<IMovement<L, R>> listMovement,Board<L, R> board,int numberTimes,Ship<L, R> ship) {
		int numberOrietntationTry = 1;
		try {
			goAheadMovements(listMovement,ship,board,numberTimes,numberOrietntationTry);
			board.getCellsAdded().addAll(ship.getPosition());
		} catch (CellPopulatedException | OutOfLimitsException | AllOrientationAreBusyException e) {
			againBuilShipInitial(board, numberTimes, ship);
		}
	}
	
	private void againBuilShipInitial(Board<L, R> board,int numberTimes,Ship<L, R> ship) {
	        ship.inicializarPosition();
			numberTimes++;
			if (numberTimes == 10) {
				throw new AssertionError("No was possible build the world");
			}
			buildShipInitial(board,numberTimes,ship);
	}
	
	private void goAheadMovements(List<IMovement<L, R>> listMovement,Ship<L, R> ship,Board<L, R> board,int numberTimes,
			int numberOrietntationTry) throws CellPopulatedException, OutOfLimitsException, AllOrientationAreBusyException {

		try {		
			for (IMovement<L, R> iMovement : listMovement) {
				iMovement.doMovement(ship,board);
			}
		} catch (OutOfLimitsException | CellPopulatedException e) {
			changeOrientationTryAgain(ship, board, listMovement, numberTimes,numberOrietntationTry);            	
		} 
	}
	
	private void changeOrientationTryAgain(Ship<L, R> ship,Board<L, R> board,List<IMovement<L, R>> listMovement,
			int numberTimes,int numberOrietntationTry) throws OutOfLimitsException, CellPopulatedException, AllOrientationAreBusyException {
    	ship.inicializarPosition();
		ITurn<L, R> movement = new Right<>();
    	movement.doMovement(ship,numberOrietntationTry);
    	numberOrietntationTry++;
    	goAheadMovements(listMovement, ship,board,numberTimes,numberOrietntationTry);    
	}
	
	private void addCellToBoard(Ship<L, R> ship,Board<L, R> board) {		
		ship.getPosition().stream()
		                  .forEach( p -> 
		      			  	board.addCell(Util.getRight(p), Util.getLeft(p), new Cell(new Ship<L, R>(ship, p))));
	}
}
