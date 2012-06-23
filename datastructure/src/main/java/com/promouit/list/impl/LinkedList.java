package com.promouit.list.impl;

import com.promouit.list.api.IList;
import com.promouit.list.domain.Node;

public class LinkedList<E> implements IList<E> {

	private int size;

	private Node<E> start;
	private Node<E> end;

	public void insert(E data) {
		Node<E> node = new Node<E>(data, null);
		if (start == null) {
			start = end = node;
		} else {
			end.setNext(node);
			end = node;
		}
		size++;
	}

	public void insert(E data, int position) {
		if (position > size - 1)
			throw new IndexOutOfBoundsException();
		Node<E> node = new Node<E>(data, null);
		Node<E> temp = start;
		Node<E> prv = null;
		while (position > 0) {
			prv = temp;
			temp = temp.getNext();
			position--;
		}
		if(temp==start){
			node.setNext(start);
			start = node;
		}else{
			node.setNext(prv.getNext());
			prv.setNext(node);
		}
		if(prv==end){
			end = node;
		}
		size++;
	}

	public void delete(E data) {
		Node<E> temp = start;
		Node<E> prv = null;
		while(temp!=null){
			if(temp.getData().equals(data)){
				Node<E> nodeToDelete = temp;
				if(temp == start){
					start = start.getNext();
				}else{
					prv.setNext(temp.getNext());
				}
				temp=temp.getNext();
				nodeToDelete.setNext(null);
				size--;
			}else{
				prv = temp;
				temp = temp.getNext();
			}
		}
	}

	public void deleteAtPosition(int position) {
		if (position > size - 1)
			throw new IndexOutOfBoundsException();
		Node<E> temp = start;
		Node<E> prv = null;
		while (position > 0) {
			prv = temp;
			temp = temp.getNext();
			position--;
		}
		if(temp==start){
			start=start.getNext();
			temp.setNext(null);
		}else{
			prv.setNext(temp.getNext());
		}
		if(temp==end){
			end = prv;;
		}
		size--;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E get(int position) {
		if (position > size - 1)
			throw new IndexOutOfBoundsException();
		Node<E> temp = start;
		while (position > 0) {
			temp = temp.getNext();
			position--;
		}
		return temp.getData();
	}
}
