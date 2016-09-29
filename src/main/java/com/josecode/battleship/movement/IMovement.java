package com.josecode.battleship.movement;

import java.util.Iterator;

import org.apache.commons.lang3.tuple.Pair;

import com.josecode.battleship.board.Board;
import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.CellPopulatedException;
import com.josecode.battleship.exception.OutOfLimitsException;

public interface IMovement<L,R> {
	
	public void doMovement(Ship<L,R> ship,Board board) throws OutOfLimitsException, CellPopulatedException;
    
	@SuppressWarnings("unchecked")
	default Pair<L, R> getLastStep(Ship<L,R> ship) {
		
		if (ship.getPosition().isEmpty()) {
			ship.getPosition().add(ship.getPositionStarting());
			return ship.getPositionStarting();
		}
		final Iterator itr = ship.getPosition().iterator();
		Pair<L, R> lastPosition = (Pair<L, R>) itr.next();
		while (itr.hasNext()) {
			lastPosition =  (Pair<L, R>) itr.next();
		}
		return lastPosition;
	}
}
