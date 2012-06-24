package com.promouit.list.domain;

public class Node<E> {
	private E data;
	private Node<E> next;

	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public Node<E> getNext() {
		return next;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	public void setData(E data) {
		this.data = data;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(!(obj instanceof Node))
			return false;
		@SuppressWarnings("unchecked" )
		Node<E> anotherNode = (Node<E>)obj;
		if(this.data!=null && anotherNode.data!=null){
			return this.data.equals(anotherNode.data);
		}else if(this.data==null && anotherNode.data==null){
			return true;
		}else{
			return false;
		}
	}
}