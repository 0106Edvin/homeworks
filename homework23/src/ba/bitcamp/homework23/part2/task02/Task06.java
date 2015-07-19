package ba.bitcamp.homework23.part2.task02;

import java.util.NoSuchElementException;

public class Task06 {
	/**
	 * creating a node head and constructor
	 */
	private Node head;

	public Task06() {
		head = null;
	}

	public class Node {

		private Double value;
		private Node next;

		public Node(Double value) {
			this.value = value;

		}

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
		 * to string method for Node class
		 */
		public String toString() {
			if (next == null) {
				return String.valueOf(value);
			}
			return value + ", " + next.toString();
		}
	}

	/**
	 * adding elements to a queue
	 * 
	 * @param value
	 * @return
	 */
	public boolean add(Double value) {

		if (head == null) {
			head = new Node(value);
		} else {

			Node tmp = head;
			while (tmp.getNext() != null) {
				tmp = tmp.getNext();
			}
			tmp.setNext(new Node(value));
		}

		return true;
	}

	/**
	 * removing element from queue
	 * 
	 * @return
	 * @throws NoSuchElementException
	 */

	public Double poll() {
		if (head != null) {

			Double tmp = head.value;
			head = head.next;

			return tmp;
		} else
			return null;
	}

	/**
	 * returning value of head queue
	 * 
	 * @return
	 */
	public Double peek() {
		if (head == null) {
			return null;
		}

		return head.value;
	}

	/**
	 * to string method for class
	 */
	public String toString() {
		if (head == null) {
			return "queue is empty";
		}
		return head.toString();
	}

	public static void main(String[] args) {

		Task06 queue = new Task06();


		queue.add(3.9);
		queue.add(6.9);
		queue.add(1.1);

		System.out.println("Printing queue");
		System.out.println(queue);
		System.out.println("***************************");

		System.out.println("Peek");
		System.out.println(queue.peek());
		System.out.println("***************************");

		System.out.println("Poll");
		queue.poll();
		System.out.println(queue);
		System.out.println("***************************");

		System.out.println("Testing how much time to we need to add 20 000 elements");
		long start = System.currentTimeMillis();
		for (double i = 0; i < 20000; i++) {
			queue.add(i);
		}
		
		System.out.println("Time to add elements in miliseconds "
				+ (System.currentTimeMillis() - start));
		System.out.println("***************************");
	}

}
