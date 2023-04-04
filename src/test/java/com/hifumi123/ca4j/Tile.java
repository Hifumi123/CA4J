package com.hifumi123.ca4j;

public class Tile implements Cell {
	
	private int state;

	public Tile(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
