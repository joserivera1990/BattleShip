package com.josecode.battleship.exception;

public class CellPopulatedException extends Exception {
    
	private static final long serialVersionUID = -3041729800418727313L;

	public CellPopulatedException(String msg) {
    	super(msg);
    }
}