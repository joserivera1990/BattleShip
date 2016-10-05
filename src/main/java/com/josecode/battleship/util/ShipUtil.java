package com.josecode.battleship.util;

import java.util.Random;

import org.apache.commons.lang3.tuple.Pair;

import com.josecode.battleship.board.Board;
import com.josecode.battleship.board.Cell;
import com.josecode.battleship.element.Element;
import com.josecode.battleship.element.Ship;

public class ShipUtil {
    
	private static final String CODE_EMPTY = "~";
	private static final String CODE_SHIP_HIT = "X";
	private static final String CODES_ORIENTATION = "NSWE";
	
	private ShipUtil(){}
	
	public static void checkPointsShip(Ship ship,Board board){
          final boolean isAllHit = ship.getPosition().stream().allMatch( s -> isShipHit(s, board));
          if (isAllHit) {
        	  changeShipsSunked(ship, board);
          }
	}
	
	private static boolean isShipHit(Pair<Integer,Integer> pair,Board board) {
		Cell cell = board.getSpecificCell(Util.getLeft(pair), Util.getRight(pair));
		return ((Ship)cell.getElement()).isHit();
	}
	
	private static void changeShipsSunked(Ship ship,Board board) {
		ship.getPosition().stream().forEach( s -> {
			Cell cell = board.getSpecificCell(Util.getLeft(s), Util.getRight(s));
			 ((Ship)cell.getElement()).setSunked(true);
		});
	}
	
	public static String returnCodePrint(Element element) {
		if (element instanceof Ship) {
        	if (((Ship) element).isSunked()) {
        		return element.getCode();
        	} else if (((Ship) element).isHit()) {
        		return CODE_SHIP_HIT;
        	} 
        	return CODE_EMPTY;        	
        } else {
        	return element.getCode();
        } 
	}
	
	public static Orientation getRandomOrientation() {
		Random r = new Random();
		char orientationRandom = CODES_ORIENTATION.charAt(r.nextInt(CODES_ORIENTATION.length()));
	    return Orientation.getEnum(String.valueOf(orientationRandom));
	}
}
