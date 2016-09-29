package com.josecode.battleship.movement;

import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

import com.josecode.battleship.board.Board;
import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.CellPopulatedException;
import com.josecode.battleship.exception.OutOfLimitsException;

public class Ahead<L,R> implements IMovement<L,R>{
    
	@Override
	public void doMovement(Ship<L,R> ship,Board board) throws OutOfLimitsException, CellPopulatedException {
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
	
}
