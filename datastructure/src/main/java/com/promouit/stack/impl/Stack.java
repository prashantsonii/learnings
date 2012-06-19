package com.promouit.stack.impl;

import com.promouit.stack.api.IStack;
import com.promouit.stack.domain.SNode;
import com.promouit.stack.exception.StackEmptyException;

public class Stack<E extends Comparable<E>> implements IStack<E> {

	private int size;
	private SNode<E> top;

	public void push(E data) {
		SNode<E> node = new SNode<E>(data, top);
		top = node;
		size++;
	}

	public E pop() throws StackEmptyException{
		if(top!=null){
			E data = null;
			SNode<E> temp = top;
			top = top.getNext();
			temp.setNext(null);
			data = temp.getData();
			size--;
			return data;
		}else{
			throw new StackEmptyException();
		}
	}

	public E peek() throws StackEmptyException{
		if(top!=null){
			E data = null;
			data = top.getData();
			return data;
		}else{
			throw new StackEmptyException();
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

}
