package com.josecode.battleship.util;

public enum Orientation {
	N("N"),
	S("S"),
	W("W"),
	E("E");
	
	private Orientation(String id) {
		this.id = id;
	}
	
	private String id;
	
	public String getId() {
		return id;
	}
	
	public static Orientation getEnum(String id) {
		for (Orientation value : Orientation.values()) {
			if (value.id.equals(id)) {
				return value;
			}
		}	
		throw new AssertionError("Value orientation: "+id + " no exist");
		
	}
}
