package com.josecode.battleship.movement;

import com.josecode.battleship.board.Board;
import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.OutOfLimitsException;
import com.josecode.battleship.util.Orientation;

public class Right<L,R> implements IMovement<L,R>{
	
	@Override
	public void doMovement(Ship<L, R> ship,Board board){
		
		if (ship.getOrientation() == null) {
			ship.setOrientation(Orientation.N);
			return;
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
