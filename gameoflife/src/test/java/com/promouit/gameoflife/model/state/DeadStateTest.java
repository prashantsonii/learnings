package com.promouit.gameoflife.model.state;

import static org.junit.Assert.*;

import org.junit.Test;

import com.promouit.gameoflife.model.Cell;
import com.promouit.gameoflife.model.Neighbours;
import com.promouit.gameoflife.model.Cell.CellBuilder;

public class DeadStateTest {

	@Test
	public void shouldBecomeAliveWithThreeAliveNeighbors() {
		CellContext cellContext = createCellContextWithDeadState(3);
		cellContext.prepareNextState();
		cellContext.moveToNextState();
		assertEquals(StateFactory.getState(StateFactory.ALIVE), cellContext.getCurrentState());
	}
	
	@Test
	public void shouldRemainDead() {
		CellContext cellContext = createCellContextWithDeadState(2);
		cellContext.prepareNextState();
		cellContext.moveToNextState();
		assertEquals(StateFactory.getState(StateFactory.DEAD), cellContext.getCurrentState());
	}

	@Test
	public void shouldRemainDead2() {
		CellContext cellContext = createCellContextWithDeadState(4);
		cellContext.prepareNextState();
		cellContext.moveToNextState();
		assertEquals(StateFactory.getState(StateFactory.DEAD), cellContext.getCurrentState());
	}
	
	private CellContext createCellContextWithDeadState(int activeNeighbours) {
		CellContext cellContext = new CellContext(StateFactory.getState("-"));
		Cell[] cells = getNeighbouringCells(activeNeighbours);
		Neighbours neighbours = new Neighbours(cells);
		cellContext.setNeighbours(neighbours);
		return cellContext;
	}

	private Cell[] getNeighbouringCells(int activeNeighbours) {
		Cell[] cells = new Cell[8];
		for(int i = 0; i<8; i++){
			CellBuilder builder = new CellBuilder();
			if(activeNeighbours > 0)
				builder.setState(StateFactory.ALIVE);
			else
				builder.setState(StateFactory.DEAD);
			cells[i] = builder.build();
			activeNeighbours--;
		}
		return cells;
	}

}
