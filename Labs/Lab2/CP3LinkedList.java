package Lab2;

import java.util.NoSuchElementException;
//singly linked list with first reference only 

/**
A linked list is a sequence of links with efficient
element insertion and removal. This class 
contains a subset of the methods of the standard
java.util.LinkedList class.
*/

public class CP3LinkedList<E> {


     private class Node {
		public E data;
		public Node next;
		public Node prev;
	}
	 private Node first;
	 private Node last; //added in Q4 as we need last node
	/**
    	Constructs an empty linked list.
	*/
	public CP3LinkedList()
	{
		first = null;
	}

	/**
 	Adds an element to the front of the linked list.
 	@param element the element to add
	 */
	public void addFirst(E element)
	{
		Node newLink = new Node();
		newLink.data = element;
		newLink.next = first;
		newLink.prev = null;

		if(first!= null){
			first.prev = newLink;
		}

		first = newLink;
		if(last == null){
			last = newLink;
		}
	}

	public E getFirst() {
		if (first == null)
			throw new NoSuchElementException();
		return first.data;
	}

	public E getLast() {
		if (last == null) {
			throw new NoSuchElementException();
		}
		return last.data;
	}

	public E removeFirst() {
		if (first == null)
			throw new NoSuchElementException();
		E element = first.data;
		first = first.next;

		if (first != null) {
			first.prev = null;
		} else {
			last = null;
		}
		return element;
	}

	public E removeLast() {
		if (last == null) {
			throw new NoSuchElementException();
		}

		E element = last.data;
		last = last.prev;

		if (last != null) {
			last.next = null;
		} else {
			first = null;
		}

		return element;
	}
		//Q4 addLast
	public void addLast(E element) {
		Node newLink = new Node();
		newLink.data = element;
		newLink.next = null;
		newLink.prev = last;

		if(last!=null){
			last.next = newLink;
		}
		last = newLink;

		if (last == null) {
			first = newLink;
		}
	}


	public void print(){
           //outputs the data on the list
		Node current = first;
		while (current != null){
			System.out.println(current.data);
			current = current.next;
		}
	}

	//Q1 add a method public int size()
	public int size() {
		int size = 0;
		Node current = first;
		while (current != null) {
			size++;
			current = current.next;
		}
		return size; // Return total size
	}

	//Q2 add a method contains
	public boolean contains(E value) {
		Node current = first;
		while (current != null) {
			if (current.data.equals(value)) {
				return true; // if  value is  found, return true
			}
			current = current.next;
		}
		return false; //if  value is not found, return false
	}

	public void printReverse() {
		Node current = last;
		while (current != null) {
			System.out.println(current.data);
			current = current.prev;
		}
	}

}
