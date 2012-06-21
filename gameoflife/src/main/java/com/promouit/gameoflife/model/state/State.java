package com.promouit.gameoflife.model.state;

public interface State {

	State getNextState(CellContext cellContext);

}
