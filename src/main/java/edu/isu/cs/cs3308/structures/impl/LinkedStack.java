package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Stack;

/**
 * A linked stack based on of a DLL
 *
 * @author Dylan Lasher
 * @param <E> any stack type
 */
public class LinkedStack<E> implements Stack<E> {

	// create DLL for the stack
	DoublyLinkedList<E> theList = new DoublyLinkedList<>();

	/**
	 * Add new element to stack at beginning
	 * @param element data to add to top, unless null
	 */
	@Override
	public void push(E element) {
		theList.addFirst(element);
	}

	/**
	 * See value at beginning without removing it
	 * @return value at beginning of stack
	 */
	@Override
	public E peek() {
		return theList.first();
	}

	/**
	 * Remove value at beginning of stack
	 * @return value at beginning of stack
	 */
	@Override
	public E pop() {
		return theList.removeFirst();
	}

	/**
	 * Get number of elements in stack
	 * @return Number of elements in stack
	 */
	@Override
	public int size() {
		return theList.size();
	}

	/**
	 * Determine if stack is empty
	 * @return True if stack is empty, else is false
	 */
	@Override
	public boolean isEmpty() {
		return theList.isEmpty();
	}

	/**
	 * Transfer all data from one stack to another,
	 * also reversing element order
	 * @param to to transfer to unless null
	 */
	@Override
	public void transfer(Stack<E> to)
	{
		// if stack is not null or empty
		if (to != null && this.size() > 0)
		{
			// loop through all elements
			while(this.size() > 0)
			{
				to.push(this.pop());
			}
		}
	}

	/**
	 *Reverse order of elements of stack
	 */
	@Override
	public void reverse()
	{
		// create 2 temp stacks
		LinkedStack<E> temp1 = new LinkedStack<>();
		LinkedStack<E> temp2 = new LinkedStack<>();

		// make reverse order through temps
		this.transfer(temp1);
		temp1.transfer(temp2);

		// send to original, now reversed
		temp2.transfer(this);
	}

	/**
	 * Copy other stack to end of this stack.
	 * @param other stack
	 */
	@Override
	public void merge(Stack<E> other)
	{
		if (other != null)
		{
			// temporary stacks
			LinkedStack<E> origCopy = new LinkedStack<>();
			LinkedStack<E> otherCopy = new LinkedStack<>();

			// transfer 2 temp stacks
			this.transfer(origCopy);
			other.transfer(otherCopy);

			while (otherCopy.size() > 0)
			{
				// get element to merge
				E tempElem = otherCopy.pop();

				// push element to each stack
				other.push(tempElem);
				this.push(tempElem);
			}

			// transfer rest of original stack
			origCopy.transfer(this);
		}
	}

	/**
	 * Prints stack contents
	 */
	@Override
	public void printStack() {
		theList.printList();
	}
}