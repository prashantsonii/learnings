package com.promouit.queue.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.promouit.queue.api.IQueue;
import com.promouit.queue.exception.QueueEmptyException;
import com.promouit.queue.exception.QueueFullException;

public class QueueOfStacksTest {

	@Test
	public void shouldCreate() {
		IQueue<Integer> queue = new QueueOfStacks<Integer>();
		assertNotNull(queue);
		assertEquals(0, queue.size());
	}

	@Test(expected = QueueEmptyException.class)
	public void shouldThrowExceptionWhenDequeuingFromEmptyQueue()
			throws QueueEmptyException {
		IQueue<Integer> queue = new QueueOfStacks<Integer>();
		assertEquals(0, queue.size());
		queue.dequeue();
	}

	@Test(expected = QueueEmptyException.class)
	public void shouldThrowExceptionWhenFetchingFrontFromEmptyQueue()
			throws QueueEmptyException {
		IQueue<Integer> queue = new QueueOfStacks<Integer>();
		assertEquals(0, queue.size());
		queue.front();
	}

	@Test
	public void shouldEnqueue() throws QueueFullException {
		IQueue<Integer> queue = new QueueOfStacks<Integer>();
		assertEquals(0, queue.size());
		queue.enqueue(1);
		assertEquals(1, queue.size());
		queue.enqueue(2);
		assertEquals(2, queue.size());
		queue.enqueue(3);
		assertEquals(3, queue.size());
	}

	@Test
	public void shouldEnqueueAndThenDequeue() throws QueueFullException, QueueEmptyException {
		IQueue<Integer> queue = new QueueOfStacks<Integer>();
		for (int i = 0; i < 5; i++) {
			queue.enqueue(i);
			assertEquals(i + 1, queue.size());
		}
		for(int i = 0; i <2; i++){
			assertEquals(Integer.valueOf(i), queue.dequeue());
			assertEquals(5-(i+1), queue.size());
		}
		for (int i = 5; i < 10; i++) {
			queue.enqueue(i);
			assertEquals( 5 - 2 + (i + 1 - 5), queue.size());
		}
		for(int i = 2; i < 10; i++){
			assertEquals(Integer.valueOf(i), queue.dequeue());
			assertEquals(8-(i - 2+1), queue.size());
		}
	}

}
