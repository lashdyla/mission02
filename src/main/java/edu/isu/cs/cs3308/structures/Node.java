package edu.isu.cs.cs3308.structures;

/**
 * Node class for list implementation
 *
 * @author Dylan Lasher
 * @param <E> any node type
 */

public class Node<E>
{

	// Data stored in node
	private E data;

	// Stores next node
	private Node<E> next;

	/**
	 * Constructor with data parameter
	 * @param data Node stores
	 */
	public Node(E data) {
		this.data = data;
	}

	/**
	 * Get data stored in Node
	 * @return data node currently storing
	 */
	public E getData() {
		return data;
	}

	/**
	 * Set data for Node
	 * @param data node stores
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * Get Node stored as next in List.
	 * @return Node that is currently stored in next
	 */
	public Node<E> getNext() {
		return next;
	}

	/**
	 * Set Node as next in List.
	 * @param next Node
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}
}
