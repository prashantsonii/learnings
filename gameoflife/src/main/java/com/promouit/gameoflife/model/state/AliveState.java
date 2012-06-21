package com.promouit.gameoflife.model.state;

public class AliveState implements State {

	@Override
	public String toString() {
		return StateFactory.ALIVE;
	}

	public State getNextState(CellContext cellContext) {
		int numberOfActiveNeighbors = cellContext.getNeighbours()
				.getNumberOfActiveNeighbors();
		if (numberOfActiveNeighbors >= 2 && numberOfActiveNeighbors <= 3)
			return StateFactory.getState(StateFactory.ALIVE);
		return StateFactory.getState(StateFactory.DEAD);
	}
}
