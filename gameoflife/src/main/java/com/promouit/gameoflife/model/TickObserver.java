package com.promouit.gameoflife.model;

public interface TickObserver {

	void prepareNextState();

	void moveToNextState();
}
