package com.xebia.numberConverter.validator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.xebia.numberConverter.model.Number;

public class ValidatorTest {
	
	@Test
	public void shouldPassValidation(){
		Number number = new Number("123");
		assertEquals(true, NumberValidator.isValidNumber(number));
	}
	
	@Test
	public void shouldFailValidationforNull(){
		Number number = null;
		assertEquals(false, NumberValidator.isValidNumber(number));
	}
	
	@Test
	public void shouldFailValidationforNullValue(){
		Number number = new Number(null);
		assertEquals(false, NumberValidator.isValidNumber(number));
	}
	
	@Test
	public void shouldFailValidationForNonNumberic(){
		Number number = new Number("aoraouira");
		assertEquals(false, NumberValidator.isValidNumber(number));
	}
	
	@Test
	public void shouldPassValidationForNumbersWithComma(){
		Number number = new Number("999999999");
		assertEquals(true, NumberValidator.isValidNumber(number));
	}
	
	@Test
	public void shouldFailWithExceedingLength(){
		Number number = new Number("9999999999");
		assertEquals(false, NumberValidator.isValidNumber(number));
	}
	
	@Test
	public void shouldRemovePreceedingZeros(){
		Number number = new Number("000999999");
		assertEquals(true, NumberValidator.isValidNumber(number));
		assertEquals("999999", number.value());
	}
	
}
