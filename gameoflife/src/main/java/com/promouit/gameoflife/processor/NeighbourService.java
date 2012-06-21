package com.promouit.gameoflife.processor;

import java.util.ArrayList;
import java.util.List;

import com.promouit.gameoflife.model.Cell;
import com.promouit.gameoflife.model.Neighbours;

public class NeighbourService {
	public void makeNeighbourAware(Cell[][] allCells) {
		for (int i = 0; i < allCells.length; i++) {
			for (int j = 0; j < allCells[i].length; j++) {
				Cell currentCell = allCells[i][j];
				List<Cell> neighbourCells = new ArrayList<Cell>();
				if (i > 0) {
					neighbourCells.add(allCells[i - 1][j]);
					if (j > 0)
						neighbourCells.add(allCells[i - 1][j - 1]);
					if (j < allCells[i].length - 1)
						neighbourCells.add(allCells[i - 1][j + 1]);
				}
				if (j > 0)
					neighbourCells.add(allCells[i][j - 1]);
				if (j < allCells[i].length - 1)
					neighbourCells.add(allCells[i][j + 1]);

				if (i < allCells.length - 1) {
					neighbourCells.add(allCells[i + 1][j]);
					if (j > 0)
						neighbourCells.add(allCells[i + 1][j - 1]);
					if (j < allCells[i].length - 1)
						neighbourCells.add(allCells[i + 1][j + 1]);
				}
				Neighbours neighbours = new Neighbours(neighbourCells);
				currentCell.populateNeighbours(neighbours);
			}
		}
	}
}
