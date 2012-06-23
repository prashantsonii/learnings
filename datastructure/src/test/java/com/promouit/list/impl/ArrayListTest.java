package com.promouit.list.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.promouit.list.api.IList;

public class ArrayListTest {

	@Test
	public void shouldCreate() {
		IList<Integer> integerList = new ArrayList<Integer>();
		assertNotNull(integerList);
		assertTrue(integerList.size()==0);
	}
	
	@Test
	public void shouldAddData() {
		IList<Integer> integerList = new ArrayList<Integer>();
		integerList.insert(1);
		assertTrue(integerList.size()==1);
		integerList.insert(5);
		assertTrue(integerList.size()==2);
	}
	
	@Test
	public void shouldAddBulkDataWhichSpansMultipleArrays() {
		IList<Integer> integerList = new ArrayList<Integer>();
		for(int i = 0 ; i < 50 ; i++)
			integerList.insert(i);
		assertTrue(integerList.size()==50);
	}
	
	@Test
	public void shouldDeleteData() {
		IList<Integer> integerList = new ArrayList<Integer>();
		integerList.insert(1);
		assertTrue(integerList.size()==1);
		integerList.deleteAtPosition(0);
		assertTrue(integerList.size()==0);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void shouldThrowExceptionWhenDeletePositionDoesnotExist() {
		IList<Integer> integerList = new ArrayList<Integer>();
		integerList.insert(1);
		assertTrue(integerList.size()==1);
		integerList.deleteAtPosition(0);
		assertTrue(integerList.size()==0);
		integerList.deleteAtPosition(0);
	}
	
	@Test
	public void shouldDeleteInBulk() {
		IList<Integer> integerList = new ArrayList<Integer>();
		for(int i = 0 ; i < 50 ; i++)
			integerList.insert(i);
		assertTrue(integerList.size()==50);
		for(int i = 0; i < 25; i++){
			integerList.deleteAtPosition(0);
			assertTrue(integerList.size()==(50-i-1));
		}
	}

	@Test
	public void shouldGetDataAtPosition() {
		IList<Integer> integerList = new ArrayList<Integer>();
		for(int i = 0 ; i < 50 ; i++)
			integerList.insert(i);
		assertTrue(integerList.size()==50);
		for(int i = 0; i <25; i++){
			assertTrue(integerList.get(i).equals(i));
		}
		for(int i = 0; i < 25; i++){
			integerList.deleteAtPosition(0);
			assertTrue(integerList.size()==(50-i-1));
		}
		for(int i = 0; i <25; i++){
			assertTrue(integerList.get(i).equals(i+25));
		}
	}
	
}
