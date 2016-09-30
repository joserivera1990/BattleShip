package com.josecode.battleship.util;

import org.apache.commons.lang3.tuple.Pair;

import com.josecode.battleship.board.Board;
import com.josecode.battleship.board.Cell;
import com.josecode.battleship.element.Ship;

public class ShipUtil {
    
	public static <L, R> void checkPointsShip(Ship<L,R> ship,Board<L,R> board){
          System.out.println("red");
          System.out.println(ship.getPosition().stream().allMatch(s->isShipHit(s, board)));
          ship.getPosition().stream().allMatch( s -> isShipHit(s, board));
	}
	
	private static <L, R> boolean isShipHit(Pair<L,R> pair,Board<L,R> board) {
		Cell cell = board.getSpecificCell(Util.getLeft(pair), Util.getRight(pair));
		return ((Ship)cell.getElement()).isHit();
	}
}
