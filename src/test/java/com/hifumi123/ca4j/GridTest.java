package com.hifumi123.ca4j;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GridTest {
	
	private Grid grid;

	@BeforeEach
	public void init() {
		int width = 5, height = 4;
		
		grid = new Grid(width, height);
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int state = (y * width + x) % 2;
				Tile t = new Tile(state);
				grid.setCell(x, y, t);
			}
		}
	}
	
	@AfterEach
	public void over() {
		grid = null;
	}
	
	@Test
	public void cloneTest() {
		try {
			Grid newGrid = (Grid) grid.clone();
			
			Assertions.assertEquals(false, grid == newGrid);
			Assertions.assertEquals(true, grid.getWidth() == newGrid.getWidth());
			Assertions.assertEquals(true, grid.getHeight() == newGrid.getHeight());
			
			for (int y = 0; y < grid.getHeight(); y++)
				for (int x = 0; x < grid.getWidth(); x++) {
					Cell c1 = grid.getCell(x, y);
					Cell c2 = newGrid.getCell(x, y);
					
					Assertions.assertEquals(false, c1 == c2);
					Assertions.assertEquals(true, c1.getState() == c2.getState());
				}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	@ParameterizedTest
	@MethodSource
	public void inGridTest(int[] xs, int[] ys, boolean[] result) {
		for (int i = 0; i < result.length; i++)
			Assertions.assertEquals(result[i], grid.inGrid(xs[i], ys[i]));
	}
	
	public static Stream<Arguments> inGridTest() {
		int[] xs = {3, 9, 8, 0, 1, 6, 2};
		int[] ys = {8, 4, 6, 9, 5, 1, 0};
		
		boolean[] result = {false, false, false, false, false, false, true};
		
		return Stream.of(Arguments.of(xs, ys, result));
	}
}
