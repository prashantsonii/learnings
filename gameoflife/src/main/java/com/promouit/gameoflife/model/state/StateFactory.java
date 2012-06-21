package com.promouit.gameoflife.model.state;

public class StateFactory {

	public static final String ALIVE = "X";
	public static final String DEAD = "-";;

	private static final AliveState aliveState = new AliveState();
	private static final DeadState deadState = new DeadState();

	public static State getState(String stateStr) {
		if (ALIVE.equals(stateStr))
			return aliveState;
		else if (DEAD.equals(stateStr))
			return deadState;
		throw new IllegalStateException("Invalid Parameter for state creation");
	}
}
