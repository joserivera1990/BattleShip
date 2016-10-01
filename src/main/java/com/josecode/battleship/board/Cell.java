package com.josecode.battleship.board;

import com.josecode.battleship.element.Element;

public class Cell {
   
	private Element element;
	
	public Cell(final Element element) {
		this.element = element;
	}
	
	public Element getElement() {
		return element;
	}
	
}
