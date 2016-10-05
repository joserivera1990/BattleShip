package com.josecode.battleship.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.josecode.battleship.board.Board;
import com.josecode.battleship.board.BuildWorld;
import com.josecode.battleship.element.Ship;
import com.josecode.battleship.read.ReadProperties;
import com.josecode.battleship.util.ShipType;
import com.josecode.battleship.util.Util;

public class StartGame {
     
	private StartGame(){}
	
	public static  void main(String[] args) {
       
       BuildWorld build = new BuildWorld();
       ReadProperties readProperties = new ReadProperties();
       String[] parameters = readProperties.getFileWithUtil("battleship.properties");
       List<ParametersInitial> listParameters = Util.getParameters(parameters);
       parameters = readProperties.getFileWithUtil("board.properties");
       Board board = new Board(Integer.valueOf(parameters[0]));
       List<Ship> listShip = buildListShip(listParameters);
       build.createWorld(board, listShip);
       Ship.getObservable().addObserver(board);
       Scanner entradaEscaner = new Scanner(System.in);
       askNumber(board,entradaEscaner);
       
	}
    
	private static List<Ship> buildListShip(List<ParametersInitial> listParameters) {
		List<Ship> listShip = new ArrayList<>();
		for (ParametersInitial parameter : listParameters) {
    	   Ship ship = new Ship(parameter.getLength(),ShipType.getEnum(parameter.getCodeShip()),
    			   parameter.getCodeShip());
    	   listShip.add(ship);
       }
		return listShip;
	}
	
	private static void askNumber(Board board,Scanner entradaEscaner) {
		String x = Util.getNumberX(entradaEscaner,board.getLength());
		String y = Util.getNumberY(entradaEscaner,board.getLength());
	    board.checkSpecificCell(Integer.valueOf(x),Integer.valueOf(y));
	    board.printBoard();
	    askNumber(board,entradaEscaner);
	}
	
}
