package com.promouit.list.factory;

import com.promouit.list.domain.Node;
import com.promouit.list.impl.LinkedList;

public class LinkedListFactory {
	public static final LinkedList<Integer> getInstance(int[] data) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i : data) {
			list.insert(i);
		}
		return list;
	}
	
	public static LinkedList<Integer> prependToAt(LinkedList<Integer> list1, int position, int[] js) {
		LinkedList<Integer> list = getInstance(js);
		Node<Integer> start = list1.getStart();
		while(position>0){
			start = start.getNext();
			position--;
		}
		list.getEnd().setNext(start);
		return list;
	}

/*	public static LinkedList<Integer> linkedListWithLoop(int[] data, int loopPosition) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 0; i < loopPosition ; i++){
			list.insert(data[i]);
		}
		Node<Integer> end = list.getEnd();
		for(int i = loopPosition; i < data.length ; i++){
			list.insert(data[i]);
		}
		list.addData(end);
		return list;
	}*/
}
