package com.promouit.queue.api;

import com.promouit.queue.exception.QueueEmptyException;
import com.promouit.queue.exception.QueueFullException;

public interface IQueue<E> {
	public void enqueue(E data) throws QueueFullException;

	public E dequeue() throws QueueEmptyException;

	public E front() throws QueueEmptyException;

	public int size();

	public boolean isEmpty();
}
