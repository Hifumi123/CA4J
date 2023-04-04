package com.hifumi123.ca4j;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CellularAutomataTest {

	@Test
	public void runOneStepTest() {
		int width = 3, height = 3;
		int liveState = 1, deadState = 0;

		Grid g = new Grid(width, height);
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int state = deadState;
				if (y == 1 || (y == 2 && x == 1))
					state = liveState;

				g.setCell(x, y, new Tile(state));
			}
		}

		Rule r = new SimpleRule(liveState, deadState);

		CellularAutomata ca = new CellularAutomata();
		ca.setRule(r);

		Grid result = ca.runOneStep(g);

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if ((y == 1 && x == 1) || (y == 2 && x == 0) || (y == 2 && x == 2))
					Assertions.assertEquals(liveState, result.getCell(x, y).getState());
				else
					Assertions.assertEquals(deadState, result.getCell(x, y).getState());
			}
		}
	}
}
