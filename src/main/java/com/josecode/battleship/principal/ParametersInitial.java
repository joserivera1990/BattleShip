package com.josecode.battleship.principal;

public class ParametersInitial {
    
	private final String codeShip;
    private final int length;
     
	public ParametersInitial(final String codeShip,final int length) {
		this.codeShip = codeShip;
		this.length = length;
	}
	
	public String getCodeShip() {
		return codeShip;
	}
	
	public int getLength() {
		return length;
	}
}
