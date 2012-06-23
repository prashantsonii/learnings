package com.promouit.list.impl;

import com.promouit.list.api.IList;
import com.promouit.list.domain.Node;

public class ArrayList<E> implements IList<E> {

	private Object[] arrays;
	private int currentCapacity;
	private int lastfilledindex = -1;
	private int defaultCapacityOfDataArray = 10;
	private int nextArrayIndex = 0;
	private int size;

	public ArrayList() {
		arrays = new Object[10];
		arrays[0] = new Object[defaultCapacityOfDataArray];
		currentCapacity = 10;
		nextArrayIndex = 1;
	}

	public void insert(E data) {
		Node<E> node = new Node<E>(data, null);
		ensureCapacity();
		int indexToBeFilled = lastfilledindex + 1;
		int arrayIndex = 0;
		for(; indexToBeFilled >= ((Object[])arrays[arrayIndex]).length; 
				indexToBeFilled-=((Object[])arrays[arrayIndex]).length, arrayIndex++);
		Object[] array = (Object[]) arrays[arrayIndex];
		array[indexToBeFilled] = node;
		lastfilledindex ++;
		size++;
	}

	public void insert(E data, int position) {
		throw new UnsupportedOperationException();
	}

	public void delete(E data) {
		throw new UnsupportedOperationException();
	}

	public void deleteAtPosition(int position) {
		if(position>size-1)
			throw new IndexOutOfBoundsException();
		int arrayIndex = 0;
		for(; position >= ((Object[])arrays[arrayIndex]).length; 
				position-=((Object[])arrays[arrayIndex]).length, arrayIndex++);
		Object[] oldArray = (Object[]) arrays[arrayIndex];
		Object[] newArray = new Object[oldArray.length - 1];
		arrays[arrayIndex] = newArray;
		for(int i = 0; i<position; i++){
			newArray[i] = oldArray[i];
		}
		for(int j = position +1; j < oldArray.length;j++){
			newArray[j-1] = oldArray[j];
		}
		lastfilledindex--;
		size--;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public E get(int position) {
		if(position>size-1)
			throw new IndexOutOfBoundsException();
		int arrayIndex = 0;
		for(; position >= ((Object[])arrays[arrayIndex]).length; 
				position-=((Object[])arrays[arrayIndex]).length, arrayIndex++);
		Object[] array = (Object[]) arrays[arrayIndex];
		@SuppressWarnings("unchecked")
		E data = ((Node<E>)array[position]).getData();
		return data;
	}

	private void ensureCapacity() {
		calculateCurrentCapacity();
		if(currentCapacity <= lastfilledindex+1){
			incrementCapacity();
		}
	}
	
	private void calculateCurrentCapacity() {
		int capacity = 0;
		for(Object array : arrays){
			if(array!=null){
				capacity+=((Object[])array).length;
			}
		}
		currentCapacity = capacity;
	}
	
	private void incrementCapacity() {
		if(nextArrayIndex == arrays.length){
			copyCurrentArrays();
		}
		arrays[nextArrayIndex] = new Object[defaultCapacityOfDataArray];
		nextArrayIndex++;
	}
	
	private void copyCurrentArrays() {
		Object[] newArrays = new Object[arrays.length*2];
		for(int i = 0 ; i < arrays.length ; i++){
			newArrays[i] = arrays[i];
		}
		arrays = newArrays;
	}
	
}
