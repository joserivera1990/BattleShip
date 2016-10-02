package com.josecode.battleship.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.tuple.Pair;

import com.josecode.battleship.principal.ParametersInitial;

public class Util {
	
	private Util(){}
	
	public static int getRandomNumber(int maxNumber) {
		return (int) (Math.random() * maxNumber-1) + 1;
	}
    
	public static <L, R> int getLeft(Pair<L, R> lastPosition) {
		return (int) lastPosition.getLeft();
	}
	
	public static <L, R> int getRight(Pair<L, R> lastPosition) {
		return (int) lastPosition.getRight();
	}
	
	public static String getNumberX(Scanner entradaEscaner) {
		System.out.println ("Please introduce a value for X between 0-9:");
	    String entradaX = entradaEscaner.nextLine ();
	    if (!validateNumber(entradaX)) {
		   return getNumberX(entradaEscaner); 
	    }
	    return entradaX;
	}
	
	public static String getNumberY(Scanner entradaEscaner) {
		System.out.println ("Please introduce a value for Y between 0-9:");
	    String entradaY = entradaEscaner.nextLine ();
	    if (!validateNumber(entradaY)) {
		   return getNumberY(entradaEscaner); 
	    }
	    return entradaY;
	}
	
	private static boolean validateNumber(String dataTyped) {
		return NumberUtils.isNumber(dataTyped);
	}
	
	public static List<ParametersInitial> getParameters(String[] parameters) {
	       List<ParametersInitial> list = new ArrayList<>();
	       Arrays.stream(parameters).forEach( p -> list
	    		 .add(new ParametersInitial(p.split(",")[0],Integer.valueOf(p.split(",")[1].trim())))
	       );
	       return list;
	}
	
}
