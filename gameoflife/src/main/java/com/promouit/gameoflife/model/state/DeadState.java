package com.promouit.gameoflife.model.state;

public class DeadState implements State {

	@Override
	public String toString() {
		return StateFactory.DEAD;
	}

	public State getNextState(CellContext cellContext) {
		int numberOfActiveNeighbors = cellContext.getNeighbours()
				.getNumberOfActiveNeighbors();
		if (numberOfActiveNeighbors == 3)
			return StateFactory.getState(StateFactory.ALIVE);
		return StateFactory.getState(StateFactory.DEAD);
	}

}
