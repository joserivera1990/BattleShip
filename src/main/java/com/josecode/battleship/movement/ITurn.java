package com.josecode.battleship.movement;

import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.AllOrientationAreBusyException;
import com.josecode.battleship.exception.CellPopulatedException;
import com.josecode.battleship.exception.OutOfLimitsException;

@FunctionalInterface
public interface ITurn<L, R> {
	
	public void doMovement(Ship<L,R> ship,int numberOrietntationTried) throws 
		OutOfLimitsException, CellPopulatedException,AllOrientationAreBusyException;
}
