package com.promouit.gameoflife.processor;

import java.util.Arrays;
import java.util.List;

import com.promouit.gameoflife.model.Cell;
import com.promouit.gameoflife.model.Cell.CellBuilder;
import com.promouit.gameoflife.model.state.StateFactory;

public class CellLifeCycler {

	public Cell[][] expandToPeriphalDeadCells(Cell[][] allCells) {
		int numRows = allCells.length;
		int numCols = allCells[0].length;
		if (numCols != numRows) {
			numRows = numCols = Math.max(numCols, numRows);
		}
		numRows = (numCols += 2);
		int upperDeadCells = 0;
		int lowerDeadCells = 0;
		int leftDeadCells = 0;
		int rightDeadCells = 0;
		upperDeadCells = lowerDeadCells = (numRows - allCells.length) / 2;
		leftDeadCells = rightDeadCells = (numCols - allCells[0].length) / 2;

		Cell[][] allNewCells = new Cell[numRows][numCols];

		int currentRow = 0;

		for (int i = 0; i < upperDeadCells; i++, currentRow++)
			for (int j = 0; j < allNewCells[i].length; j++)
				allNewCells[currentRow][j] = createCell(StateFactory.DEAD);

		for (Cell[] cells : allCells) {
			int currentCol = 0;
			for (int j = 0; j < leftDeadCells; j++, currentCol++)
				allNewCells[currentRow][currentCol] = createCell(StateFactory.DEAD);

			for (Cell cell : cells) {
				allNewCells[currentRow][currentCol] = cell;
				currentCol++;
			}
			for (int j = 0; j < rightDeadCells; j++, currentCol++)
				allNewCells[currentRow][currentCol] = createCell(StateFactory.DEAD);

			currentRow++;
		}

		for (int i = 0; i < lowerDeadCells; i++, currentRow++)
			for (int j = 0; j < allNewCells[i].length; j++)
				allNewCells[currentRow][j] = createCell(StateFactory.DEAD);
		return allNewCells;
	}

	private Cell createCell(String cellState) {
		CellBuilder cellBuilder = new CellBuilder();
		return cellBuilder.setState(cellState).build();
	}

	public Cell[][] contractToLiveCells(Cell[][] allCells) {
		boolean trimTop = allDead(Arrays.asList(allCells[0]));
		boolean trimBottom = allDead(Arrays
				.asList(allCells[allCells.length - 1]));
		boolean trimLeft = true;
		boolean trimRight = true;
		for (int j = 0; j < allCells.length; j++) {
			if (allCells[j][0].isAlive())
				trimLeft = false;
			if (allCells[j][allCells[j].length - 1].isAlive())
				trimRight = false;
		}

		int topRow = 0;
		int bottomRow = allCells.length - 1;
		int leftCol = 0;
		int rightCol = allCells[0].length - 1;

		if (trimTop)
			topRow++;
		if (trimBottom)
			bottomRow--;
		if (trimLeft)
			leftCol++;
		if (trimRight)
			rightCol--;

		Cell[][] trimmedCells = new Cell[bottomRow - topRow + 1][rightCol
				- leftCol + 1];
		for (int i = topRow, i1 = 0; i <= bottomRow; i++, i1++) {
			for (int j = leftCol, j1 = 0; j <= rightCol; j++, j1++) {
				trimmedCells[i1][j1] = allCells[i][j];
			}
		}
		return trimmedCells;
	}

	public void updateCellState(Cell[][] allCells){
		for (Cell[] cells : allCells) {
			for (Cell cell : cells)
				cell.prepareNextState();
		}
		for (Cell[] cells : allCells) {
			for (Cell cell : cells)
				cell.moveToNextState();
		}
	}
	
	boolean allDead(List<Cell> cells) {
		for (Cell cell : cells) {
			if (cell.isAlive())
				return false;
		}
		return true;
	}
}
