package com.promouit.dlinklist.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.promouit.dlinklist.api.DList;

public class DLinkedListTest {

	@Test
	public void shouldCreate() {
		DList<Integer> dlist = new DLinkedList<Integer>();
		assertNotNull(dlist);
		assertEquals(0, dlist.size());
	}

	@Test
	public void shouldAddData() {
		DList<Integer> dlist = new DLinkedList<Integer>();
		assertEquals(0, dlist.size());
		dlist.insert(1);
		assertEquals(1, dlist.size());
		dlist.insert(10);
		assertEquals(2, dlist.size());
	}
	
	@Test
	public void shouldCheckContains() {
		DList<Integer> dlist = new DLinkedList<Integer>();
		dlist.insert(1);
		dlist.insert(2);
		dlist.insert(3);
		dlist.insert(4);
		assertTrue(dlist.contains(1));
		assertTrue(dlist.contains(4));
		assertTrue(dlist.contains(2));
		assertFalse(dlist.contains(5));
	}
	
	@Test
	public void shouldDeleteAtPosition() {
		DList<Integer> dlist = new DLinkedList<Integer>();
		dlist.insert(1);
		dlist.insert(2);
		dlist.insert(3);
		dlist.insert(4);
		assertTrue(dlist.size() == 4);
		dlist.deleteAtPosition(2);
		assertTrue(dlist.size() == 3);
		assertFalse(dlist.contains(3));

		dlist.deleteAtPosition(2);
		assertTrue(dlist.size() == 2);
		assertFalse(dlist.contains(4));

		dlist.deleteAtPosition(0);
		assertTrue(dlist.size() == 1);
		assertFalse(dlist.contains(1));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void shouldThrowIndexOutOfBoundException() {
		DList<Integer> dlist = new DLinkedList<Integer>();
		dlist.insert(1);
		dlist.insert(2);
		dlist.insert(3);
		dlist.insert(4);
		assertTrue(dlist.size() == 4);
		dlist.deleteAtPosition(4);
	}
	
	@Test
	public void shouldDelete() {
		DList<Integer> dlist = new DLinkedList<Integer>();
		dlist.insert(1);
		dlist.insert(2);
		dlist.insert(4);
		dlist.insert(4);
		assertTrue(dlist.size() == 4);
		dlist.delete(4);
		assertTrue(dlist.size() == 2);
		assertFalse(dlist.contains(4));
	}
	
	@Test
	public void shouldGetDataAtPosition() {
		DList<Integer> dlist = new DLinkedList<Integer>();
		dlist.insert(1);
		dlist.insert(2);
		dlist.insert(3);
		dlist.insert(4);
		assertTrue(1==dlist.get(0));
		dlist.deleteAtPosition(0);
		assertTrue(2==dlist.get(0));
	}
}
