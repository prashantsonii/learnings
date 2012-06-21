package com.promouit.gameoflife.io.write;

import com.promouit.gameoflife.exception.GameOfLifeException;

public interface DataWriter {

	void writeObject(Object object) throws GameOfLifeException;

}
