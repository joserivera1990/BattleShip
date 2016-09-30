package com.josecode.battleship.util;

public enum ShipType {
	PORTAAVIONES ("P"),
	ACORAZADO("A"),
	SUBMARINO("S"),
	DESTRUCTOR("D"),
	BOTE("B");
	
	private ShipType(String id) {
		this.id = id;
	}

	private String id;
	
	public String getId() {
		return id;
	}
	
	public static ShipType getEnum(String id) {
		for (ShipType value : ShipType.values()) {
			if (value.id.equals(id)) {
				return value;
			}
		}	
		throw new AssertionError("Value: "+id + " no exist");
		
	}
}


