package com.promouit.dlist.utils;

import com.promouit.dlist.impl.DLinkedList;

public class DListFactory {
	public static DLinkedList<Integer> createDoublyLinkedList(Integer... data) {
		DLinkedList<Integer> listOfIntegers = new DLinkedList<Integer>();
		for (Integer integer : data) {
			listOfIntegers.insert(integer);
		}
		return listOfIntegers;
	}
}
