package com.elmejor.miscellaneous;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdderTest {

	/*
	 * Add positive numbers
	 */
	@Test
	public void test1() {
		Adder adder = new Adder();
		assertTrue(adder.add(2, 5) == 7);
	}

	/*
	 * Add negative numbers
	 */
	@Test
	public void test2() {
		Adder adder = new Adder();
		assertTrue(adder.add(-2, -5) == -7);
	}
	
	/*
	 * Add positive and negative numbers
	 */
	@Test
	public void test3() {
		Adder adder = new Adder();
		assertTrue(adder.add(-2, 5) == 3);
	}
	
	@Test
	public void test4() {
		Adder adder = new Adder();
		assertTrue(adder.add(2, -5) == -3);
	}
}
