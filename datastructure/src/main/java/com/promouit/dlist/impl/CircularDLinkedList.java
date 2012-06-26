package com.promouit.dlist.impl;

import com.promouit.dlist.api.DList;
import com.promouit.dlist.domain.Node;

public class CircularDLinkedList<E> implements DList<E> {
	
	private Node<E> startNode;
	private Node<E> endNode;
	private int size;

	public void insert(E data) {
		Node<E> node = new Node<E>(data);
		if(startNode==null){
			startNode = endNode = node;
		}else{
			endNode.setNext(node);
			node.setPrevious(endNode);
			endNode = node;
		}
		node.setNext(startNode);
		startNode.setPrevious(node);
		size++;
	}

	public Node<E> insertAndReturnNode(E data) {
		Node<E> node = new Node<E>(data);
		if(startNode==null){
			startNode = endNode = node;
		}else{
			endNode.setNext(node);
			node.setPrevious(endNode);
			endNode = node;
		}
		node.setNext(startNode);
		startNode.setPrevious(node);
		size++;
		return node;
	}
	
	public void deleteAtPosition(int position) {
		if(position > size - 1)
			throw new IndexOutOfBoundsException();
		Node<E> prv = null;
		Node<E> tmp = startNode;
		while(position>0){
			position--;
			prv = tmp;
			tmp = tmp.getNext();
		}
		if(tmp==startNode&&tmp==endNode){
			startNode = endNode = null;
		}else if(tmp==startNode){
			startNode = startNode.getNext();
			endNode.setNext(startNode);
			startNode.setPrevious(endNode);
			
		}else if(tmp==endNode){
			endNode = prv;
			endNode.setNext(startNode);
			startNode.setPrevious(endNode);
		}else{
			prv.setNext(tmp.getNext());
			tmp.getNext().setPrevious(prv);
		}
		tmp.setNext(null);
		tmp.setPrevious(null);
		size--;
	}

	public E get(int position) {
		if(position > size - 1)
			throw new IndexOutOfBoundsException();
		Node<E> tmp = startNode;
		while(position>0){
			position--;
			tmp = tmp.getNext();
		}
		return tmp.getData();
	}

	public void delete(E data) {
		Node<E> tmp = startNode;
		Node<E> prv = null;
		int numberOfNodesDeleted = 0;
		for(int i = 0; i < size; i++){
			if(tmp.getData().equals(data)){
				if(tmp==startNode&&tmp==endNode){
					startNode = endNode = null;
				}else if(tmp==startNode){
					startNode = startNode.getNext();
					endNode.setNext(startNode);
					startNode.setPrevious(endNode);
					
				}else if(tmp==endNode){
					endNode = prv;
					endNode.setNext(startNode);
					startNode.setPrevious(endNode);
				}else{
					prv.setNext(tmp.getNext());
					tmp.getNext().setPrevious(prv);
				}
				Node<E> nodeToDelete = tmp;
				tmp = tmp.getNext();
				nodeToDelete.setNext(null);
				nodeToDelete.setPrevious(null);
				numberOfNodesDeleted++;
			}else{
				prv = tmp;
				tmp = tmp.getNext();
			}
		}
		size-=numberOfNodesDeleted;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(E data) {
		Node<E> tmp = startNode;
		for(int i =0; i<size; i++, tmp = tmp.getNext()){
			if(tmp.getData().equals(data))
				return true;
		}
		return false;
	}

}
