package com.data.j2novice.sort.tree;

public class TreeNode<E> {
	E element;
	TreeNode<E> left;
	TreeNode<E> right;
	public TreeNode(E e){
		element = e;
	}
	 // �����µĽڵ�
	    protected TreeNode<E> createNewNode(E e) {
	        return new TreeNode(e);
	    }
	
}