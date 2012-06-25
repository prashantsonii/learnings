package com.promouit.misc;

import static org.junit.Assert.*;

import org.junit.Test;

public class StockProfitCalculatorTest {

	@Test
	public void shouldCalculateProfit() {
		StockProfitCalculator calculator = new StockProfitCalculator();
		int maxProfit = calculator.calculateProfit(new int[] { 12, 10, 14, 12, 15, 12, 18, 12, 9 });
		assertEquals(8, maxProfit);
		maxProfit = calculator.calculateProfit(new int[] { 12, 11, 10, 9, 8, 7, 6, 7});
		assertEquals(1, maxProfit);
	}

}
