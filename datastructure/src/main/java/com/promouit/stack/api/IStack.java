package com.promouit.stack.api;

import com.promouit.stack.exception.StackEmptyException;

public interface IStack<E> {
	public void push(E data);

	public E pop() throws StackEmptyException;
	
	public E peek() throws StackEmptyException;
	
	public int size();
	
	public boolean isEmpty();
}
