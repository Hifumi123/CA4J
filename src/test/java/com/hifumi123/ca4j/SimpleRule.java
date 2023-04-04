package com.hifumi123.ca4j;

public class SimpleRule implements Rule {
	
	private int liveState;
	
	private int deadState;

	public SimpleRule(int liveState, int deadState) {
		this.liveState = liveState;
		this.deadState = deadState;
	}

	@Override
	public void changeCellState(Cell newCell, Grid grid, int x, int y) {
		int count = 0;
		
		int nx = x - 1, ny = y;
		if (isLiveState(grid, nx, ny))
			count++;
		
		nx = x + 1;
		ny = y;
		if (isLiveState(grid, nx, ny))
			count++;
		
		nx = x;
		ny = y - 1;
		if (isLiveState(grid, nx, ny))
			count++;
		
		nx = x;
		ny = y + 1;
		if (isLiveState(grid, nx, ny))
			count++;
		
		if (newCell.getState() == liveState && count < 2)
			newCell.setState(deadState);
		else if (newCell.getState() == deadState && count >= 2)
			newCell.setState(liveState);
	}
	
	private boolean isLiveState(Grid grid, int x, int y) {
		return grid.inGrid(x, y) && grid.getCell(x, y).getState() == liveState;
	}
}
