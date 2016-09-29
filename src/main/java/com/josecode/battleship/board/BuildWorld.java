package com.josecode.battleship.board;


import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.CellPopulatedException;
import com.josecode.battleship.exception.OutOfLimitsException;
import com.josecode.battleship.movement.Ahead;
import com.josecode.battleship.movement.IMovement;
import com.josecode.battleship.movement.Right;
import com.josecode.battleship.util.Orientation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

public class BuildWorld<L,R> {

	/*public void createShip(Board board, String parameters) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				board.addCell(new Cell(i, j, new EmptyCell()));
			}
		}	
	}*/
	
	public static <L, R> void main(String[] args) {
		// TODO Auto-generated method stub
		 Random rnd = new Random();
		String test = "A,4";
		//System.out.println((int) (Math.random() * 10) + 1);
		//System.out.println((int) (Math.random() * 10) + 1);
		
		
		Set<Cell> setCells = new HashSet<>();
		Board board = new Board(10);
		Integer n = 1;
		Integer n1 = 2;
	    Pair<L, R> positionStarting = (Pair<L, R>) Pair.of(n, n1);
	             
	    //System.out.println(positionStarting.getLeft());
	    //System.out.println(positionStarting.getRight());
	    Pair<L, R> positionStarting1 = (Pair<L, R>) Pair.of(n, n1);

	    
	    Set<Pair<L, R>> setPair = new LinkedHashSet<>();
	    setPair.add(positionStarting);
	    setPair.add(positionStarting1);
		Ship<L, R> ship = new Ship<>();
		ship.setPosition(setPair);
				
		
		
		/*for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Cell cell = new Cell(i, j,null, "N");
				board.addCell(i, j, cell);
				setCells.add(cell);
			}
		}*/
		
		//setCells.c
		Board board1 = new Board<L, R>(10);
		new BuildWorld<>().buildShipInitial(5,board1,9,7,0);
		new BuildWorld<>().buildShipInitial(4,board1,5,6,0);
		new BuildWorld<>().buildShipInitial(7,board1,4,4,0);
		/*new BuildWorld<>().buildShipInitial(5,board1);
		new BuildWorld<>().buildShipInitial(7,board1);
		new BuildWorld<>().buildShipInitial(9,board1);
		new BuildWorld<>().buildShipInitial(5,board1);
		new BuildWorld<>().buildShipInitial(4,board1);
		new BuildWorld<>().buildShipInitial(7,board1);
		new BuildWorld<>().buildShipInitial(5,board1);
		new BuildWorld<>().buildShipInitial(7,board1);
		new BuildWorld<>().buildShipInitial(9,board1);*/
		//board.printBoard();
	}
	
	public  void buildShipInitial(int lenghtBoard,Board board,int x,int y,int numberTimes) {
		//x = (int) (Math.random() * 9) + 1;
		//y = (int) (Math.random() * 9) + 1;
		System.out.println(x);
		System.out.println(y);
		Pair<L, R> positionStarting = (Pair<L, R>) Pair.of(x, y);
		Ship<L, R> ship = new Ship<>();
		ship.setPositionStarting(positionStarting);
		ship.setLongitude(10);
		List<IMovement<L, R>> listMovement = new ArrayList<>();
		for (int i = 0; i < lenghtBoard-1; i++) {
			IMovement<L, R> movement = new Ahead<>();
			listMovement.add(movement);
		}
		boolean successful = goOverMovements(listMovement,ship,board,numberTimes);
		if (!successful){
			numberTimes++;
			System.out.println("repeat"+numberTimes);
			if (numberTimes == 10) {
				throw new AssertionError("Ship without orientation");
			}
			buildShipInitial(lenghtBoard, board,0,0,numberTimes);
		}else {
			board.getCellsAdded().addAll(ship.getPosition());
			System.out.println(ship.getPosition());
		}

	}
	
	public boolean goOverMovements(List<IMovement<L, R>> listMovement,Ship<L, R> ship,Board board,int numberTimes) {
		try {
			IMovement<L, R> movement = new Right<>();
	    	movement.doMovement(ship,board);
			for (IMovement<L, R> iMovement : listMovement) {
				iMovement.doMovement(ship,board);
			}
			return true;
		} catch (OutOfLimitsException | CellPopulatedException e) {
            if (!ship.getOrientation().equals(Orientation.W)) {
            	ship.inicializarPosition();
            	goOverMovements(listMovement, ship,board,numberTimes);            	
            } else {
            	return false;
            }
		}
		return false;
		
	}
	
}
