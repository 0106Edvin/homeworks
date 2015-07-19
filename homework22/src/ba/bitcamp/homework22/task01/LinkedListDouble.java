package ba.bitcamp.homework22.task01;

import java.util.NoSuchElementException;

public class LinkedListDouble {

	/**
	 * creating a node start which represents a head of node
	 */
	private Node start;

	/**
	 * creating an empty constructor
	 */
	public LinkedListDouble() {

	}

	public LinkedListDouble(LinkedListDouble list) {
		super();
		for (int i = 0; i < list.size(); i++) {
			add(list.get(i));
		}
	}

	/**
	 * Creating a Node class with double value and Node next which is pointing
	 * to next Node
	 * 
	 * @author User
	 *
	 */
	public class Node {

		private Double value;
		private Node next;

		/**
		 * constructor for Node class
		 * 
		 * @param value
		 *            a number that user insert
		 */
		public Node(Double value) {
			super();
			this.value = value;
			next = null;
		}

		/**
		 * setters and getters for value and next
		 * 
		 * @return
		 */

		public Double getValue() {
			return value;
		}

		public void setValue(Double value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		/**
		 * to string method for class Node
		 */

		public String toString() {

			if (next == null) {
				return String.valueOf(value);
			}
			return value + " " + next.toString();

		}

	}

	/**
	 * a method which adds a numbers to stack
	 * 
	 * @param element
	 *            number that needs to be added
	 * @return
	 */

	public void add(Double element) {

		/**
		 * when stack is empty just create a new node and make it a start node
		 */
		if (start == null) {
			start = new Node(element);
			return;

		}
		/**
		 * if stack is not empty, create new node with value and add that node
		 * at the end of stack
		 */

		Node tmp = start;

		while (tmp.getNext() != null) {

			tmp = tmp.getNext();
		}

		tmp.setNext(new Node(element));
	}

	/**
	 * removing element from index
	 * 
	 * @param index
	 */

	public void remove(int index) {

		if (start == null) {
			return;

		}
		if (index < 0 || index > size()) {
			throw new IllegalArgumentException();
		}

		Node previous = start;

		for (int i = 0; i < index - 1; i++) {

			previous = previous.getNext();
		}

		Node tmp = previous.getNext();
		previous.setNext(tmp.getNext());
	}

	/**
	 * finding a node by index
	 * 
	 * @param index
	 *            on which is a node we want
	 * @return
	 */

	public Double get(int index) {
		if (start == null) {
			return null;
		}
		Node tmp = start;

		for (int i = 0; i < index; i++) {
			tmp = tmp.getNext();
		}

		return tmp.getValue();

	}

	/**
	 * finding a size of a stack
	 * 
	 * @return
	 */
	public int size() {
		int size = 0;

		Node tmp = start;

		while (tmp != null) {
			size++;
			tmp = tmp.getNext();
		}
		return size;

	}

	/**
	 * finding a middle element
	 * 
	 * @return
	 */
	public Double middle() {

		return get((size() - 1) / 2);

	}

	public Double getFirst() throws NoSuchElementException {
		if (start == null) {
			throw new NoSuchElementException();
		} else {
			return start.getValue();
		}
	}

	public Double getLast() throws NoSuchElementException {

		int currentSize = size();

		if ((start == null) || (currentSize == 0)) {
			throw new NoSuchElementException();
		} else {
			return get(currentSize - 1);
		}
	}

	public void deleteFirst() throws NoSuchElementException {
		if (start == null) {
			throw new NoSuchElementException();
		} else {
			start = start.getNext();
		}
	}

	public void deleteLast() throws NoSuchElementException {
		int currentSize = size();
		if ((start == null) || currentSize == 0) {
			throw new NoSuchElementException();
		} else {
			remove(currentSize - 1);
		}
	}

	/**
	 * to string method for class Linked List Double
	 */
	public String toString() {

		if (start == null) {
			return "Stack is empty";
		}
		return start.toString() + " ";
	}

	/**
	 * testing main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedListDouble stack = new LinkedListDouble();

		stack.add(5.8);
		stack.add(6.5);
		stack.add(232.46);
		stack.add(3.2);
		System.out.println(stack);
		System.out.println("**********************************");

		System.out.println("Removing");
		stack.remove(3);

		System.out.println(stack);
		System.out.println("**********************************");

		System.out.println("Middle node");
		System.out.println(stack.middle());
		System.out.println("**********************************");

		System.out.println("Stack size");
		System.out.println(stack.size());
		System.out.println("**********************************");

		System.out.println("Getting a node");
		System.out.println(stack.get(0));

		 stack.remove(46566);
		// stack.remove(1);
		// stack.remove(0);
		// stack.remove(3);
	}
}
