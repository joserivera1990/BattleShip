package com.josecode.battleship.element;

import java.util.HashSet;
import java.util.Set;

import com.josecode.battleship.util.Orientation;
import com.josecode.battleship.util.Pair;
import com.josecode.battleship.util.ShipType;

public class Ship<R, L> implements Element {

	int cellStarting;
	int longitude;
	ShipType shipType;
	Orientation orientation;
	Set<Pair<L,R>> set = new HashSet<>();
	
	public Set<Pair<L, R>> getSet() {
		return set;
	}

	public void setSet(Set<Pair<L, R>> set) {
		this.set = set;
	}

	public Ship(final int cellStarting, final int longitude, final ShipType shipType,
			final Orientation orientation) {
		super();
		this.cellStarting = cellStarting;
		this.longitude = longitude;
		this.shipType = shipType;
		this.orientation = orientation;
	}
	
}
