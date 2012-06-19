package com.promouit.stack.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.promouit.stack.exception.StackEmptyException;

public class StackTest {
	
	@Test
	public void shouldCreateStack() {
		Stack<Integer> stack = new Stack<Integer>();
		assertNotNull(stack);
	}
	
	@Test
	public void shouldPushData() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		assertEquals(1, stack.size());
		stack.push(20);
		assertEquals(2, stack.size());
	}

	@Test
	public void shouldPopPushedData() throws StackEmptyException {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.push(20);
		assertEquals(Integer.valueOf(20), stack.pop());
		assertEquals(Integer.valueOf(10), stack.pop());
	}
	
	@Test(expected=StackEmptyException.class)
	public void shouldThrowExceptionForEmptyStack() throws StackEmptyException {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.pop();
		stack.pop();
	}
	
	@Test
	public void shouldTestForEmptyStack() throws StackEmptyException {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		assertFalse(stack.isEmpty());
		stack.pop();
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void shouldPeekData() throws StackEmptyException {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.push(20);
		assertEquals(Integer.valueOf(20), stack.peek());
		assertEquals(Integer.valueOf(20), stack.peek());
	}
}
