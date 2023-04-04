package com.hifumi123.ca4j;

public class CellularAutomata {

	private Rule rule;

	private int maxStep;

	private int currentStep;

	public CellularAutomata() {
		resetStep();
	}

	public void resetStep() {
		currentStep = 0;
	}

	public Grid run(Grid grid) {
		for (int i = 0; i < maxStep; i++)
			grid = runOneStep(grid);

		return grid;
	}

	public Grid runOneStep(Grid grid) {
		Grid newGrid = null;

		try {
			newGrid = (Grid) grid.clone();

			for (int y = 0; y < grid.getHeight(); y++)
				for (int x = 0; x < grid.getWidth(); x++) {
					Cell newCell = (Cell) grid.getCell(x, y).clone();

					rule.changeCellState(newCell, grid, x, y);

					newGrid.setCell(x, y, newCell);
				}

			currentStep++;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return newGrid;
	}

	public int getCurrentStep() {
		return currentStep;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public void setMaxStep(int maxStep) {
		this.maxStep = maxStep;
	}
}
