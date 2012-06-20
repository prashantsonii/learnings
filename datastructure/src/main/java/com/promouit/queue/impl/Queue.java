package com.promouit.queue.impl;

import com.promouit.queue.api.IQueue;
import com.promouit.queue.domain.QueueNode;
import com.promouit.queue.exception.QueueEmptyException;
import com.promouit.queue.exception.QueueFullException;

public class Queue<E> implements IQueue<E> {

	private QueueNode<E> start;
	private QueueNode<E> end;
	private int size;
	
	public void enqueue(E data) throws QueueFullException{
		QueueNode<E> node = new QueueNode<E>(data, null);
		if(start == null){
			start = end = node;
		}else{
			end.setNext(node);
			end = node;
		}
		size++;
	}

	public E dequeue() throws QueueEmptyException {
		if(start!=null){
			QueueNode<E> node = start;
			start = start.getNext();
			node.setNext(null);
			if(node==end)
				end = null;
			size--;
			return node.getData();
		}
		throw new QueueEmptyException();
	}

	public E front() throws QueueEmptyException {
		if(start!=null)
			return start.getData();
		throw new QueueEmptyException();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}
}
