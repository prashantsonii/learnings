package com.promouit.stack.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.promouit.stack.api.IStack;
import com.promouit.stack.exception.StackEmptyException;
import com.promouit.stack.exception.StackFullException;

public class StackOfArrayTest {

	@Test
	public void shouldCreateStack() {
		IStack<Integer> stack = new StackOfArray<Integer>();
		assertNotNull(stack);
	}

	@Test
	public void shouldPushData() throws StackFullException {
		IStack<Integer> stack = new StackOfArray<Integer>();
		stack.push(10);
		assertEquals(1, stack.size());
		stack.push(20);
		assertEquals(2, stack.size());
	}
	
	@Test(expected=StackFullException.class)
	public void shouldThrowExceptionWhenStackIsFull() throws StackFullException {
		IStack<Integer> stack = new StackOfArray<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(9);
		stack.push(8);
		stack.push(7);
		stack.push(6);
	}
	
	@Test
	public void shouldPopData() throws StackFullException, StackEmptyException {
		IStack<Integer> stack = new StackOfArray<Integer>();
		stack.push(10);
		stack.push(20);
		assertEquals(Integer.valueOf(20), stack.pop());
		assertEquals(Integer.valueOf(10), stack.pop());
	}
	
	@Test(expected=StackEmptyException.class)
	public void shouldThrowExceptionWhenPoppingFromEmptyStack() throws StackFullException, StackEmptyException {
		IStack<Integer> stack = new StackOfArray<Integer>();
		stack.push(10);
		stack.pop();
		stack.pop();
	}
	
	@Test
	public void shouldPeekData() throws StackEmptyException, StackFullException {
		IStack<Integer> stack = new StackOfArray<Integer>();
		stack.push(10);
		assertEquals(Integer.valueOf(10), stack.peek());
		assertEquals(Integer.valueOf(10), stack.peek());
	}
	
	@Test(expected=StackEmptyException.class)
	public void shouldThrowExceptionWhenPeekingFromEmptyStack() throws StackEmptyException {
		IStack<Integer> stack = new StackOfArray<Integer>();
		stack.peek();
	}
}
