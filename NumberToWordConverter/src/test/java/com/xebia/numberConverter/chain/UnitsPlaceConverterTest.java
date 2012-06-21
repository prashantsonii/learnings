package com.xebia.numberConverter.chain;

import org.junit.BeforeClass;
import org.junit.Test;
import com.xebia.numberConverter.model.Number;
import com.xebia.numberConverter.chain.impl.ConversionTerminator;
import com.xebia.numberConverter.chain.impl.UnitsPlaceConverter;
import static org.junit.Assert.assertEquals;

public class UnitsPlaceConverterTest {
	
	private static UnitsPlaceConverter unitsPlaceConverter;
	
	@BeforeClass
	public static void setUp(){
		unitsPlaceConverter = new UnitsPlaceConverter(new ConversionTerminator());
	}

	@Test
	public void shouldConvertCorrectly(){
		Number number = new Number("9");
		unitsPlaceConverter.convert(number);
		assertEquals("Nine", number.toString());
		
		number = new Number("1");
		unitsPlaceConverter.convert(number);
		assertEquals("One", number.toString());
	}
}
