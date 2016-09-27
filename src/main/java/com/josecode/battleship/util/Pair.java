package com.josecode.battleship.util;

public class Pair<L,R> {
     private final L positionX;
     private final R positionY;
	
	public L getPositionX() {
		return positionX;
	}

	public R getPositionY() {
		return positionY;
	}

	public Pair(L positionX, R positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((positionX == null) ? 0 : positionX.hashCode());
		result = prime * result
				+ ((positionY == null) ? 0 : positionY.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (positionX == null) {
			if (other.positionX != null)
				return false;
		} else if (!positionX.equals(other.positionX))
			return false;
		if (positionY == null) {
			if (other.positionY != null)
				return false;
		} else if (!positionY.equals(other.positionY))
			return false;
		return true;
	}
     
}
