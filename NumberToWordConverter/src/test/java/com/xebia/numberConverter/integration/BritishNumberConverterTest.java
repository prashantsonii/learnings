package com.xebia.numberConverter.integration;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.xebia.numberConverter.converter.BritishNumberToWordConverter;
import com.xebia.numberConverter.model.Number;

public class BritishNumberConverterTest {

	private static BritishNumberToWordConverter britishNumberToWordConverter = null;
	
	@BeforeClass
	public static void setUp(){
		britishNumberToWordConverter = new BritishNumberToWordConverter();
	}
	
	@Test
	public void shouldConvertSingleDigitNumber(){
		Number number = new Number("2");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Two", number.toString());
	}
	
	@Test
	public void shouldConvertTwoDigitNumber(){
		Number number = new Number("12");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Twelve", number.toString());

		number = new Number("20");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Twenty", number.toString());

		number = new Number("21");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Twenty One", number.toString());
	}
	
	@Test
	public void shouldConvertThreeDigitNumbers(){
		Number number = new Number("120");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("One Hundred and Twenty", number.toString());
		
		number = new Number("101");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("One Hundred and One", number.toString());
		
		number = new Number("100");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("One Hundred", number.toString());
		
		number = new Number("992");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Nine Hundred and Ninety Two", number.toString());		
	}
	
	@Test
	public void shouldConvertFourDigitNumbers(){
		Number number = new Number("1220");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("One Thousand Two Hundred and Twenty", number.toString());
		
		number = new Number("9999");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Nine Thousand Nine Hundred and Ninety Nine", number.toString());
		
		number = new Number("1234");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("One Thousand Two Hundred and Thirty Four", number.toString());
		
		number = new Number("1099");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("One Thousand and Ninety Nine", number.toString());	
		
		number = new Number("1000");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("One Thousand", number.toString());
		
		number = new Number("9001");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Nine Thousand and One", number.toString());	
	}	

	@Test
	public void shouldConvertFiveDigitNumbers(){
		Number number = new Number("10220");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Ten Thousand Two Hundred and Twenty", number.toString());
		
		number = new Number("19999");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Nineteen Thousand Nine Hundred and Ninety Nine", number.toString());
		
		number = new Number("10340");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Ten Thousand Three Hundred and Forty", number.toString());
		
		number = new Number("10001");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Ten Thousand and One", number.toString());
		
		number = new Number("10201");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Ten Thousand Two Hundred and One", number.toString());		
	}	

	@Test
	public void shouldConvertSixDigitNumbers(){
		Number number = new Number("120220");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("One Hundred and Twenty Thousand Two Hundred and Twenty", number.toString());
		
		number = new Number("199999");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("One Hundred and Ninety Nine Thousand Nine Hundred and Ninety Nine", number.toString());
		
		number = new Number("100000");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("One Hundred Thousand", number.toString());
		
		number = new Number("100001");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("One Hundred Thousand and One", number.toString());		
		
		number = new Number("103400");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("One Hundred and Three Thousand Four Hundred", number.toString());
	}

	@Test
	public void shouldConvertSevenDigitNumbers(){
		Number number = new Number("1202220");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("One Million Two Hundred and Two Thousand Two Hundred and Twenty", number.toString());
		
		number = new Number("1000000");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("One Million", number.toString());
		
		number = new Number("1999900");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("One Million Nine Hundred and Ninety Nine Thousand Nine Hundred", number.toString());
		
		number = new Number("1000001");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("One Million and One", number.toString());
	}	
	
	@Test
	public void shouldConvertEightDigitNumbers(){
		Number number = new Number("12222221");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Twelve Million Two Hundred and Twenty Two Thousand Two Hundred and Twenty One", number.toString());
		
		number = new Number("19999");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Nineteen Thousand Nine Hundred and Ninety Nine", number.toString());
		
		number = new Number("10340");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Ten Thousand Three Hundred and Forty", number.toString());
		
		number = new Number("56945781");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Fifty Six Million Nine Hundred and Forty Five Thousand Seven Hundred and Eighty One", number.toString());
	}

	@Test
	public void shouldConvertNineDigitNumbers(){
		Number number = new Number("912222221");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Nine Hundred and Twelve Million Two Hundred and Twenty Two Thousand Two Hundred and Twenty One", number.toString());
		
		number = new Number("912000000");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Nine Hundred and Twelve Million", number.toString());
		
		number = new Number("815999601");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Eight Hundred and Fifteen Million Nine Hundred and Ninety Nine Thousand Six Hundred and One", number.toString());
		
		number = new Number("000999601");
		britishNumberToWordConverter.convertToBritishWords(number);
		assertEquals("Nine Hundred and Ninety Nine Thousand Six Hundred and One", number.toString());

	}	
}
