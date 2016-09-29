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
		Pair<L, R> lastPosition = getLastStep(ship);
		int x = (int) lastPosition.getLeft();
		int y = (int) lastPosition.getRight();
		switch (ship.getOrientation()) {
			case N:
				checkPosibleShipPosition(x, ++y,ship.getLongitude(),board.getCellsAdded());
			break;
			case S:
				checkPosibleShipPosition(x, --y,ship.getLongitude(),board.getCellsAdded());
			break;
			case W:
				checkPosibleShipPosition(--x, y,ship.getLongitude(),board.getCellsAdded());
			break;
			case E:
				checkPosibleShipPosition(++x, y,ship.getLongitude(),board.getCellsAdded());
			break;
			default:
		          throw new AssertionError("Ship without orientation");
		}
		
		Pair<L,R> newStep = (Pair<L, R>) Pair.of(x, y);
		ship.getPosition().add(newStep);
	}
	
	private void checkPosibleShipPosition(int x, int y, int longitude,Set<Pair<L,R>> cellsOcuped) throws OutOfLimitsException, CellPopulatedException {
		if (x == longitude || y == longitude || x == -1 || y == -1 ) {
			throw new OutOfLimitsException("Out of Limit");
		}
		Pair<L,R> newStep = (Pair<L, R>) Pair.of(x, y);
		if (cellsOcuped.contains(newStep)) {
			throw new CellPopulatedException("Cell already populated");
		}
		
	}
}
