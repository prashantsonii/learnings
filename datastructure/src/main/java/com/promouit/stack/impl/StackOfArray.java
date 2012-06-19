package com.promouit.stack.impl;

import com.promouit.stack.api.IStack;
import com.promouit.stack.exception.StackEmptyException;
import com.promouit.stack.exception.StackFullException;

public class StackOfArray<E> implements IStack<E>{

	private static final int MAX_STACK_SIZE = 5;
	private Object[] stackData = new Object[MAX_STACK_SIZE];
	private int top = -1;
	
	public void push(E data) throws StackFullException{
		if(top == MAX_STACK_SIZE-1)
			throw new StackFullException();
		top++;
		this.stackData[top] = data;
	}

	public E pop() throws StackEmptyException {
		if(isEmpty())
			throw new StackEmptyException();
		@SuppressWarnings("unchecked")
		E data = (E)stackData[top];
		top--;
		return data;
	}

	@SuppressWarnings("unchecked")
	public E peek() throws StackEmptyException {
		if(isEmpty())
			throw new StackEmptyException();
		return (E)stackData[top];
	}

	public int size() {
		return top+1;
	}

	public boolean isEmpty() {
		return top==-1;
	}
}
