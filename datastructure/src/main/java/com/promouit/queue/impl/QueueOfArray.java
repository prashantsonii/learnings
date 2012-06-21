package com.promouit.queue.impl;

import com.promouit.queue.api.IQueue;
import com.promouit.queue.exception.QueueEmptyException;
import com.promouit.queue.exception.QueueFullException;

public class QueueOfArray<E> implements IQueue<E> {

	
	
	public void enqueue(E data) throws QueueFullException {
		
	}

	public E dequeue() throws QueueEmptyException {
		return null;
	}

	public E front() throws QueueEmptyException {
		return null;
	}

	public int size() {
		return 0;
	}

	public boolean isEmpty() {
		return false;
	}

}
