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
	
	public static <L, R> void main(String[] args) {
       
       BuildWorld<L, R> build = new BuildWorld<>();
       ReadProperties readProperties = new ReadProperties();
       String[] parameters = readProperties.getFileWithUtil("battleship.properties");
       List<ParametersInitial> listParameters = Util.getParameters(parameters);
       parameters = readProperties.getFileWithUtil("board.properties");
       Board<L, R> board = new Board<>(Integer.valueOf(parameters[0]));
       List<Ship<L, R>> listShip = buildListShip(listParameters);
       build.createWorld(board, listShip);
       Ship<L, R> ship = new Ship<>();
       ship.getObservable().addObserver(board);
       Scanner entradaEscaner = new Scanner(System.in);
       askNumber(board,entradaEscaner);
       
	}
    
	private static <L, R> List<Ship<L, R>> buildListShip(List<ParametersInitial> listParameters) {
		List<Ship<L, R>> listShip = new ArrayList<>();
		for (ParametersInitial parameter : listParameters) {
    	   Ship<L, R> ship = new Ship<>(parameter.getLength(),ShipType.getEnum(parameter.getCodeShip()),
    			   parameter.getCodeShip());
    	   listShip.add(ship);
       }
		return listShip;
	}
	
	private static <L,R> void askNumber(Board<L,R> board,Scanner entradaEscaner) {
		String x = Util.getNumberX(entradaEscaner,board.getLength());
		String y = Util.getNumberY(entradaEscaner,board.getLength());
	    board.checkSpecificCell(Integer.valueOf(x),Integer.valueOf(y));
	    board.printBoard();
	    askNumber(board,entradaEscaner);
	}
	
}
