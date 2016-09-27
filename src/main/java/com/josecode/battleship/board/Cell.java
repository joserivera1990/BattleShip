package com.josecode.battleship.board;

import com.josecode.battleship.element.Element;

public class Cell {
   
	private int positionX;
	private int positionY;
	private String code;
	private Element element;
	
	public Cell(final int positionX, final int positionY,final Element element, final String code) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.element = element;
		this.code = code;
	}
	
	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public Element getElement() {
		return element;
	}

	@Override
	public String toString() {
		return "Cell [element=" + element + "]";
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
