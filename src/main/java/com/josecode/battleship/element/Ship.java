package com.josecode.battleship.element;

import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

import com.josecode.battleship.util.Orientation;
import com.josecode.battleship.util.ShipType;

public class Ship<L, R> extends Element {

	int longitude;
	Orientation orientation;
	Set<Pair<L,R>> position;
	Pair<L, R> positionStarting;
	
	public Ship(final int longitude, final ShipType shipType) {
		super();
		this.longitude = longitude;
		this.shipType = shipType;
		this.orientation = Orientation.N;
		this.position = new LinkedHashSet<>();
	}
	
	public Ship(){
		position = new LinkedHashSet<>();
	}
	
	public Set<Pair<L, R>> getPosition() {
		return position;
	}

	public void setPosition(Set<Pair<L, R>> position) {
		this.position = position;
	}
	
	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	
	public Pair<L, R> getPositionStarting() {
		return positionStarting;
	}

	public void setPositionStarting(Pair<L, R> positionStarting) {
		this.positionStarting = positionStarting;
	}
	
	public void inicializarPosition(){
		position = new LinkedHashSet<>();
	}
	
	public ShipType getShipType() {
		return shipType;
	}

	public void setShipType(ShipType shipType) {
		this.shipType = shipType;
	}
}
