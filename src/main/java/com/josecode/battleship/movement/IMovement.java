package com.josecode.battleship.movement;

import com.josecode.battleship.board.Board;
import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.AllOrientationAreBusyException;
import com.josecode.battleship.exception.CellPopulatedException;
import com.josecode.battleship.exception.OutOfLimitsException;

@FunctionalInterface
public interface IMovement {
	
	public void doMovement(Ship ship,Board board) throws 
		OutOfLimitsException, CellPopulatedException,AllOrientationAreBusyException;
    	
}
