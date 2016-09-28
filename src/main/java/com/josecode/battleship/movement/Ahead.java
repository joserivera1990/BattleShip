package com.josecode.battleship.movement;

import org.apache.commons.lang3.tuple.Pair;

import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.OutOfLimitsException;

public class Ahead<L,R> implements IMovement<L,R>{
    
	@Override
	public void doMovement(Ship<L,R> ship) throws OutOfLimitsException {
		Pair<L, R> lastPosition = getLastStep(ship.getPosition());
		int x = (int) lastPosition.getLeft();
		int y = (int) lastPosition.getRight();
		switch (ship.getOrientation()) {
			case N:
				checkPosibleShipPosition(++x, y,ship.getLongitude());
			break;
			case S:
				x--;
			break;
			case W:
				y--;
			break;
			case E:
				y++;
			break;	
		}
		Pair<L,R> newStep = (Pair<L, R>) Pair.of(x, y);
		ship.getPosition().add(newStep);
	}
	
	private void checkPosibleShipPosition(int x, int y, int longitude) throws OutOfLimitsException {
		System.out.println(x+"new");
		if(x == longitude || y == longitude || x == -1 || y == -1 ) {
			throw new OutOfLimitsException("Out of Limit");
		}
	}
}
