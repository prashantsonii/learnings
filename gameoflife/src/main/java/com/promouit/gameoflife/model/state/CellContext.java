package com.promouit.gameoflife.model.state;

import com.promouit.gameoflife.model.Neighbours;

public class CellContext {
	private State currentState;
	private State nextState;

	private Neighbours neighbours;

	public CellContext(State state) {
		this.currentState = state;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void prepareNextState() {
		nextState = currentState.getNextState(this);
	}

	public void moveToNextState() {
		this.currentState = this.nextState;
		nextState = null;
	}

	public void setNeighbours(Neighbours neighbours) {
		this.neighbours = neighbours;
	}
	
	public Neighbours getNeighbours() {
		return neighbours;
	}
}
