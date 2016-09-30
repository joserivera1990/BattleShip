package com.josecode.battleship.movement;

import com.josecode.battleship.board.Board;
import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.AllOrientationAreBusyException;
import com.josecode.battleship.exception.CellPopulatedException;
import com.josecode.battleship.exception.OutOfLimitsException;

public interface IMovement<L,R> {
	
	public void doMovement(Ship<L,R> ship,Board<L,R> board) throws 
		OutOfLimitsException, CellPopulatedException,AllOrientationAreBusyException;
    	
}
