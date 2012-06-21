package com.promouit.gameoflife.processor;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.promouit.gameoflife.model.Cell;
import com.promouit.gameoflife.model.Cell.CellBuilder;

public class CellLifeCyclerTest {

	private CellLifeCycler cycler = new CellLifeCycler();

	@Test
	public void shouldExpandToPeripheralDeads() {
		Cell[][] allCells = getCells(2, 2, false);
		allCells = cycler.expandToPeriphalDeadCells(allCells);
		assertEquals(4, allCells.length);
		for (Cell[] cells : allCells) {
			assertEquals(4, cells.length);
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				Cell cell = allCells[i][j];
				if (i == 0 || i == 3) {
					assertFalse(cell.isAlive());
				} else if (j == 0 || j == 3) {
					assertFalse(cell.isAlive());
				} else {
					assertTrue(cell.isAlive());
				}
			}
		}
	}

	@Test
	public void shouldContractToAliveCells() {
		Cell[][] allCells = getCells(2, 2, true);
		assertEquals(4, allCells.length);
		for (Cell[] cells : allCells) {
			assertEquals(4, cells.length);
		}
		allCells = cycler.contractToLiveCells(allCells);
		assertEquals(2, allCells.length);
		for (Cell[] cells : allCells) {
			assertEquals(2, cells.length);
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				Cell cell = allCells[i][j];
				assertTrue(cell.isAlive());
			}
		}
	}
	
	@Test
	public void testAllDeadCells() {
		List<Cell> cells = Arrays.asList(createCell("X"), createCell("X"), createCell("X"));
		assertFalse(cycler.allDead(cells));
		cells = Arrays.asList(createCell("-"), createCell("-"), createCell("X"));
		assertFalse(cycler.allDead(cells));
		cells = Arrays.asList(createCell("-"), createCell("-"), createCell("-"));
		assertTrue(cycler.allDead(cells));
	}

	private Cell[][] getCells(int rows, int cols, boolean peripheriLayer) {
		if (peripheriLayer) {
			rows += 2;
			cols += 2;
		}
		Cell[][] allCells = new Cell[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (peripheriLayer && (i == 0 || i == rows - 1))
					allCells[i][j] = createCell("-");
				else if (peripheriLayer && (j == 0 || j == cols - 1))
					allCells[i][j] = createCell("-");
				else
					allCells[i][j] = createCell("X");
			}
		}
		return allCells;
	}

	private Cell createCell(String cellState) {
		CellBuilder builder = new CellBuilder();
		return builder.setState(cellState).build();
	}

}
