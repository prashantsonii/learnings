package com.promouit.stack.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.promouit.stack.exception.StackEmptyException;
import com.promouit.stack.exception.StackFullException;

public class StackWithMinTest {

	@Test
	public void shouldCreate() {
		StackWithMin<Integer> stack = new StackWithMin<Integer>();
		assertNotNull(stack);
	}

	@Test
	public void shouldPush() throws StackFullException {
		StackWithMin<Integer> stack = new StackWithMin<Integer>();
		stack.push(10);
		assertEquals(1, stack.size());
		stack.push(20);
		assertEquals(2, stack.size());
	}
	
	@Test
	public void shouldPop() throws StackFullException, StackEmptyException {
		StackWithMin<Integer> stack = new StackWithMin<Integer>();
		stack.push(10);
		stack.push(20);
		assertEquals(2, stack.size());
		assertEquals(Integer.valueOf(20), stack.pop());
		assertEquals(1, stack.size());
		assertEquals(Integer.valueOf(10), stack.pop());
		assertEquals(0, stack.size());
	}
	
	@Test(expected=StackEmptyException.class)
	public void shouldThrowStackEmptyException() throws StackFullException, StackEmptyException {
		StackWithMin<Integer> stack = new StackWithMin<Integer>();
		stack.push(10);
		stack.push(20);
		assertEquals(2, stack.size());
		assertEquals(Integer.valueOf(20), stack.pop());
		assertEquals(1, stack.size());
		assertEquals(Integer.valueOf(10), stack.pop());
		assertEquals(0, stack.size());
		stack.pop();
	}
	
	@Test
	public void shouldPeekData() throws StackFullException, StackEmptyException {
		StackWithMin<Integer> stack = new StackWithMin<Integer>();
		stack.push(10);
		stack.push(20);
		assertEquals(2, stack.size());
		assertEquals(Integer.valueOf(20), stack.peek());
		assertEquals(2, stack.size());
		assertEquals(Integer.valueOf(20), stack.peek());
		assertEquals(2, stack.size());
	}
	
	@Test
	public void shouldReturnMin() throws StackFullException, StackEmptyException {
		StackWithMin<Integer> stack = new StackWithMin<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(6);
		stack.push(2);
		stack.push(5);
		assertEquals(Integer.valueOf(2), stack.getMin());
		stack.pop();
		assertEquals(Integer.valueOf(2), stack.getMin());
		stack.pop();
		assertEquals(Integer.valueOf(6), stack.getMin());
		stack.pop();
		assertEquals(Integer.valueOf(10), stack.getMin());
		stack.pop();
		assertEquals(Integer.valueOf(10), stack.getMin());
	}
}
