package com.promouit.dlist.domain;

public class Node<E> {

	private E data;
	private Node<E> next;
	private Node<E> previous;
	
	public Node(E data, Node<E> next, Node<E> previous) {
		this.data = data;
		this.next = next;
		this.previous = previous;
	}

	public Node(E data) {
		this.data = data;
	}
	
	public E getData() {
		return data;
	}
	
	public Node<E> getNext() {
		return next;
	}
	
	public Node<E> getPrevious() {
		return previous;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	public void setPrevious(Node<E> previous) {
		this.previous = previous;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}
