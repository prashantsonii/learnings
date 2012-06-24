package com.promouit.list.utils;

import com.promouit.list.domain.Node;
import com.promouit.list.impl.LinkedList;
import com.promouit.stack.api.IStack;
import com.promouit.stack.exception.StackEmptyException;
import com.promouit.stack.exception.StackFullException;
import com.promouit.stack.impl.Stack;

public class ListUtils {
	public static <E extends Comparable<E>> boolean isPalindrome(
			LinkedList<E> list) throws StackFullException, StackEmptyException {
		IStack<E> stack = new Stack<E>();
		int index = 0;
		for (; index < list.size() / 2; index++) {
			stack.push(list.get(index));
		}
		if (list.size() % 2 == 1)
			index++;
		while (!stack.isEmpty()) {
			E poppedNode = stack.pop();
			if (!poppedNode.equals(list.get(index)))
				return false;
			index++;
		}

		if (index != list.size())
			return false;
		return true;
	}

	/*
	 * Should not be a preferred method, as it requires the knowledge about the
	 * internals of list.
	 */
	public static <E> boolean isPalindromeV2(LinkedList<E> list) {
		Node<E> slowPointer = list.getStart();
		Node<E> fastPointer = list.getStart().getNext();
		boolean wasDoubleHop = true;
		boolean palindrome = true;
		StringBuffer tmp = new StringBuffer();
		while (fastPointer.getNext() != null) {
			slowPointer = slowPointer.getNext();
			tmp.append(slowPointer.getData());
			fastPointer = fastPointer.getNext();
			if (fastPointer.getNext() != null)
				fastPointer = fastPointer.getNext();
			else
				wasDoubleHop = false;
		}
		int revIndex = tmp.length() - 1;
		if (!wasDoubleHop)
			revIndex = revIndex - 1;
		slowPointer = slowPointer.getNext();
		while (revIndex >= 0) {
			String substring = tmp.substring(revIndex, revIndex + 1);
			if (!slowPointer.getData().toString().equals(substring)) {
				palindrome = false;
			}
			revIndex--;
			slowPointer = slowPointer.getNext();
		}
		return palindrome;
	}

	public static LinkedList<Integer> findSum(LinkedList<Integer> list1,
			LinkedList<Integer> list2) throws StackEmptyException {
		LinkedList<Integer> sumList = new LinkedList<Integer>();
		Stack<Integer> stack1 = new Stack<Integer>();
		for (int i = 0; i < list1.size(); i++) {
			stack1.push(list1.get(i));
		}
		Stack<Integer> stack2 = new Stack<Integer>();
		for (int i = 0; i < list2.size(); i++) {
			stack2.push(list2.get(i));
		}
		Stack<Integer> sumStack = new Stack<Integer>();
		int carryOver = 0;
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			Integer integer1 = stack1.pop();
			Integer integer2 = stack2.pop();
			Integer sum = integer1 + integer2 + carryOver;
			carryOver = sum / 10;
			sum = sum % 10;
			sumStack.push(sum);
		}
		while (!stack1.isEmpty()) {
			Integer integer1 = stack1.pop();
			Integer sum = integer1 + carryOver;
			carryOver = sum / 10;
			sum = sum % 10;
			sumStack.push(sum);
		}
		while (!stack2.isEmpty()) {
			Integer integer2 = stack2.pop();
			Integer sum = integer2 + carryOver;
			carryOver = sum / 10;
			sum = sum % 10;
			sumStack.push(sum);
		}
		if (carryOver > 0) {
			sumStack.push(carryOver);
		}
		while (!sumStack.isEmpty()) {
			sumList.insert(sumStack.pop());
		}
		return sumList;
	}

	public static <E> E nthNodeFromEnd(LinkedList<E> list, int n) {
		Node<E> temp = list.getStart();
		while (n > 0) {
			n--;
			temp = temp.getNext();
		}
		Node<E> node = list.getStart();
		while (temp != null) {
			node = node.getNext();
			temp = temp.getNext();
		}
		return node.getData();
	}

	public static <E> Node<E> intersectingNode(LinkedList<E> list1,
			LinkedList<E> list2) {
		int list1Size = 0;
		int list2Size = 0;
		for (Node<E> tmp = list1.getStart(); tmp != null; list1Size++, tmp = tmp
				.getNext())
			;
		for (Node<E> tmp = list2.getStart(); tmp != null; list2Size++, tmp = tmp
				.getNext())
			;
		Node<E> list1Start = list1.getStart();
		Node<E> list2Start = list2.getStart();
		int sizeDiff = Math.abs(list1Size - list2Size);
		if (list1Size > list2Size) {
			while (sizeDiff > 0) {
				list1Start = list1Start.getNext();
				sizeDiff--;
			}
		} else {
			while (sizeDiff > 0) {
				list2Start = list2Start.getNext();
				sizeDiff--;
			}
		}

		while (list1Start != null) {
			if (list1Start.getData().equals(list2Start.getData()))
				return list1Start;
			else {
				list1Start = list1Start.getNext();
				list2Start = list2Start.getNext();
			}
		}
		return null;
	}

	public static <E> void printReverseRecursive(LinkedList<E> list) {
		printReverseRecursive(list.getStart());
	}

	private static <E> void printReverseRecursive(Node<E> start) {
		if (start != null) {
			printReverseRecursive(start.getNext());
			System.out.println(start.getData());
		}
	}

	public static <E extends Comparable<E>> void printReverseNonRecursive(
			LinkedList<E> list) throws StackEmptyException {
		Stack<E> stack = new Stack<E>();
		int curIndex = 0;
		while (curIndex < list.size()) {
			stack.push(list.get(curIndex++));
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	public static <E extends Comparable<E>> LinkedList<E> partialReversal(
			LinkedList<E> list, int k) throws StackEmptyException {
		LinkedList<E> list2 = new LinkedList<E>();
		Stack<E> stack = new Stack<E>();
		int curIndex = 0;
		while (curIndex < list.size()) {
			if (stack.size() < k) {
				stack.push(list.get(curIndex++));
			} else {
				while (!stack.isEmpty()) {
					list2.insert(stack.pop());
				}
			}
		}
		while (!stack.isEmpty()) {
			list2.insert(stack.pop());
		}
		return list2;
	}

	public static <E> Node<E> findLoop(LinkedList<E> list) {
		Node<E> slowPointer = list.getStart();
		Node<E> fastPointer = list.getStart();
		do {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
		} while (slowPointer != fastPointer);
		slowPointer = list.getStart();
		while (slowPointer != fastPointer) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext();
		}
		return slowPointer;
	}

	public static <E> void deleteWithoutAccessToPreviousNode(Node<E> node) {
		Node<E> current = node;
		Node<E> next = current.getNext();
		current.setData(next.getData());
		current.setNext(next.getNext());
	}

}
