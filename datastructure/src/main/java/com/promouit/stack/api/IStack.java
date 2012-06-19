package com.promouit.stack.api;

import com.promouit.stack.exception.StackEmptyException;
import com.promouit.stack.exception.StackFullException;

public interface IStack<E> {
	public void push(E data) throws StackFullException;

	public E pop() throws StackEmptyException;
	
	public E peek() throws StackEmptyException;
	
	public int size();
	
	public boolean isEmpty();
}
