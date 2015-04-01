package com.elmejor.miscellaneous;

import static org.junit.Assert.*;

import org.junit.Test;

public class PathFinderTest {

	/*
	 * Should find path
	 */
	@Test
	public void test1() {
		int array[] = {8, 2, 4, 9, 12, 3, 1};
		String pathInArray = PathFinder.findPathInArray(array, 3);
		assertEquals("101", pathInArray);
		pathInArray = PathFinder.findPathInArray(array, 9);
		assertEquals("0", pathInArray);
		pathInArray = PathFinder.findPathInArray(array, 12);
		assertEquals("00", pathInArray);
		pathInArray = PathFinder.findPathInArray(array, 1);
		assertEquals("11", pathInArray);
	}
	
	/*
	 * Should not find path
	 */
	@Test
	public void test2() {
		int array[] = {8, 2, 4, 9, 12, 3, 1};
		String pathInArray = PathFinder.findPathInArray(array, 10);
		assertEquals("", pathInArray);
		pathInArray = PathFinder.findPathInArray(array, 0);
		assertEquals("", pathInArray);
	}
}
