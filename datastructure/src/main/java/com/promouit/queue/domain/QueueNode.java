package com.promouit.queue.domain;

public class QueueNode<E> {
	private E data;
	private QueueNode<E> next;

	public QueueNode(E data, QueueNode<E> next) {
		this.data = data;
		this.next = next;
	}
	
	public E getData() {
		return data;
	}
	
	public QueueNode<E> getNext() {
		return next;
	}
	
	public void setNext(QueueNode<E> next) {
		this.next = next;
	}
}
