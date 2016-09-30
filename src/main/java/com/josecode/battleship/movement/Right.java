package com.josecode.battleship.movement;

import com.josecode.battleship.board.Board;
import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.AllOrientationAreBusyException;
import com.josecode.battleship.util.Orientation;

public class Right<L,R> implements IMovement<L,R>{
	
	@Override
	public void doMovement(Ship<L, R> ship,Board<L,R> board) throws AllOrientationAreBusyException{
		
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
				throw new AllOrientationAreBusyException("All orientation are busy");
			default:
		          throw new AssertionError("Ship without orientation");
		}
	}
}
