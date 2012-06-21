package com.promouit.gameoflife.processor;

import static org.junit.Assert.*;

import org.junit.Test;

import com.promouit.gameoflife.model.Cell;
import com.promouit.gameoflife.model.Cell.CellBuilder;
import com.promouit.gameoflife.model.state.StateFactory;
import com.promouit.gameoflife.processor.NeighbourService;

public class NeighbourServiceTest {

	@Test
	public void test() {
		Cell[][] allCells = getAllCells();
		NeighbourService neighbourizer = new NeighbourService();
		for(Cell[] cells : allCells){
			for(Cell cell : cells){
				assertNull(cell.getNeighbours());
			}
		}
		neighbourizer.makeNeighbourAware(allCells);
		for(Cell[] cells : allCells){
			for(Cell cell : cells){
				assertNotNull(cell.getNeighbours());
			}
		}
		assertEquals(3, allCells[0][0].getNeighbours().getNeighbouringCells().size());
		assertEquals(3, allCells[0][allCells[0].length-1].getNeighbours().getNeighbouringCells().size());
		assertEquals(3, allCells[allCells.length - 1][0].getNeighbours().getNeighbouringCells().size());
		assertEquals(3, allCells[allCells.length - 1][allCells[allCells.length - 1].length - 1].getNeighbours().getNeighbouringCells().size());
	}

	private Cell[][] getAllCells() {
		int count = 0;
		Cell[][] allCells = new Cell[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				count++;
				CellBuilder cellBuilder = new CellBuilder();
				allCells[i][j]= cellBuilder.setState(count%2==0?StateFactory.ALIVE:StateFactory.DEAD).build();
			}
		}
		return allCells;
	}

}
