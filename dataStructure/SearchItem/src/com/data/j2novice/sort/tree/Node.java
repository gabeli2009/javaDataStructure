package com.data.j2novice.sort.tree;

public class Node<E> {
	E item;
	Node<E> next;
	
	Node(E element){
		item = element;
		next = null;
	}
}
