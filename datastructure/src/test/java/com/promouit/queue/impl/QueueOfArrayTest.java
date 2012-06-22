package com.promouit.queue.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.promouit.queue.exception.QueueEmptyException;
import com.promouit.queue.exception.QueueFullException;

public class QueueOfArrayTest {

	@Test
	public void shouldCreate() {
		QueueOfArray<Integer> queue = new QueueOfArray<Integer>();
		assertNotNull(queue);
		assertEquals(0, queue.size());
	}

	@Test
	public void shouldAddDataAndUpdateSize() throws QueueFullException {
		QueueOfArray<Integer> queue = new QueueOfArray<Integer>();
		queue.enqueue(1);
		assertEquals(1, queue.size());
		queue.enqueue(1);
		assertEquals(2, queue.size());
	}

	@Test(expected=QueueFullException.class)
	public void shouldThrowExceptionWhenQueueIsFull() throws QueueFullException {
		QueueOfArray<Integer> queue = new QueueOfArray<Integer>();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
			assertEquals(i+1, queue.size());
		}
		queue.enqueue(11);
	}

	@Test
	public void shouldDequeueDataInProperOrder() throws QueueFullException, QueueEmptyException {
		QueueOfArray<Integer> queue = new QueueOfArray<Integer>();
		for (int i = 0; i < 9; i++) {
			queue.enqueue(i);
			assertEquals(i+1, queue.size());
		}
		for(int i = 0; i < 9 ; i++){
			assertEquals(Integer.valueOf(i), queue.dequeue());
			assertEquals(9-(i+1), queue.size());
		}
	}
	
	@Test
	public void shouldEnqueueAndDequeue() throws QueueFullException, QueueEmptyException {
		QueueOfArray<Integer> queue = new QueueOfArray<Integer>();
		queue.enqueue(1);
		assertEquals(1, queue.size());
		queue.dequeue();
		assertEquals(0, queue.size());
	}
	
	@Test
	public void shouldReturnFront() throws QueueFullException, QueueEmptyException {
		QueueOfArray<Integer> queue = new QueueOfArray<Integer>();
		queue.enqueue(1);
		assertEquals(1, queue.size());
		assertEquals(Integer.valueOf(1), queue.front());
		assertEquals(1, queue.size());
	}
	
	@Test(expected = QueueEmptyException.class)
	public void shouldThrowExceptionWhenFrontCalledOnEmptyQueue() throws QueueEmptyException {
		QueueOfArray<Integer> queue = new QueueOfArray<Integer>();
		queue.front();
	}
	
}
