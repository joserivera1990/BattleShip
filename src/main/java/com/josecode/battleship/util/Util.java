package com.josecode.battleship.util;

import org.apache.commons.lang3.tuple.Pair;

public class Util {
	
	private Util(){}
	
	public static int getRandomNumber(int maxNumber) {
		return (int) (Math.random() * maxNumber-1) + 1;
	}
    
	public static <L, R> int getLeft(Pair<L, R> lastPosition) {
		return (int) lastPosition.getLeft();
	}
	
	public static <L, R> int getRight(Pair<L, R> lastPosition) {
		return (int) lastPosition.getRight();
	}
}
