package com.josecode.battleship.observerpattern;

import java.util.Observable;
import java.util.Observer;

import com.josecode.battleship.element.Ship;
import com.josecode.battleship.util.ShipUtil;

public class ShipObserver implements Observer{
    
	@Override
    public void update(Observable observable, Object args) {
    	System.out.println("ingreso");
		if (args instanceof Ship) {
        	System.out.println("ingreso");
        	ShipUtil.checkPointsShip((Ship) args,null);
        }
    }
}
