package com.josecode.battleship.movement;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

import com.josecode.battleship.board.Board;
import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.CellPopulatedException;
import com.josecode.battleship.exception.OutOfLimitsException;
import com.josecode.battleship.util.Util;

public class Ahead<L,R> implements IMovement<L,R>{
    
	@Override
	public void doMovement(Ship<L,R> ship,Board<L,R> board) throws OutOfLimitsException, CellPopulatedException {
		Pair<L, R> lastPosition = getLastStep(ship,board);
		int x = (int) lastPosition.getLeft();
		int y = (int) lastPosition.getRight();
		switch (ship.getOrientation()) {
			case N:
				checkPosibleShipPosition(x, ++y,board.getLength(),board.getCellsAdded());
			break;
			case S:
				checkPosibleShipPosition(x, --y,board.getLength(),board.getCellsAdded());
			break;
			case W:
				checkPosibleShipPosition(--x, y,board.getLength(),board.getCellsAdded());
			break;
			case E:
				checkPosibleShipPosition(++x, y,board.getLength(),board.getCellsAdded());
			break;
			default:
		          throw new AssertionError("Ship without orientation");
		}
		
		Pair<L,R> newStep = (Pair<L, R>) Pair.of(x, y);
		ship.getPosition().add(newStep);
	}
	
	private Pair<L, R> getLastStep(Ship<L,R> ship,Board<L,R> board) throws OutOfLimitsException, 
		CellPopulatedException {
	
		if (ship.getPosition().isEmpty()) {
			ship.getPosition().add(ship.getPositionStarting());
			int x = Util.getLeft(ship.getPositionStarting());
			int y = Util.getRight(ship.getPositionStarting());
			checkPosibleShipPosition(x, y, board.getLength(), board.getCellsAdded());
			return ship.getPositionStarting();
		}
		return getLastPosition(ship.getPosition());
	}
	
	private void checkPosibleShipPosition(int x, int y, int longitude,Set<Pair<L,R>> cellsOcuped) 
			throws OutOfLimitsException, CellPopulatedException {
		if (x == longitude || y == longitude || x == -1 || y == -1 ) {
			throw new OutOfLimitsException("Out of Limit");
		}
		Pair<L,R> newStep = (Pair<L, R>) Pair.of(x, y);
		if (cellsOcuped.contains(newStep)) {
			throw new CellPopulatedException("Cell already populated");
		}		
	}
	
	private Pair<L, R> getLastPosition(Set<Pair<L,R>> position) {
		final Iterator itr = position.iterator();
		Pair<L, R> lastPosition = (Pair<L, R>) itr.next();
		while (itr.hasNext()) {
			lastPosition =  (Pair<L, R>) itr.next();
		}
		return lastPosition;
	}
}
