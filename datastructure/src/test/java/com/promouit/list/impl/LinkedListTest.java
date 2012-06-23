package com.promouit.list.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.promouit.list.api.IList;

public class LinkedListTest {

	@Test
	public void shouldCreate() {
		IList<Integer> listOfIntegers = new LinkedList<Integer>();
		assertNotNull(listOfIntegers);
		assertEquals(0, listOfIntegers.size());
	}

	@Test
	public void shouldAddData() {
		IList<Integer> listOfIntegers = new LinkedList<Integer>();
		listOfIntegers.insert(1);
		assertEquals(1, listOfIntegers.size());
		listOfIntegers.insert(3);
		assertEquals(2, listOfIntegers.size());
	}
	
	@Test
	public void shouldDeleteData() {
		IList<Integer> listOfIntegers = new LinkedList<Integer>();
		listOfIntegers.insert(1);
		listOfIntegers.insert(3);
		listOfIntegers.insert(3);
		listOfIntegers.insert(2);
		assertEquals(4, listOfIntegers.size());
		listOfIntegers.delete(new Integer(1));
		assertEquals(3, listOfIntegers.size());
		listOfIntegers.delete(new Integer(3));
		assertEquals(1, listOfIntegers.size());
	}
	
	@Test
	public void shouldDeleteDataAtPosition() {
		IList<Integer> listOfIntegers = new LinkedList<Integer>();
		listOfIntegers.insert(1);
		listOfIntegers.insert(3);
		listOfIntegers.insert(3);
		listOfIntegers.insert(2);
		assertEquals(4, listOfIntegers.size());
		listOfIntegers.deleteAtPosition(0);
		assertEquals(3, listOfIntegers.size());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void shouldThrowException() {
		IList<Integer> listOfIntegers = new LinkedList<Integer>();
		listOfIntegers.insert(1);
		listOfIntegers.insert(3);
		listOfIntegers.insert(3);
		listOfIntegers.insert(2);
		assertEquals(4, listOfIntegers.size());
		listOfIntegers.deleteAtPosition(4);
	}
	
	@Test
	public void shouldInsertDataAtPosition() {
		IList<Integer> listOfIntegers = new LinkedList<Integer>();
		listOfIntegers.insert(1);
		listOfIntegers.insert(3);
		listOfIntegers.insert(3);
		listOfIntegers.insert(2);
		assertEquals(4, listOfIntegers.size());
		listOfIntegers.insert(4, 2);
		assertEquals(5, listOfIntegers.size());
		listOfIntegers.insert(6, 3);
		assertEquals(6, listOfIntegers.size());
		assertEquals(Integer.valueOf(4), listOfIntegers.get(2));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void shouldThrowExceptionWhenIndexExceedsSize() {
		IList<Integer> listOfIntegers = new LinkedList<Integer>();
		listOfIntegers.insert(1);
		listOfIntegers.insert(3);
		listOfIntegers.insert(3);
		listOfIntegers.insert(2);
		assertEquals(4, listOfIntegers.size());
		listOfIntegers.insert(4, 4);
	}
}
