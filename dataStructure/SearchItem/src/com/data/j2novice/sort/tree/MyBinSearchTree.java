package com.data.j2novice.sort.tree;

public class MyBinSearchTree<E extends Comparable<E>> {
	// ��
	private TreeNode<E> root;

	public MyBinSearchTree() {
	}

	// ����������
	public boolean search(E e) {
		TreeNode<E> current = root;
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else {
				return true;
			}

		}
		return false;
	}

	public boolean insert(E e) {
		if (null == root) {
			createNewNode(e);
		} else {
			// ����ʹӸ��ڵ㿪ʼ������ֱ���ҵ����ʵĸ��ڵ�
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (null != current) {
				if (e.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				} else if (e.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				} else {
					return false;
				}

			}
			// ����
			if (e.compareTo(parent.element) < 0) {
				parent.left = createNewNode(e);
			} else {
				parent.right = createNewNode(e);
			}
		}
		return true;
	}

	// �����µĽڵ�
	protected TreeNode<E> createNewNode(E e) {
		return new TreeNode(e);
	}

	// ����������ɾ���ڵ�
	public boolean delete(E e) {

		TreeNode<E> parent = null;
		TreeNode<E> current = root;

		// �ҵ�Ҫɾ���Ľڵ��λ��
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			} else {
				break;
			}
		}

		// û�ҵ�Ҫɾ���Ľڵ�
		if (current == null) {
			return false;
		}

		// ���ǵ�һ�����
		if (current.left == null) {
			if (parent == null) {
				root = current.right;
			} else {
				if (e.compareTo(parent.element) < 0) {
					parent.left = current.right;
				} else {
					parent.right = current.right;
				}
			}
		} else { // ���ǵڶ������
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;
			// �ҵ�������������Ԫ�ؽڵ�
			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right;
			}

			// �滻
			current.element = rightMost.element;

			// parentOfRightMost��rightMost��������
			if (parentOfRightMost.right == rightMost) {
				parentOfRightMost.right = rightMost.left;
			} else {
				parentOfRightMost.left = rightMost.left;
			}
		}

		return true;
	}
}