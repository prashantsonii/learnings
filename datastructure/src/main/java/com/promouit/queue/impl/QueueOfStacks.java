package com.promouit.queue.impl;

import com.promouit.queue.api.IQueue;
import com.promouit.queue.exception.QueueEmptyException;
import com.promouit.queue.exception.QueueFullException;
import com.promouit.stack.api.IStack;
import com.promouit.stack.exception.StackEmptyException;
import com.promouit.stack.exception.StackFullException;
import com.promouit.stack.impl.Stack;

public class QueueOfStacks<E extends Comparable<E>> implements IQueue<E> {

	private IStack<E> insertionStack = new Stack<E>();
	private IStack<E> deletionStack = new Stack<E>();

	public void enqueue(E data) throws QueueFullException {
		try {
			insertionStack.push(data);
		} catch (StackFullException e) {
			try {
				transferDataBetweenStack();
			} catch (StackFullException e1) {
			} catch (StackEmptyException e2) {
			}
			try {
				insertionStack.push(data);
			} catch (StackFullException e1) {
				throw new QueueFullException();
			}
		}
	}

	private void transferDataBetweenStack() throws StackFullException,
			StackEmptyException {
		while (!insertionStack.isEmpty()) {
			deletionStack.push(insertionStack.pop());
		}
	}

	public E dequeue() throws QueueEmptyException {
		E data = null;
		try {
			data = deletionStack.pop();
		} catch (StackEmptyException e) {
			try {
				transferDataBetweenStack();
			} catch (StackFullException e1) {
			} catch (StackEmptyException e1) {
			}
			try {
				data = deletionStack.pop();
			} catch (StackEmptyException e1) {
				throw new QueueEmptyException();
			}
		}
		return data;
	}

	public E front() throws QueueEmptyException {
		E data = null;
		try {
			data = deletionStack.peek();
		} catch (StackEmptyException e) {
			try {
				transferDataBetweenStack();
			} catch (StackFullException e1) {
			} catch (StackEmptyException e1) {
			}
			try {
				data = deletionStack.peek();
			} catch (StackEmptyException e1) {
				throw new QueueEmptyException();
			}
		}
		return data;
	}

	public int size() {
		return insertionStack.size() + deletionStack.size();
	}

	public boolean isEmpty() {
		return insertionStack.isEmpty() && deletionStack.isEmpty();
	}

}
