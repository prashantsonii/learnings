package com.promouit.queue.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.promouit.queue.exception.QueueEmptyException;
import com.promouit.queue.exception.QueueFullException;

public class QueueTest {

	@Test
	public void shouldCreate() {
		Queue<Integer> queue = new Queue<Integer>();
		assertNotNull(queue);
	}

	@Test
	public void shouldEnqueueData() throws QueueFullException {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(10);
		assertEquals(1, queue.size());
		queue.enqueue(20);
		assertEquals(2, queue.size());
	}
	
	@Test
	public void shouldDequeueData() throws QueueEmptyException, QueueFullException {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(10);
		assertEquals(1, queue.size());
		queue.enqueue(20);
		assertEquals(2, queue.size());
		assertEquals(Integer.valueOf(10), queue.dequeue());
		assertEquals(1, queue.size());
		assertEquals(Integer.valueOf(20), queue.dequeue());
		assertEquals(0, queue.size());
	}
	
	@Test(expected=QueueEmptyException.class)
	public void shouldThrowExceptionWhenDequeueingFromEmptyQueue() throws QueueFullException, QueueEmptyException {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(10);
		queue.enqueue(20);
		assertEquals(Integer.valueOf(10), queue.dequeue());
		assertEquals(Integer.valueOf(20), queue.dequeue());
		queue.dequeue();
	}
	
	@Test
	public void shouldReturnFront() throws QueueFullException, QueueEmptyException {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(10);
		queue.enqueue(20);
		assertEquals(Integer.valueOf(10), queue.front());
		assertEquals(2, queue.size());
	}
	
	@Test(expected=QueueEmptyException.class)
	public void frontShouldThrowExceptionForEmptyQueue() throws QueueFullException, QueueEmptyException {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(10);
		assertEquals(Integer.valueOf(10), queue.dequeue());
		queue.front();
	}
	
}
