package com.josecode.battleship.board;

import com.josecode.battleship.element.Element;

public class Cell {
   
	private String code;
	private Element element;
	
	public Cell(final Element element) {
		this.element = element;
	}
	
	public Element getElement() {
		return element;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
