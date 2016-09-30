package com.josecode.battleship.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.josecode.battleship.board.Board;
import com.josecode.battleship.board.BuildWorld;
import com.josecode.battleship.element.Ship;
import com.josecode.battleship.observerpattern.ShipObserver;
import com.josecode.battleship.util.ShipType;

public class StartGame {

	public static <L, R> void main(String[] args) {
       Board<L, R> board = new Board<L, R>(10);
       BuildWorld<L, R> build = new BuildWorld<L, R>();

       ParametersInitial p = new ParametersInitial("P", 5);
       ParametersInitial p1 = new ParametersInitial("A", 4);
       ParametersInitial p2 = new ParametersInitial("S", 3);
       ParametersInitial p3 = new ParametersInitial("D", 3);
       ParametersInitial p4 = new ParametersInitial("B", 2);
      // ParametersInitial p5 = new ParametersInitial("P", 7);
       //ParametersInitial p6 = new ParametersInitial("B", 6);
       //ParametersInitial p7 = new ParametersInitial("A", 2);
       
       List<ParametersInitial> list = new ArrayList<>();
       list.add(p);
       list.add(p1);
       list.add(p2);
       list.add(p3);
       list.add(p4);
       //list.add(p5);
       //list.add(p6);
       //sslist.add(p7);
       List<Ship<L, R>> listShip = new ArrayList<>();
       
       for (ParametersInitial parameter : list) {
    	   Ship<L, R> ship = new Ship<L, R>(parameter.getLength(),ShipType.getEnum(parameter.getCodeShip()),
    			   parameter.getCodeShip());
    	   listShip.add(ship);
       }
       build.createWorld(board, listShip);
       System.out.println ("Please introduce a value for X between 0-9:");
       String entradaX = "";
       Scanner entradaEscaner = new Scanner (System.in);
       entradaX = entradaEscaner.nextLine ();
       System.out.println ("Please introduce a value for Y between 0-9:");
       String entradaY = "";
       entradaY = entradaEscaner.nextLine ();
       entradaEscaner.close();
       System.out.println(entradaX+"-"+entradaY);
       System.out.println();

       Ship<L, R> ship = new Ship<>();
       //ShipObserver observer = new ShipObserver();
       ship.getObservable().addObserver(board);
       board.checkSpecificCell(Integer.valueOf(entradaX),Integer.valueOf(entradaY));
       board.printBoard();
	}

}
