package com.josecode.battleship.principal;

import java.util.ArrayList;
import java.util.List;

import com.josecode.battleship.board.Board;
import com.josecode.battleship.board.BuildWorld;
import com.josecode.battleship.board.Cell;
import com.josecode.battleship.element.Ship;
import com.josecode.battleship.util.ShipType;

public class StartGame {

	public static <L, R> void main(String[] args) {
       Board board = new Board(10);
       BuildWorld build = new BuildWorld();

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
    	   Ship<L, R> ship = new Ship<L, R>(parameter.getLength(),ShipType.getEnum(parameter.getCodeShip()));
    	   listShip.add(ship);
       }
       build.createWorld(board, listShip);
       
	}

}
