package com.promouit.list.api;

public interface IList<E> {

	public void insert(E data);

	public void insert(E data, int position);

	public void delete(E data);

	public void deleteAtPosition(int position);
	
	public int size();
	
	public boolean isEmpty();
	
	public E get(int position);
	
}
