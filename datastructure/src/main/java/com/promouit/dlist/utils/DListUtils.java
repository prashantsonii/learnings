package com.promouit.dlist.utils;

import com.promouit.dlist.domain.Node;
import com.promouit.dlist.impl.DLinkedList;

public class DListUtils {

	public static <E> void reverseDList(DLinkedList<E> dlist) {
		Node<E> previousNode = null;
		Node<E> currentNode = dlist.getStart();
		Node<E> nextNode = currentNode.getNext();
		while (currentNode != null) {
			currentNode.setNext(previousNode);
			if (previousNode != null) {
				previousNode.setPrevious(currentNode);
			}
			previousNode = currentNode;
			currentNode = nextNode;
			if(nextNode!=null)
				nextNode = currentNode.getNext();
		}
		
		Node<E> tmp = dlist.getStart();
		dlist.setStart(dlist.getEnd());
		dlist.setEnd(tmp);
	}

}
