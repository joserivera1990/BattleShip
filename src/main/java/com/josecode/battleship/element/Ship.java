package com.josecode.battleship.element;

import java.util.LinkedHashSet;
import java.util.Observable;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

import com.josecode.battleship.util.Orientation;
import com.josecode.battleship.util.ShipType;
import com.josecode.battleship.util.ShipUtil;

public class Ship<L, R> extends Element {

	int longitude;
	Orientation orientation;
	Set<Pair<L,R>> position;
	Pair<L, R> positionStarting;
	ShipType shipType;
	boolean isSunked;
	boolean isHit;
	
	private static final ShipObservable OBSERVABLE;

	public Ship(final int longitude, final ShipType shipType,final String code) {
		super();
		this.longitude = longitude;
		this.shipType = shipType;
		this.orientation = ShipUtil.getRandomOrientation();
		this.position = new LinkedHashSet<>();
		this.code = code;
	}
	
	
	
	public Ship(Ship<L,R> another,Pair<L, R> lastPosition) {
		super();
		this.longitude = another.getLongitude();
		this.orientation = another.getOrientation();
		this.position = another.getPosition();
		this.positionStarting = lastPosition;
		this.shipType = another.getShipType();
		this.code = another.getCode();
	}



	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean isHit) {
		this.isHit = isHit;
		synchronized (OBSERVABLE) {
            OBSERVABLE.setChanged();
            OBSERVABLE.notifyObservers(this);            
        }
		
	}

	static {
        OBSERVABLE = new ShipObservable();
    }
	
	public static Observable getObservable() {
		return OBSERVABLE;
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
	
	public boolean isSunked() {
		return isSunked;
	}

	public void setSunked(boolean isSunked) {
		this.isSunked = isSunked;
	}
	
    private static class ShipObservable extends Observable {
        @Override
        public synchronized void setChanged() {
            super.setChanged();
        }
    }
}
