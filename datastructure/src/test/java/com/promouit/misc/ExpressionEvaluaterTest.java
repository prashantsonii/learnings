package com.promouit.misc;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExpressionEvaluaterTest {

	@Test
	public void shouldEvaluatePostfixExpression() {
		ExpressionUtils evaluater = new ExpressionUtils();
		assertEquals(Integer.valueOf(44),
				evaluater.evaluatePostfixExpression("234*+56*+"));
	}

	@Test
	public void shouldEvaluatePrefixExpression() {
		ExpressionUtils evaluater = new ExpressionUtils();
		assertEquals(Integer.valueOf(44),
				evaluater.evaluatePrefixExpression("++2*34*56"));
	}

	@Test
	public void shouldConvertToPostfix() {
		ExpressionUtils converter = new ExpressionUtils();
		assertEquals("23+4*56+7*+",converter.convertInfixToPostfix("(2+3)*4+(5+6)*7"));
	}
	
}
