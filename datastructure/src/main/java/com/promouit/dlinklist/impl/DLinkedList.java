package com.promouit.dlinklist.impl;

import com.promouit.dlinklist.api.DList;
import com.promouit.dlinklist.domain.Node;

public class DLinkedList<E> implements DList<E>{

	private Node<E> start;
	private Node<E> end;
	private int size;
	
	public void insert(E data) {
		Node<E> node = createNode(data);
		if(start == null){
			start = end = node;
		}else{
			end.setNext(node);
			node.setPrevious(end);
			end = node;
		}
		size++;
	}

	private Node<E> createNode(E data) {
		return new Node<E>(data);
	}

	public void deleteAtPosition(int position) {
		if(position > size-1)
			throw new IndexOutOfBoundsException();
		Node<E> tmp = start;
		Node<E> prv = null;
		while(position>0){
			prv = tmp;
			tmp = tmp.getNext();
			position--;
		}
		if(tmp == start){
			start = start.getNext();
			start.setPrevious(null);
		}else{
			prv.setNext(tmp.getNext());
		}

		if(tmp==end){
			end = prv;
		}else{
			tmp.getNext().setPrevious(prv);
		}
		tmp.setNext(null);
		tmp.setPrevious(null);
		size--;
	}

	public E get(int position) {
		if(position > size-1)
			throw new IndexOutOfBoundsException();
		Node<E> tmp = start;
		while(position>0){
			tmp = tmp.getNext();
			position--;
		}
		return tmp.getData();
	}

	public void delete(E data) {
		Node<E> tmp = start;
		Node<E> prv = null;
		while(tmp!=null){
			if(tmp.getData().equals(data)){
				if(tmp == start){
					start = start.getNext();
					start.setPrevious(null);
				}else{
					prv.setNext(tmp.getNext());
				}
				if(tmp==end){
					end = prv;
				}else{
					tmp.getNext().setPrevious(prv);
				}
				Node<E> nodeToRemove = tmp;
				tmp = tmp.getNext();
				nodeToRemove.setNext(null);
				nodeToRemove.setPrevious(null);
				size--;
			}else{
				prv=tmp;
				tmp = tmp.getNext();
			}
		}
		
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public boolean contains(E data) {
		for(Node<E> tmp = start; tmp!=null; tmp = tmp.getNext()){
			if(tmp.getData().equals(data))
				return true;
		}
		return false;
	}

}
