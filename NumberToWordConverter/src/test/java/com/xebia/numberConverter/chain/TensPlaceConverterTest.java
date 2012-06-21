package com.xebia.numberConverter.chain;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.xebia.numberConverter.chain.impl.ConversionTerminator;
import com.xebia.numberConverter.chain.impl.TensPlaceConveter;
import com.xebia.numberConverter.chain.impl.UnitsPlaceConverter;
import com.xebia.numberConverter.model.Number;

public class TensPlaceConverterTest {

	private static TensPlaceConveter tensPlaceConveter;

	private static UnitsPlaceConverter unitsPlaceConverter;

	@BeforeClass
	public static void setUp() {
		tensPlaceConveter = new TensPlaceConveter(new ConversionTerminator());
		unitsPlaceConverter = new UnitsPlaceConverter(0);
	}

	@Test
	public void shouldConvertCorrectly() {
		Number number = new Number("19");
		tensPlaceConveter.convert(number);
		assertEquals("Nineteen", number.toString());

		number = new Number("10");
		tensPlaceConveter.convert(number);
		assertEquals("Ten", number.toString());
	}

	@Test
	public void shouldInvokeUpToTensPlaceConverter() {
		Number number = new Number("99");
		unitsPlaceConverter.convert(number);
		assertEquals("Ninety Nine", number.toString());
	}

	@Test
	public void shouldAlsoInvokeHundredsPlaceConverter() {
		Number number = new Number("199");
		unitsPlaceConverter.convert(number);
		assertEquals("One Hundred and Ninety Nine", number.toString());
	}

}
