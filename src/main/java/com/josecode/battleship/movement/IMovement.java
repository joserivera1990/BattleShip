package com.josecode.battleship.movement;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

import com.josecode.battleship.board.Board;
import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.CellPopulatedException;
import com.josecode.battleship.exception.OutOfLimitsException;

public interface IMovement<L,R> {
	
	public void doMovement(Ship<L,R> ship,Board board) throws OutOfLimitsException, CellPopulatedException;
    
	@SuppressWarnings("unchecked")
	default Pair<L, R> getLastStep(Ship<L,R> ship,Board board) throws OutOfLimitsException, CellPopulatedException {
		
		if (ship.getPosition().isEmpty()) {
			ship.getPosition().add(ship.getPositionStarting());
			int x = (int) ship.getPositionStarting().getLeft();
			int y = (int) ship.getPositionStarting().getRight();
			checkPosibleShipPosition(x, y, board.getLength(), board.getCellsAdded());
			return ship.getPositionStarting();
		}
		final Iterator itr = ship.getPosition().iterator();
		Pair<L, R> lastPosition = (Pair<L, R>) itr.next();
		while (itr.hasNext()) {
			lastPosition =  (Pair<L, R>) itr.next();
		}
		return lastPosition;
	}
	
	default void checkPosibleShipPosition(int x, int y, int longitude,Set<Pair<L,R>> cellsOcuped) throws OutOfLimitsException, CellPopulatedException {
		if (x == longitude || y == longitude || x == -1 || y == -1 ) {
			throw new OutOfLimitsException("Out of Limit");
		}
		Pair<L,R> newStep = (Pair<L, R>) Pair.of(x, y);
		if (cellsOcuped.contains(newStep)) {
			throw new CellPopulatedException("Cell already populated");
		}
		
	}
}
