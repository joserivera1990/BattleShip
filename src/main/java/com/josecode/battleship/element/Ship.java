package com.josecode.battleship.element;

import java.util.LinkedHashSet;
import java.util.Observable;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

import com.josecode.battleship.util.Orientation;
import com.josecode.battleship.util.ShipType;
import com.josecode.battleship.util.ShipUtil;

public class Ship extends Element {

	private int longitude;
	private Orientation orientation;
	private Set<Pair<Integer,Integer>> position;
	private Pair<Integer, Integer> positionStarting;
	private ShipType shipType;
	private boolean isSunked;
	private boolean isHit;
	
	private static final ShipObservable OBSERVABLE;

	public Ship(final int longitude, final ShipType shipType,final String code) {
		super();
		this.longitude = longitude;
		this.shipType = shipType;
		this.orientation = ShipUtil.getRandomOrientation();
		this.position = new LinkedHashSet<>();
		this.code = code;
	}
	
	
	
	public Ship(Ship ship,Pair<Integer, Integer> lastPosition) {
		super();
		this.longitude = ship.getLongitude();
		this.orientation = ship.getOrientation();
		this.position = ship.getPosition();
		this.positionStarting = lastPosition;
		this.shipType = ship.getShipType();
		this.code = ship.getCode();
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
	
	public Set<Pair<Integer, Integer>> getPosition() {
		return position;
	}

	public void setPosition(Set<Pair<Integer, Integer>> position) {
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
	
	public Pair<Integer, Integer> getPositionStarting() {
		return positionStarting;
	}

	public void setPositionStarting(Pair<Integer, Integer> positionStarting) {
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
