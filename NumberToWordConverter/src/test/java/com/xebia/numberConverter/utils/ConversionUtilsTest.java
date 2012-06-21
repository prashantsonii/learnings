package com.xebia.numberConverter.utils;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.xebia.numberConverter.model.Number;

public class ConversionUtilsTest {

	private static Number number;
	
	@BeforeClass
	public static void setUp(){
		number = new Number("123456789");
	}
	
	@Test
	public void shouldExtractDigitsCorrectly(){
		assertEquals("9", ConversionUtils.digitsAt(number, 0));
		assertEquals("5", ConversionUtils.digitsAt(number, 4));
		assertEquals("1", ConversionUtils.digitsAt(number, 8));
	}

	@Test
	public void shouldExtractNumberStringCorrectly(){
		assertEquals("678", ConversionUtils.digitsBetween(number, 2, 3));
		assertEquals("1", ConversionUtils.digitsBetween(number, 9, 1));
		assertEquals("3456", ConversionUtils.digitsBetween(number, 4, 4));
	}
	
}
