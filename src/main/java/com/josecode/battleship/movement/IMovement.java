package com.josecode.battleship.movement;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.OutOfLimitsException;

public interface IMovement<L,R> {
	
	public void doMovement(Ship<L,R> ship) throws OutOfLimitsException;
    
	@SuppressWarnings("unchecked")
	default Pair<L, R> getLastStep(Set<Pair<L, R>> setPosition) {
		final Iterator itr = setPosition.iterator();
		Pair<L, R> lastPosition = (Pair<L, R>) itr.next();
		while (itr.hasNext()) {
			lastPosition =  (Pair<L, R>) itr.next();
		}
		return lastPosition;
	}
}
