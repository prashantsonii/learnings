package com.promouit.list.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.promouit.list.domain.Node;
import com.promouit.list.factory.LinkedListFactory;
import com.promouit.list.impl.LinkedList;
import com.promouit.stack.exception.StackEmptyException;
import com.promouit.stack.exception.StackFullException;

public class ListUtilsTest {

	@Test
	public void shouldTestIfLinkedListIsPallindrome()
			throws StackFullException, StackEmptyException {
		LinkedList<Integer> list = LinkedListFactory.getInstance(new int[] { 1,
				2, 3, 3, 2, 1 });
		assertTrue(ListUtils.isPalindrome(list));
		list = LinkedListFactory.getInstance(new int[] { 1, 2, 3, 4, 3, 2, 1 });
		assertTrue(ListUtils.isPalindrome(list));
	}

	
	@Test
	public void shouldTestIfLinkedListIsPallindromeV2() {
		LinkedList<Integer> list = LinkedListFactory.getInstance(new int[]{1,2,3,3,2,1});
		assertTrue(ListUtils.isPalindromeV2(list));
		list = LinkedListFactory.getInstance(new int[]{1,2,3,4,3,2,1});
		assertTrue(ListUtils.isPalindromeV2(list));
		list = LinkedListFactory.getInstance(new int[]{1,2,3,4,5,3,2,1});
		assertFalse(ListUtils.isPalindromeV2(list));
	}
	
	@Test
	public void shouldSumTwoLists() throws StackEmptyException {
		LinkedList<Integer> list1 = LinkedListFactory.getInstance(new int[]{1,2,3,4,5,6});
		LinkedList<Integer> list2 = LinkedListFactory.getInstance(new int[]{1,2,3,4});
		LinkedList<Integer> sumList = ListUtils.findSum(list1, list2);
		assertEquals("1,2,4,6,9,0,", sumList.toString());
	}
	
	@Test
	public void shouldFindNthNodeFromEnd() {
		LinkedList<Integer> list1 = LinkedListFactory.getInstance(new int[]{1,2,3,4,5,6,7,8,9});
		assertEquals(Integer.valueOf(6), ListUtils.nthNodeFromEnd(list1, 4));
	}
	
	@Test
	public void shouldFindTheIntersectionPoint() {
		LinkedList<Integer> list1 = LinkedListFactory.getInstance(new int[]{1,2,3,4,5,6,7,8,9,10});
		LinkedList<Integer> list2 = LinkedListFactory.prependToAt(list1, 3, new int[]{11,12,13,14,15});
		Node<Integer> intersectingNode = ListUtils.intersectingNode(list1, list2);
		assertEquals(Integer.valueOf(4), intersectingNode.getData());
	}
	
	@Test
	public void shouldPrintReverseRecursive() {
		LinkedList<Integer> list1 = LinkedListFactory.getInstance(new int[]{1,2,3,4,5,6,7,8,9});
		ListUtils.printReverseRecursive(list1);
	}

	@Test
	public void shouldPrintReverseNonRecursive() throws StackEmptyException {
		LinkedList<Integer> list1 = LinkedListFactory.getInstance(new int[]{1,2,3,4,5,6,7,8,9});
		ListUtils.printReverseNonRecursive(list1);
	}
	
	@Test
	public void shouldPartiallyReverse() throws StackEmptyException {
		LinkedList<Integer> list = LinkedListFactory.getInstance(new int[]{1,2,3,4,5,6,7,8,9});
		LinkedList<Integer> partialReversal = ListUtils.partialReversal(list, 2);
		assertEquals("2,1,4,3,6,5,8,7,9,", partialReversal.toString());
	}
	
	/*@Test
	public void shouldFindLoop() {
		LinkedList list = LinkedListFactory.linkedListWithLoop(new int[]{1,2,3,4,5,6,7,8,9},4);
		Node loopNode = ListUtils.findLoop(list);
		assertEquals(4, loopNode.getData());
	}*/
	
	@Test
	public void shouldDeleteWithoutAccessToStart() {
		LinkedList<Integer> list = LinkedListFactory.getInstance(new int[]{1,2,3,4,5,6,7,8,9});
		Node<Integer> node = list.getStart();
		int index = 4;
		while(index!=0){
			node = node.getNext();
			index--;
		}
		ListUtils.deleteWithoutAccessToPreviousNode(node);
		assertEquals("1,2,3,4,6,7,8,9,", list.toString());
	}

}
