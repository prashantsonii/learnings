package com.xebia.numberConverter.chain;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.xebia.numberConverter.chain.impl.MillionsPlaceConveter;
import com.xebia.numberConverter.chain.impl.UnitsPlaceConverter;
import com.xebia.numberConverter.model.Number;

public class MillionsPlaceConverterTest {
	private static MillionsPlaceConveter millionsPlaceConveter;
	
	private static UnitsPlaceConverter unitsPlaceConverter;
	
	@BeforeClass
	public static void setUp(){
		millionsPlaceConveter = new MillionsPlaceConveter();
		unitsPlaceConverter = new UnitsPlaceConverter(0);
	}
	
	@Test
	public void shouldInvokeOnlyMillionsConverter(){
		Number number = new Number("9000000");
		millionsPlaceConveter.convert(number);
		assertEquals("Nine Million", number.toString());
		
		number = new Number("9000001");
		millionsPlaceConveter.convert(number);
		assertEquals("Nine Million", number.toString());
		
		number = new Number("99000001");
		millionsPlaceConveter.convert(number);
		assertEquals("Ninety Nine Million", number.toString());
		
		number = new Number("801900100");
		millionsPlaceConveter.convert(number);
		assertEquals("Eight Hundred and One Million", number.toString());
	}
	
	@Test
	public void shouldInvokeAllRequiredConverters(){
		Number number = new Number("9000000");
		unitsPlaceConverter.convert(number);
		assertEquals("Nine Million", number.toString());
		
		number = new Number("9000001");
		unitsPlaceConverter.convert(number);
		assertEquals("Nine Million and One", number.toString());
		
		number = new Number("99000001");
		unitsPlaceConverter.convert(number);
		assertEquals("Ninety Nine Million and One", number.toString());
		
		number = new Number("801900100");
		unitsPlaceConverter.convert(number);
		assertEquals("Eight Hundred and One Million Nine Hundred Thousand One Hundred", number.toString());
	}
	
}
