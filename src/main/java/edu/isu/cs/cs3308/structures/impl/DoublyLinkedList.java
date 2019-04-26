package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;
import edu.isu.cs.cs3308.structures.Node2;

/**
 * @author Dylan Lasher
 * @param <E> any type of list
 */
public class DoublyLinkedList<E> implements List<E>
{

	// Head node for List
	protected Node2<E> head = null;

	// Tail node for List
	protected Node2<E> tail = null;

	// Count of the nodes in List
	protected int size = 0;

	/**
	 * Checks if element is null
	 * @param element to check
	 * @return true if not null, false if null
	 */
	private boolean checkElement(E element)
	{
		return (element != null) ? true : false;
	}

	/**
	 * Checks if index is within 0 and size
	 * @param index to check
	 * @return true if valid index, false if invalid
	 */
	private boolean checkIndex(int index) {
		return (index < size && index >= 0) ? true : false;
	}

	/**
	 * Fix the head and tail of the list
	 * @param theNode to set if its the only one in the list
	 */
	private void singleHeadTail(Node2<E> theNode)
	{
		// if only one in list
		if (size == 1)
		{
			head = theNode;
			tail = theNode;
		}
		// else,  no nodes in list
		else if (size == 0)
		{
			head = null;
			tail = null;
		}
	}

	/**
	 * Get node from list with specific index
	 * @param index within the list
	 * @return node retrieved from list
	 */
	private Node2<E> getNode(int index)
	{
		Node2<E> seekNode = head;

		for (int i = 0; i < index; i++)
		{
			seekNode = seekNode.getNext();
		}

		return seekNode;
	}

	/**
	 * Add 1 to size value
	 */
	private void addSize() {
		size++;
	}

	/**
	 * Subtracts 1 from size value
	 */
	private void subSize()
	{
		size--;

		if (size < 0) //cannot drop below min of 0
		{
			size = 0;
		}
	}

	/**
	 * Get data from first list node
	 * @return data in the head node, if none then null
	 */
	@Override
	public E first() {
		return (head != null) ? head.getData() : null;
	}

	/**
	 * Get data from last node in list
	 * @return data in the tail node, if none then null
	 */
	@Override
	public E last() {
		return (tail != null) ? tail.getData() : null;
	}

	/**
	 * Creates node with given element data to list end
	 * @param element data to store in last list node
	 */
	@Override
	public void addLast(E element)
	{
		// check if null element
		if (checkElement(element))
		{
			// check if nonzero size
			if (!isEmpty())
			{
				// create new node
				Node2<E> lastNode = new Node2<>(element);

				// set next to null
				lastNode.setNext(null);

				// set previous
				lastNode.setPrev(tail);

				tail.setNext(lastNode);

				// change tail to new node
				tail = lastNode;

				// increment size
				addSize();
			}
			else {
				addFirst(element);
			}
		}
	}

	/**
	 * Creates node with given element data to list beginning
	 * @param element eata to store in first node
	 */
	@Override
	public void addFirst(E element)
	{
		// check if the element is null
		if (checkElement(element))
		{
			// create new node
			Node2<E> firstNode = new Node2<>(element);

			if (size > 0)
			{
				firstNode.setNext(head);

				firstNode.setPrev(null);
			}
			else {
				firstNode.setNext(null);

				firstNode.setPrev(null);
			}

			// change head to the new node
			head = firstNode;

			// increment size
			addSize();

			singleHeadTail(firstNode);
		}
	}

	/**
	 * Removes first node in list
	 * @return data stored in to-be-removed node
	 */
	@Override
	public E removeFirst()
	{
		if (head != null)
		{
			if (size > 1)
			{

				// Track original head
				Node2<E> removeNode = head;

				// Set new head to next
				head = removeNode.getNext();

				removeNode.setNext(null);
				removeNode.setPrev(null);

				// decrement size
				subSize();

				singleHeadTail(head);

				// return original head data
				return removeNode.getData();
			}
			else {
				Node2<E> removeNode = head;
				head.setNext(null);
				head.setPrev(null);
				head = null;
				tail = null;

				// decrement size
				subSize();

				singleHeadTail(head);

				// return data
				return removeNode.getData();
			}
		}
		else {
			return null;
		}
	}

	/**
	 * Remove last node in list
	 * @return data stored in to-be-removed node
	 */
	@Override
	public E removeLast()
	{
		if (size > 1)
		{
			return remove(size - 1);
		}

		else {
			return removeFirst();
		}
	}

	/**
	 * Create node with  given element data, insert node
	 * into list at given index
	 * @param element data to store in node
	 * @param index in list where node is inserted
	 */
	@Override
	public void insert(E element, int index)
	{
		if (checkElement(element))
		{
			if (index == 0)
			{
				addFirst(element);
			}

			else if (index >= size)
			{
				addLast(element);
			}

			else {
				if (checkIndex(index))
				{
					Node2<E> prevNode = getNode(index-1);
					Node2<E> insertNode = new Node2<>(element);
					insertNode.setNext(prevNode.getNext());
					insertNode.setPrev(prevNode);
					prevNode.setNext(insertNode);

					// increment size
					addSize();
				}
			}
		}
	}

	/**
	 * Removes given node from list
	 * @param index of node in list to remove
	 * @return data stored within to-be-removed node
	 */
	@Override
	public E remove(int index)
	{
		if (checkIndex(index))
		{
			if (index == 0)
			{
				return removeFirst();
			}
			else {
				Node2<E> prevNode = getNode(index-1);
				Node2<E> removeNode = prevNode.getNext();
				prevNode.setNext(removeNode.getNext());
				removeNode.setNext(null);
				removeNode.setPrev(null);

				// decrement size
				subSize();

				singleHeadTail(prevNode);

				return removeNode.getData();
			}
		}

		else {
			return null;
		}
	}

	/**
	 * Get data in node from list at given index
	 * @param index of node in list
	 * @return data stored in to-be-retrieved node
	 */
	@Override
	public E get(int index)
	{
		if (checkIndex(index))
		{
			if (index == 0)
			{
				return head.getData();
			}

			else if (index == size-1)
			{
				return tail.getData();
			}
			else {
				return getNode(index).getData();
			}
		}
		else {
			return null;
		}
	}

	/**
	 * Stored value which contains number of nodes in list
	 * @return count of nodes in list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Determines if list is empty
	 * @return True if list is empty, false if size != 0
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0) ? true : false;
	}

	/**
	 * For each node in the list, print related index on a new line
	 */
	@Override
	public void printList()
	{
		if (!isEmpty())
		{
			Node2<E> printNode = head;

			for (int i = 0; i < size; i++)
			{
				System.out.println(printNode.getData());
				printNode = printNode.getNext();
			}
		}
		else {
			System.out.println("The list is empty.");
		}
	}
}
