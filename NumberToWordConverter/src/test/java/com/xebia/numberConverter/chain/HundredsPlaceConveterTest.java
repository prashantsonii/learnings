package com.xebia.numberConverter.chain;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.xebia.numberConverter.chain.impl.ConversionTerminator;
import com.xebia.numberConverter.chain.impl.HundredsPlaceConverter;
import com.xebia.numberConverter.chain.impl.UnitsPlaceConverter;
import com.xebia.numberConverter.model.Number;

public class HundredsPlaceConveterTest {
	
	private static HundredsPlaceConverter hundredsPlaceConverter;
	
	private static UnitsPlaceConverter unitsPlaceConverter;

	@BeforeClass
	public static void setUp(){
		hundredsPlaceConverter = new HundredsPlaceConverter(new ConversionTerminator());
		unitsPlaceConverter = new UnitsPlaceConverter(0);
	}
	
	@Test
	public void shouldConvertCorrectly(){
		Number number = new Number("100");
		hundredsPlaceConverter.convert(number);
		assertEquals("One Hundred", number.toString());
		
		number = new Number("999");
		hundredsPlaceConverter.convert(number);
		assertEquals("Nine Hundred", number.toString());
	}
	
	@Test
	public void shouldInvokeUnitsTensHundredsPlaceConverters(){
		Number number = new Number("999");
		unitsPlaceConverter.convert(number);
		assertEquals("Nine Hundred and Ninety Nine", number.toString());
		
		number = new Number("972");
		unitsPlaceConverter.convert(number);
		assertEquals("Nine Hundred and Seventy Two", number.toString());
	}
	
}
