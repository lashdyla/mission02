package edu.isu.cs.cs3308.structures;

/**
 * Node2 class for List implementation
 *
 * @author Dylan Lasher
 * @param <E> any type of node
 */
public class Node2<E> {

	// Data stored in node.
	private E data;

	// Stores previous node
	private Node2<E> prev;

	// Stores next node
	private Node2<E> next;

	/**
	 * Constructor with data parameter
	 * @param data data Node2 stores
	 */
	public Node2(E data) {
		this.data = data;
	}

	/**
	 * Get data stored in Node2
	 * @return data node currently stores
	 */
	public E getData() {
		return data;
	}

	/**
	 * Set data stored in Node2
	 * @param data node stores
	 */
	public void setData(E data) {
		this.data = data;
	}


	/**
	 * Get Node stored as previous in List.
	 * @return node currently stored as previous
	 */
	public Node2<E> getPrev() {
		return prev;
	}

	/**
	 * Set Node2 prev storage
	 * @param prev Node2 previous to current node
	 */
	public void setPrev(Node2<E> prev) {
		this.prev = prev;
	}

	/**
	 * Get Node2 storage as next in List.
	 * @return Node2 that currently stores next attribute
	 */
	public Node2<E> getNext() {
		return next;
	}

	/**
	 * Set Node2 to be stored as next in List.
	 * @param next Node2 next to current node
	 */
	public void setNext(Node2<E> next) {
		this.next = next;
	}
}