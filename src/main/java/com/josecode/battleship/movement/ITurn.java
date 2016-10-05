package com.josecode.battleship.movement;

import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.AllOrientationAreBusyException;
import com.josecode.battleship.exception.CellPopulatedException;
import com.josecode.battleship.exception.OutOfLimitsException;

@FunctionalInterface
public interface ITurn {
	
	public void doMovement(Ship ship,int numberOrietntationTried) throws 
		OutOfLimitsException, CellPopulatedException,AllOrientationAreBusyException;
}
