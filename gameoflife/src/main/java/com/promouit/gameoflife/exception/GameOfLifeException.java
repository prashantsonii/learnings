package com.promouit.gameoflife.exception;

public class GameOfLifeException extends Exception {

	private static final long serialVersionUID = 1L;

	public GameOfLifeException(String message) {
		super(message);
	}
	
	public GameOfLifeException(Throwable cause) {
		super(cause);
	}

}
