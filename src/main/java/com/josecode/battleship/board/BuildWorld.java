package com.josecode.battleship.board;


import com.josecode.battleship.element.Ship;
import com.josecode.battleship.exception.OutOfLimitsException;
import com.josecode.battleship.movement.Ahead;
import com.josecode.battleship.movement.IMovement;
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
		System.out.println((int) (Math.random() * 10) + 1);
		System.out.println((int) (Math.random() * 10) + 1);
		
		
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
				
		
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Cell cell = new Cell(i, j,null, "N");
				board.addCell(i, j, cell);
				setCells.add(cell);
			}
		}
		
		//setCells.c
		
		new BuildWorld<>().buildShipInitial("");
		//board.printBoard();
	}
	
	public  void buildShipInitial(String parameters) {
		int lenght = 2;
		Pair<L, R> positionStarting = (Pair<L, R>) Pair.of(3, 3);
		Set<Pair<L, R>> setPosition = new LinkedHashSet<>();
		setPosition.add(positionStarting);
		Ship<L, R> ship = new Ship<>();
		ship.setPosition(setPosition);
		ship.setOrientation(Orientation.N);
		List<IMovement<L, R>> listMovement = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			IMovement<L, R> movement = new Ahead<>();
			listMovement.add(movement);
		}
		goOverMovements(listMovement,ship);
	}
	
	public void goOverMovements(List<IMovement<L, R>> listMovement,Ship<L, R> ship) {
		for (IMovement<L, R> iMovement : listMovement) {
			try {
				iMovement.doMovement(ship);
			} catch (OutOfLimitsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(ship.getPosition());
	}
	
}
