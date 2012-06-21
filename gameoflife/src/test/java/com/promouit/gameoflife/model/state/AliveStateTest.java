package com.promouit.gameoflife.model.state;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.promouit.gameoflife.model.Cell;
import com.promouit.gameoflife.model.Cell.CellBuilder;
import com.promouit.gameoflife.model.Neighbours;

public class AliveStateTest {

	@Test
	public void shouldGoDeadByLonliness() {
		CellContext cellContext = createCellContextWithAliveState(1);
		cellContext.prepareNextState();
		cellContext.moveToNextState();
		assertEquals(StateFactory.getState(StateFactory.DEAD), cellContext.getCurrentState());
	}

	@Test
	public void shouldGoDeadByOverCrowding() {
		CellContext cellContext = createCellContextWithAliveState(4);
		cellContext.prepareNextState();
		cellContext.moveToNextState();
		assertEquals(StateFactory.getState(StateFactory.DEAD), cellContext.getCurrentState());
	}
	
	@Test
	public void shouldRemainAliveForTwoAliveNeighbors() {
		CellContext cellContext = createCellContextWithAliveState(2);
		cellContext.prepareNextState();
		cellContext.moveToNextState();
		assertEquals(StateFactory.getState(StateFactory.ALIVE), cellContext.getCurrentState());

	}
	
	@Test
	public void shouldRemainAliveForThreeAliveNeighbors() {
		CellContext cellContext = createCellContextWithAliveState(3);
		cellContext.prepareNextState();
		cellContext.moveToNextState();
		assertEquals(StateFactory.getState(StateFactory.ALIVE), cellContext.getCurrentState());

	}
	
	private CellContext createCellContextWithAliveState(int activeNeighbours) {
		CellContext cellContext = new CellContext(StateFactory.getState("X"));
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
