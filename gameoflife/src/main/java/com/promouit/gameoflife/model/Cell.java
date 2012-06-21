package com.promouit.gameoflife.model;

import com.promouit.gameoflife.model.state.AliveState;
import com.promouit.gameoflife.model.state.CellContext;
import com.promouit.gameoflife.model.state.StateFactory;

public class Cell implements TickObserver {

	private CellContext context;

	private Cell(CellContext context) {
		this.context = context;
	}

	public boolean isAlive() {
		return context.getCurrentState() instanceof AliveState;
	}

	public void populateNeighbours(Neighbours neighbours) {
		context.setNeighbours(neighbours);
	}
	
	public Neighbours getNeighbours() {
		return context.getNeighbours();
	}

	@Override
	public String toString() {
		return context.getCurrentState().toString();
	}

	public void prepareNextState() {
		context.prepareNextState();
	}

	public void moveToNextState() {
		context.moveToNextState();
	}
	
	public static class CellBuilder {
		private String stateStr;

		public CellBuilder setState(String stateStr) {
			this.stateStr = stateStr;
			return this;
		}

		public Cell build() {
			if (stateStr == null)
				throw new IllegalArgumentException();
			return new Cell(new CellContext(StateFactory.getState(stateStr)));
		}
	}
}
