package com.xebia.numberConverter.chain;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.xebia.numberConverter.chain.impl.ThousandsPlaceConverter;
import com.xebia.numberConverter.chain.impl.UnitsPlaceConverter;
import com.xebia.numberConverter.model.Number;

public class ThousandsPlaceConverterTest {

	private static ThousandsPlaceConverter thousandsPlaceConverter;
	
	private static UnitsPlaceConverter unitsPlaceConverter;
	
	@BeforeClass
	public static void setUp(){
		thousandsPlaceConverter = new ThousandsPlaceConverter();
		unitsPlaceConverter = new UnitsPlaceConverter(0);
	}
	
	@Test
	public void shouldConvertCorrectly(){
		Number number = new Number("9000");
		thousandsPlaceConverter.convert(number);
		assertEquals("Nine Thousand", number.toString());
		
		number = new Number("9001");
		thousandsPlaceConverter.convert(number);
		assertEquals("Nine Thousand", number.toString());
		
		number = new Number("99001");
		thousandsPlaceConverter.convert(number);
		assertEquals("Ninety Nine Thousand", number.toString());
		
		number = new Number("809001");
		thousandsPlaceConverter.convert(number);
		assertEquals("Eight Hundred and Nine Thousand", number.toString());
	}
	
	@Test
	public void shouldInvokeAllRequiredConverters(){
		Number number = new Number("9999");
		unitsPlaceConverter.convert(number);
		assertEquals("Nine Thousand Nine Hundred and Ninety Nine", number.toString());
		
		number = new Number("9072");
		unitsPlaceConverter.convert(number);
		assertEquals("Nine Thousand and Seventy Two", number.toString());
		
		number = new Number("99072");
		unitsPlaceConverter.convert(number);
		assertEquals("Ninety Nine Thousand and Seventy Two", number.toString());
	}
	
}
