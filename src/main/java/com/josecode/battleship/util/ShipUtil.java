package com.josecode.battleship.util;

import org.apache.commons.lang3.tuple.Pair;

import com.josecode.battleship.board.Board;
import com.josecode.battleship.board.Cell;
import com.josecode.battleship.element.Element;
import com.josecode.battleship.element.Ship;

public class ShipUtil {
    
	private static final String CODE_EMPTY = "~";
	private static final String CODE_SHIP_HIT = "X";
	
	private ShipUtil(){}
	
	public static <L, R> void checkPointsShip(Ship<L,R> ship,Board<L,R> board){
          System.out.println("hit"+ship.getPosition().stream().allMatch(s->isShipHit(s, board)));
          final boolean isAllHit = ship.getPosition().stream().allMatch( s -> isShipHit(s, board));
          if (isAllHit) {
        	  changeShipsSunked(ship, board);
          }
	}
	
	private static <L, R> boolean isShipHit(Pair<L,R> pair,Board<L,R> board) {
		Cell cell = board.getSpecificCell(Util.getLeft(pair), Util.getRight(pair));
		return ((Ship<L,R>)cell.getElement()).isHit();
	}
	
	
	private static <L, R> void changeShipsSunked(Ship<L,R> ship,Board<L,R> board) {
		ship.getPosition().stream().forEach( s -> {
			Cell cell = board.getSpecificCell(Util.getLeft(s), Util.getRight(s));
			 ((Ship<L,R>)cell.getElement()).setSunked(true);
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
}
