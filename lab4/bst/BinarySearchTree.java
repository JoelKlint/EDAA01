package bst;

import java.util.Scanner;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
	int size;

	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {

	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * 
	 * @param x
	 *            element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if (root == null) {
			size++;
			root = new BinaryNode<E>(x);
			return true;
		} else {
			return add(root, x);
		}

	}

	private boolean add(BinaryNode<E> temp, E x) {
		int a = x.compareTo(temp.element);
		if (a == 0)
			return false;
		if (a > 0) {
			if (temp.right != null) {
				return add(temp.right, x);
			}
			size++;
			BinaryNode<E> node = new BinaryNode<E>(x);
			temp.right = node;
			return true;
		}

		else {
			if (temp.left != null) {
				return add(temp.left, x);
			}
			size++;
			BinaryNode<E> node = new BinaryNode<E>(x);
			temp.left = node;
			return true;
		}
	}

	/**
	 * Computes the height of tree.
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		return search(root);
	}

	private int search(BinaryNode<E> node) {
		if (node == null) {
			return 0;
		}
		int a = search(node.left);
		int b = search(node.right);
		if (a > b) {
			return a + 1;
		}
		return b + 1;
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}

	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		print(root);
	}

	private void print(BinaryNode<E> node) {
		if (node.left != null) {
			print(node.left);
		}
		System.out.println(node.element);

		if (node.right != null) {
			print(node.right);
		}
	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		E[] a = (E[]) new Comparable[size];
		int last = toArray(root, a, 0);
		root = buildTree(a, 0, last-1);
	}

	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index]. Returns the index of the last inserted element + 1
	 * (the first empty position in a).
	 */
	private int toArray(BinaryNode<E> n, E[] a, int index) {
		if (n != null) {
			index = toArray(n.left, a, index);
			a[index] = n.element;
			index++;
			index = toArray(n.right, a, index);
			return index;
		}
		return index;
	}

	/*
	 * Builds a complete tree from the elements a[first]..a[last]. Elements in
	 * the array a are assumed to be in ascending order. Returns the root of
	 * tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		if(first > last)	{
			return null;
		}
		int mid = (first + last + 1) / 2;
		BinaryNode<E> root = new BinaryNode(a[mid]);
		root.left = buildTree(a, first, mid - 1);
		root.right = buildTree(a, mid + 1, last);
		return root;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}
	}

}
