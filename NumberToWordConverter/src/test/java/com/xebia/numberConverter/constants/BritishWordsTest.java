package com.xebia.numberConverter.constants;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BritishWordsTest {

	@Test
	public void shouldConvertNumberToWord(){
		assertEquals(BritishWords.getWordForNumber("10"), "Ten");
		assertEquals(BritishWords.getWordForNumber("90"), "Ninety");
		assertEquals(BritishWords.getWordForNumber("12"), "Twelve");
	}
	
	@Test
	public void shouldReturnEmptyWord(){
		assertEquals(BritishWords.getWordForNumber("101"), WordConstants.EMPTY_STRING);
	}
	
}
