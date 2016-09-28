package com.josecode.battleship.exception;

public class OutOfLimitsException extends Exception {
    
	private static final long serialVersionUID = -7627925363644171059L;

	public OutOfLimitsException(String msg) {
    	super(msg);
    }
}
