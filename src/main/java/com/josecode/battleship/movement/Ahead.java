package com.josecode.battleship.movement;

import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

import com.josecode.battleship.board.Board;
import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.CellPopulatedException;
import com.josecode.battleship.exception.OutOfLimitsException;
import com.josecode.battleship.util.Util;

public class Ahead implements IMovement {
    
	@Override
	public void doMovement(Ship ship,Board board) throws OutOfLimitsException, CellPopulatedException {
		Pair<Integer, Integer> lastPosition = getLastStep(ship,board);
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
		
		Pair<Integer, Integer> newStep = Pair.of(x, y);
		ship.getPosition().add(newStep);
	}
	
	private Pair<Integer, Integer> getLastStep(Ship ship,Board board) throws OutOfLimitsException, 
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
	
	private void checkPosibleShipPosition(int x, int y, int longitude,Set<Pair<Integer,Integer>> cellsOcuped) 
			throws OutOfLimitsException, CellPopulatedException {
		if (x == longitude || y == longitude || x == -1 || y == -1 ) {
			throw new OutOfLimitsException("Out of Limit");
		}
		Pair<Integer,Integer> newStep = Pair.of(x, y);
		if (cellsOcuped.contains(newStep)) {
			throw new CellPopulatedException("Cell already populated");
		}		
	}
		
	private Pair<Integer, Integer> getLastPosition(Set<Pair<Integer,Integer>> position) {
		return position.stream().reduce((first,second) -> second).get();
	}
}
