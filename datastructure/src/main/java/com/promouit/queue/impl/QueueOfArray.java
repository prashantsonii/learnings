package com.promouit.queue.impl;

import com.promouit.queue.api.IQueue;
import com.promouit.queue.exception.QueueEmptyException;
import com.promouit.queue.exception.QueueFullException;

public class QueueOfArray<E> implements IQueue<E> {

	private static final int QUEUE_MAX_SIZE = 10;
	private int front = 0;
	private int rear = 0;
	private Object[] queueData = new Object[QUEUE_MAX_SIZE];
	private int size = 0;

	public void enqueue(E data) throws QueueFullException {
		if (size == QUEUE_MAX_SIZE - 1)
			throw new QueueFullException();
		else {
			queueData[rear] = data;
			rear = (rear + 1) % QUEUE_MAX_SIZE;
			updateSize();
		}
	}

	public E dequeue() throws QueueEmptyException {
		if (size == 0) {
			throw new QueueEmptyException();
		} else {
			@SuppressWarnings("unchecked")
			E data = (E) queueData[front];
			queueData[front] = null;
			front = (front + 1) % QUEUE_MAX_SIZE;
			updateSize();
			return data;
		}
	}

	private void updateSize() {
		size = (QUEUE_MAX_SIZE - front + rear) % QUEUE_MAX_SIZE;
	}

	public E front() throws QueueEmptyException {
		if (size == 0) {
			throw new QueueEmptyException();
		} else {
			@SuppressWarnings("unchecked")
			E data = (E) queueData[front];
			return data;
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

}
