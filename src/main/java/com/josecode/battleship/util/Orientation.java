package com.josecode.battleship.util;

public enum Orientation {
	N,S,W,E;
	
	public static Orientation getEnum(String id) {
		return Enum.valueOf(Orientation.class, id);
	}
}
