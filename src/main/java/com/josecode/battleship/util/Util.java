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
    
	public static int getLeft(Pair<Integer, Integer> lastPosition) {
		return (int) lastPosition.getLeft();
	}
	
	public static int getRight(Pair<Integer, Integer> lastPosition) {
		return (int) lastPosition.getRight();
	}
	
	public static String getNumberX(Scanner entradaEscaner,int lengthBoard) {
		System.out.println ("Please introduce a value for X between 0-9:");
	    String entradaX = entradaEscaner.nextLine ();
	    if (validateNumber(entradaX) && validateLongitudNumber(entradaX, lengthBoard)) {
		    return entradaX;	    	
	    }
	    return getNumberX(entradaEscaner,lengthBoard); 
	}
	
	public static String getNumberY(Scanner entradaEscaner,int lengthBoard) {
		System.out.println ("Please introduce a value for Y between 0-9:");
	    String entradaY = entradaEscaner.nextLine ();
	    if (validateNumber(entradaY) && validateLongitudNumber(entradaY, lengthBoard)) {
		   return entradaY; 
	    }
	    return getNumberY(entradaEscaner,lengthBoard); 
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
	
	private static boolean validateLongitudNumber(String number,int lengthBoard) {		
		if(lengthBoard > Integer.valueOf(number) && Integer.valueOf(number) >= 0){
			return true;
		}
		return false;
	}
	
}
