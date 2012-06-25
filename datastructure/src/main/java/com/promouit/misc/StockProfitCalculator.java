package com.promouit.misc;

import java.util.Stack;

public class StockProfitCalculator {

	public int calculateProfit(int ... stockPrices) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxProfit = 0;
		for(int stockPrice : stockPrices){
			if(stack.isEmpty() || stockPrice >= stack.peek())
				stack.push(stockPrice);
			else{
				while(!stack.isEmpty() && stack.peek() > stockPrice)
					stack.pop();
				stack.push(stockPrice);
			}
			maxProfit = Math.max(maxProfit, stack.peek()-stack.get(0));
		}
		return maxProfit;
	}
}
