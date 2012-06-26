package com.promouit.misc.problems;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrackTest {

	@Test
	public void shouldFindCorrectStartingPoing() {
		Track track = new Track();
		int[] distances = new int[]{6,8,5,6,13,10,5,8,5,5};
		int[] fuel = new int[]{4,3,11,6,12,9,6,6,12,2};
		assertEquals(2, track.findStartingStation(distances, fuel));
	}

}
