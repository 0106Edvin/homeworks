package ba.bitcamp.homework22.task01;

import java.util.NoSuchElementException;

public class LinkedListDouble {

	/**
	 * creating a node start which represents a head fof node
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

		private double value;
		private Node next;

		/**
		 * constructor for Node class
		 * 
		 * @param value
		 *            a number that user insert
		 */
		public Node(double value) {
			super();
			this.value = value;
			next = null;
		}

		/**
		 * setters and getters for value and next
		 * 
		 * @return
		 */

		public double getValue() {
			return value;
		}

		public void setValue(double value) {
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
				return value + " ";
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

	public void add(double element) {
		/**
		 * creating a temporary Node which is at start null
		 */
		Node tmp = null;

		/**
		 * when stack is empty just create a new node and make it a start node
		 */
		if (start == null) {
			start = new Node(element);

		} else {
			/**
			 * if stack is not empty, create new node with value creating a
			 * connection between this node and existing one saying that this
			 * new node is a start of a stack
			 */

			tmp = new Node(element);
			tmp.setNext(start);
			start = tmp;
		}

	}

	/**
	 * removing element from index
	 * 
	 * @param index
	 */

	public void remove(int index) {
		/**
		 * the case when we want to remove a start node
		 */
		if (index == 0) {
			start = start.getNext();
		}

		/**
		 * creating a temporary node which is used to save start value
		 * 
		 */
		Node tmp = start;
		try {
			/**
			 * finding an node in stack that is on index we want removing that
			 * node by removing a pointer that points from previous to that
			 * node, and setting a pointer from previous to a node that comes
			 * after the one we want to remove
			 */
			for (int i = 0; i < index; i++) {
				tmp = tmp.getNext();

				Node previous = getPreviousNode(tmp);

				previous.setNext(tmp.getNext());

			}
		} catch (NullPointerException e) {

		}
	}

	/**
	 * finding a previous node
	 * 
	 * @param n
	 *            a node that we want to find the knot's predecessor
	 * @return
	 */
	public Node getPreviousNode(Node n) {
		if (n == start) {
			return null;
		}

		Node tmp = start;
		while (tmp.getNext() != n) {
			tmp = tmp.getNext();
		}

		return tmp;
	}

	/**
	 * finding a node by index
	 * 
	 * @param index
	 *            on which is a node we want
	 * @return
	 */

	public double get(int index) {
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
	public double middle() {
		return get((size() - 1) / 2);

	}

	public double getFirst() throws NoSuchElementException {
		if (start == null) {
			throw new NoSuchElementException();
		} else {
			return start.getValue();
		}
	}

	public double getLast() throws NoSuchElementException {

		if (start == null) {
			throw new NoSuchElementException();
		} else {
			return get(size() - 1);
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
		if (start == null) {
			throw new NoSuchElementException();
		} else {
			remove(size() - 1);
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
		// stack.remove(0);
		System.out.println(stack.size());
		System.out.println(stack.middle());
		// System.out.println(stack.get());
		System.out.println(stack);
	}
}
