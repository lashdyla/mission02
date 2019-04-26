package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;
import edu.isu.cs.cs3308.structures.Node;

/**
 * @author Dylan Lasher
 * @param <E> any list type
 */
public class SinglyLinkedList<E> implements List<E>
{

	// Head node for List
	protected Node<E> head = null;

	// Tail node for List
	protected Node<E> tail = null;

	// Node count for List
	protected int size = 0;

	/**
	 * Checks if given element is null
	 *
	 * @param element to check
	 * @return true if not null, false if null
	 */
	private boolean checkElement(E element)
	{
		return (element != null) ? true : false;
	}

	/**
	 * Check if given index is 0 or greater
	 *
	 * @param index to check
	 * @return true if valid index, false if invalid index
	 */
	private boolean checkIndex(int index)
	{
		return (index < size && index >= 0) ? true : false;
	}

	/**
	 * Fix the head and tail of list
	 *
	 * @param theNode to set if alone in list
	 */
	private void singleHeadTail(Node<E> theNode)
	{
		if (size == 1)
		{
			head = theNode;
			tail = theNode;
		} else if (size == 0)
		{
			head = null;
			tail = null;
		}
	}

	/**
	 * Get node from list given an index
	 *
	 * @param index within list
	 * @return The node retrieved from list
	 */
	private Node<E> getNode(int index)
	{
		Node<E> seekNode = head;

		for (int i = 0; i < index; i++)
		{
			seekNode = seekNode.getNext();
		}

		return seekNode;
	}

	/**
	 * Adds 1 to size value.
	 */
	private void addSize()
	{
		size++;
	}

	/**
	 * Subtracts 1 from size value
	 */
	private void subSize()
	{
		size--;

		if (size < 0) //Can't drop below 0
		{
			size = 0;
		}
	}

	/**
	 * Get data from first node list
	 *
	 * @return data in head node, none if null
	 */
	@Override
	public E first()
	{
		return (head != null) ? head.getData() : null;
	}

	/**
	 * Get data from last node
	 *
	 * @return data in tail node, none if null
	 */
	@Override
	public E last()
	{
		return (tail != null) ? tail.getData() : null;
	}

	/**
	 * Create node with given element data at list end
	 *
	 * @param element data to store in last node
	 */
	@Override
	public void addLast(E element)
	{
		if (checkElement(element))
		{
			if (!isEmpty())
			{
				// create the new node
				Node<E> lastNode = new Node<>(element);

				// set its next ref to null
				lastNode.setNext(null);

				// make original tail next to future tail
				tail.setNext(lastNode);

				// change tail to new node
				tail = lastNode;

				// increment size
				addSize();
			} else
			{
				addFirst(element);
			}
		}
	}

	/**
	 * Create node with given element data at list start
	 *
	 * @param element data to store in first node
	 */
	@Override
	public void addFirst(E element)
	{
		if (checkElement(element))
		{
			Node<E> firstNode = new Node<>(element);

			if (size > 0)
			{
				firstNode.setNext(head);
			} else
			{
				firstNode.setNext(null);
			}

			head = firstNode;

			// increment size
			addSize();

			singleHeadTail(firstNode);
		}
	}

	/**
	 * Removes first node in list
	 *
	 * @return data stored in to-be-removed node
	 */
	@Override
	public E removeFirst()
	{
		if (head != null)
		{
			if (size > 1)
			{
				Node<E> removeNode = head;
				head = removeNode.getNext();
				removeNode.setNext(null);

				// decrement size
				subSize();

				singleHeadTail(head);
				return removeNode.getData();
			} else
			{
				Node<E> removeNode = head;
				head.setNext(null);
				head = null;
				tail.setNext(null);
				tail = null;
				subSize();
				singleHeadTail(head);

				// return the data
				return removeNode.getData();
			}
		} else
		{
			return null;
		}
	}

	/**
	 * Remove last node in list
	 *
	 * @return data stored in to-be-removed node
	 */
	@Override
	public E removeLast()
	{
		if (size > 1)
		{
			return remove(size - 1);
		} else
		{
			return removeFirst();
		}
	}

	/**
	 * Create node with given element data, insert node
	 * into list at given index
	 *
	 * @param element data to store in node
	 * @param index   in list where node is inserted
	 */
	@Override
	public void insert(E element, int index)
	{
		if (checkElement(element))
		{
			if (index == 0)
			{
				addFirst(element);
			} else if (index >= size)
			{
				addLast(element);
			} else
			{
				if (checkIndex(index))
				{
					Node<E> prevNode = getNode(index - 1);
					Node<E> insertNode = new Node<>(element);
					insertNode.setNext(prevNode.getNext());
					prevNode.setNext(insertNode);
					addSize();
				}
			}
		}
	}

	/**
	 * Remove given node from list from given index
	 *
	 * @param index of node in list to remove
	 * @return data stored in to-be-removed node
	 */
	@Override
	public E remove(int index)
	{
		if (checkIndex(index))
		{
			if (index == 0)
			{
				return removeFirst();
			} else
			{
				Node<E> prevNode = getNode(index - 1);
				Node<E> removeNode = prevNode.getNext();
				prevNode.setNext(removeNode.getNext());
				removeNode.setNext(null);
				subSize();
				singleHeadTail(prevNode);

				return removeNode.getData();
			}
		} else
		{
			return null;
		}
	}

	/**
	 * Get data in node from list at given index
	 *
	 * @param index of node in list to retrieve
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
			} else if (index == size - 1)
			{
				return tail.getData();
			} else
			{
				return getNode(index).getData();
			}
		} else
		{
			return null;
		}
	}

	@Override
	public int size()
	{
		return size;
	}

	/**
	 * Determines if list is empty
	 *
	 * @return True if list is empty, false if size nonzero
	 */
	@Override
	public boolean isEmpty()
	{
		return (size == 0) ? true : false;
	}

	/**
	 * Print each node index on new line
	 */
	@Override
	public void printList()
	{
		if (!isEmpty())
		{
			Node<E> printNode = head;

			for (int i = 0; i < size; i++)
			{
				System.out.println(printNode.getData());

				printNode = printNode.getNext();
			}
		} else
		{
			System.out.println("There is nothing in this list.");
		}
	}
}