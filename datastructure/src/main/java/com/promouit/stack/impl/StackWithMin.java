package com.promouit.stack.impl;

import com.promouit.stack.api.IStack;
import com.promouit.stack.domain.StackNodeMin;
import com.promouit.stack.exception.StackEmptyException;
import com.promouit.stack.exception.StackFullException;

public class StackWithMin<E extends Comparable<E>> implements IStack<E> {

	private StackNodeMin<E> top;
	private int size;

	public void push(E data) throws StackFullException {
		StackNodeMin<E> nodeMin = new StackNodeMin<E>(data, top);
		if (top != null) {
			if (nodeMin.getData().compareTo(top.getData()) <= 0)
				nodeMin.setMin(nodeMin);
			else
				nodeMin.setMin(top.getMin());
		}else{
			nodeMin.setMin(nodeMin);
		}
		size++;
		top = nodeMin;
	}

	public E pop() throws StackEmptyException {
		if (top == null)
			throw new StackEmptyException();
		else {
			StackNodeMin<E> temp = top;
			top = top.getNext();
			temp.setNext(null);
			size--;
			return temp.getData();
		}
	}

	public E peek() throws StackEmptyException {
		if (top == null)
			throw new StackEmptyException();
		else {
			return top.getData();
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E getMin() throws StackEmptyException {
		if (top == null)
			throw new StackEmptyException();
		else
			return top.getMin().getData();
	}
}
