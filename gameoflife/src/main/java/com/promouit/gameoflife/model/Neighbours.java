package com.promouit.gameoflife.model;

import java.util.Arrays;
import java.util.List;

public class Neighbours {
	private List<Cell> neighbouringCells = null;

	public Neighbours(Cell... cells) {
		neighbouringCells = Arrays.asList(cells);
	}

	public Neighbours(List<Cell> neighbourCells) {
		this.neighbouringCells = neighbourCells;
	}

	public List<Cell> getNeighbouringCells() {
		return neighbouringCells;
	}
	
	public int getNumberOfActiveNeighbors() {
		int activeCount = 0;
		for (Cell neighbour : neighbouringCells) {
			if (neighbour != null && neighbour.isAlive())
				activeCount++;
		}
		return activeCount;
	}
}
