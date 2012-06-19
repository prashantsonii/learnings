package com.promouit.stack.domain;

public class StackNodeMin<E> {
	private E data;
	private StackNodeMin<E> next;
	private StackNodeMin<E> min;

	public StackNodeMin(E data, StackNodeMin<E> next){
		this.data = data;
		this.next = next;
	}
	
	public E getData() {
		return data;
	}
	public StackNodeMin<E> getMin() {
		return min;
	}
	
	public void setNext(StackNodeMin<E> next) {
		this.next = next;
	}
	
	public void setMin(StackNodeMin<E> min) {
		this.min = min;
	}
	
	public StackNodeMin<E> getNext() {
		return next;
	}
}