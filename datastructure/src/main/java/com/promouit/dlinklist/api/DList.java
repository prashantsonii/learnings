package com.promouit.dlinklist.api;

public interface DList<E> {
	
	void insert(E data);
	void deleteAtPosition(int position);
	E get(int position);
	void delete(E data);
	int size();
	boolean isEmpty();
	boolean contains(E data);
}
