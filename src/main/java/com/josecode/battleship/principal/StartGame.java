package com.josecode.battleship.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.josecode.battleship.board.Board;
import com.josecode.battleship.board.BuildWorld;
import com.josecode.battleship.element.Ship;
import com.josecode.battleship.util.ShipType;

public class StartGame {
     
	private StartGame(){}
	
	public static <L, R> void main(String[] args) {
       Board<L, R> board = new Board<>(10);
       BuildWorld<L, R> build = new BuildWorld<>();

       ParametersInitial p = new ParametersInitial("P", 5);
       ParametersInitial p1 = new ParametersInitial("A", 4);
       ParametersInitial p2 = new ParametersInitial("S", 3);
       ParametersInitial p3 = new ParametersInitial("D", 3);
       ParametersInitial p4 = new ParametersInitial("B", 2);
   
       List<ParametersInitial> list = new ArrayList<>();
       list.add(p);
       list.add(p1);
       list.add(p2);
       list.add(p3);
       list.add(p4);
       List<Ship<L, R>> listShip = new ArrayList<>();
       
       for (ParametersInitial parameter : list) {
    	   Ship<L, R> ship = new Ship<>(parameter.getLength(),ShipType.getEnum(parameter.getCodeShip()),
    			   parameter.getCodeShip());
    	   listShip.add(ship);
       }
       build.createWorld(board, listShip);
       Ship<L, R> ship = new Ship<>();
       ship.getObservable().addObserver(board);
       Scanner entradaEscaner = new Scanner (System.in);
       askNumber(board,entradaEscaner);
       
	}

	private static <L,R> void askNumber(Board<L,R> board,Scanner entradaEscaner) {
		   System.out.println ("Please introduce a value for X between 0-9:");
		   String entradaX = entradaEscaner.nextLine ();
	       System.out.println ("Please introduce a value for Y between 0-9:");
	       String entradaY = entradaEscaner.nextLine ();

	       board.checkSpecificCell(Integer.valueOf(entradaX),Integer.valueOf(entradaY));
	       board.printBoard();

	       askNumber(board,entradaEscaner);
	}
	
}
