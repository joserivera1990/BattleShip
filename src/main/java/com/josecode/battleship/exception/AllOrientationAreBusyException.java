package com.josecode.battleship.exception;

public class AllOrientationAreBusyException extends Exception {
	
	private static final long serialVersionUID = -8322811771739008622L;

	public AllOrientationAreBusyException(String msg) {
    	super(msg);
    }

}
