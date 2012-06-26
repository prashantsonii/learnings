package com.promouit.dlist.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularDLinkedListTest {

	@Test
	public void shouldCreate() {
		CircularDLinkedList<Integer> circularList = new CircularDLinkedList<Integer>();
		assertNotNull(circularList);
		assertEquals(0, circularList.size());
	}

	@Test
	public void shouldAddInList() {
		CircularDLinkedList<Integer> circularList = new CircularDLinkedList<Integer>();
		for (int i = 0; i < 100; i++)
			circularList.insert(i * 100);
		assertEquals(100, circularList.size());
	}

	@Test
	public void shouldDeleteAtPosition() {
		CircularDLinkedList<Integer> circularList = new CircularDLinkedList<Integer>();
		for (int i = 0; i < 100; i++)
			circularList.insert(i * 100);
		assertEquals(100, circularList.size());
		circularList.deleteAtPosition(0);
		assertEquals(99, circularList.size());
		circularList.deleteAtPosition(98);
		assertEquals(98, circularList.size());
		circularList.deleteAtPosition(50);
		assertEquals(97, circularList.size());
	}
	
	@Test
	public void shouldContainData() {
		CircularDLinkedList<Integer> circularList = new CircularDLinkedList<Integer>();
		for (int i = 0; i < 100; i++)
			circularList.insert(i * 100);
		assertEquals(100, circularList.size());
		assertTrue(circularList.contains(0));
		assertTrue(circularList.contains(9900));
		assertTrue(circularList.contains(5000));
		assertFalse(circularList.contains(10));
	}

	@Test
	public void shouldDeleteData() {
		CircularDLinkedList<Integer> circularList = new CircularDLinkedList<Integer>();
		for (int i = 0; i < 100; i++)
			circularList.insert(i * 100);
		assertEquals(100, circularList.size());
		assertTrue(circularList.contains(0));
		circularList.delete(0);
		assertEquals(99, circularList.size());
		assertFalse(circularList.contains(0));
		assertTrue(circularList.contains(9900));
		circularList.delete(9900);
		assertFalse(circularList.contains(9900));
		assertTrue(circularList.contains(5000));
		circularList.delete(5000);
		assertFalse(circularList.contains(5000));
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void shouldThrowExceptionForIndexGreaterThanSize() {
		CircularDLinkedList<Integer> circularList = new CircularDLinkedList<Integer>();
		for (int i = 0; i < 100; i++)
			circularList.insert(i * 100);
		circularList.deleteAtPosition(1000);
	}
	
	@Test
	public void shouldGetDataAtPosition() {
		CircularDLinkedList<Integer> circularList = new CircularDLinkedList<Integer>();
		circularList.insert(1);
		circularList.insert(2);
		circularList.insert(3);
		circularList.insert(4);
		assertEquals(4, circularList.size());
		assertEquals(Integer.valueOf(1), circularList.get(0));
		assertEquals(Integer.valueOf(2), circularList.get(1));
		assertEquals(Integer.valueOf(3), circularList.get(2));
		assertEquals(Integer.valueOf(4), circularList.get(3));
		circularList.deleteAtPosition(0);
		assertEquals(Integer.valueOf(2), circularList.get(0));
		assertEquals(Integer.valueOf(3), circularList.get(1));
		assertEquals(Integer.valueOf(4), circularList.get(2));
	}
}
