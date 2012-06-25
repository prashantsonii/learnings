package com.promouit.dlist.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.promouit.dlist.impl.DLinkedList;

public class DListUtilsTest {

	@Test
	public void shouldReverse() {
		DLinkedList<Integer> dLinkedList = DListFactory.createDoublyLinkedList(1,2,3,4,5,6);
		assertEquals("1,2,3,4,5,6,", dLinkedList.toString());
		DListUtils.reverseDList(dLinkedList);
		assertEquals("6,5,4,3,2,1,", dLinkedList.toString());
	}

	@Test
	public void shouldReverse2() {
		DLinkedList<Integer> dLinkedList = DListFactory.createDoublyLinkedList(1);
		assertEquals("1,", dLinkedList.toString());
		DListUtils.reverseDList(dLinkedList);
		assertEquals("1,", dLinkedList.toString());
	}
}
