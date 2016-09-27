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
	
}


