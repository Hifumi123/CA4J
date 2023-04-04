package com.hifumi123.ca4j;

public class Grid implements Cloneable {

	private int width;
	
	private int height;
	
	private Cell[][] cells;

	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		
		cells = new Cell[height][];
		for (int i = 0; i < cells.length; i++) {
			Cell[] array = new Cell[width];
			cells[i] = array;
		}
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public Cell getCell(int x, int y) {
		return cells[y][x];
	}
	
	public void setCell(int x, int y, Cell cell) {
		cells[y][x] = cell;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Grid g = (Grid) super.clone();
		g.cells = new Cell[height][];
		for (int y = 0; y < height; y++) {
			g.cells[y] = new Cell[width];
			
			for (int x = 0; x < width; x++)
				g.cells[y][x] = (Cell) cells[y][x].clone();
		}
		
		return g;
	}
	
	public boolean inGrid(int x, int y) {
		return x >= 0 && x < width && y >= 0 && y < height;
	}
}
