package com.xebia.numberConverter.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NumberTest {
	
	@Test
	public void shouldPassIndexValue(){
		Number number = new Number("9999");
		assertEquals(true, number.hasIndex(3));
	}
	
	@Test
	public void shouldFailIndexValue(){
		Number number = new Number("9999");
		assertEquals(false, number.hasIndex(4));
	}
	
}
