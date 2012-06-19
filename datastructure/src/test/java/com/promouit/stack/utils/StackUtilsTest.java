package com.promouit.stack.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.promouit.stack.exception.StackEmptyException;
import com.promouit.stack.impl.Stack;

public class StackUtilsTest {

	@Test
	public void shouldSort() throws StackEmptyException {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(10);
		stack.push(6);
		Stack<Integer> sortStack = StackUtils.sortStack(stack);
		assertEquals(Integer.valueOf(5), sortStack.pop());
		assertEquals(Integer.valueOf(6), sortStack.pop());
		assertEquals(Integer.valueOf(10), sortStack.pop());
	}

}
