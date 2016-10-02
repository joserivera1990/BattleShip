package com.josecode.battleship.movement;

import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.AllOrientationAreBusyException;
import com.josecode.battleship.util.Orientation;

public class Right<L,R> implements ITurn<L,R>{
	
	private static final int NUMBER_COORDINATE = 4;
	
	@Override
	public void doMovement(Ship<L, R> ship,int numberOrientationTried)
			throws AllOrientationAreBusyException {
		
		if (numberOrientationTried == NUMBER_COORDINATE) {
			throw new AllOrientationAreBusyException("All orientation are busy");
		}
			
		switch (ship.getOrientation()) {
			case N:
				ship.setOrientation(Orientation.E);
			break;
			case E:
				ship.setOrientation(Orientation.S);
			break;
			case S:
				ship.setOrientation(Orientation.W);
			break;
			case W:
				ship.setOrientation(Orientation.N);
			break;	
			default:
		          throw new AssertionError("Ship without orientation");
		}
	}
}
