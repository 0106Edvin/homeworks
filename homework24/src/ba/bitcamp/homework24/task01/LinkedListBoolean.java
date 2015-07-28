package ba.bitcamp.homework24.task01;

public class LinkedListBoolean {

	private Node start;

	public LinkedListBoolean() {
		start = null;
	}

	public class Node {

		private Boolean value;
		private Node next;

		public Node(Boolean value) {
			this.value = value;
		}

		public Boolean getValue() {
			return value;
		}

		public void setValue(Boolean value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public String toString() {

			if (next == null) {
				return String.valueOf(value);
			}
			return value + " " + next.toString();

		}

	}

	public void add(Boolean b) {

		/**
		 * when stack is empty just create a new node and make it a start node
		 */
		if (start == null) {
			start = new Node(b);
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

		tmp.setNext(new Node(b));
	}

	/**
	 * removing a Boolean b from linked list boolean
	 * 
	 * @param b
	 */
	public void remove(Boolean b) {

		if (start == null) {
			return;
		}
		if (start.getValue() == b) {
			start = start.getNext();
			return;
		}
		Node previous = start;
		Node tmp = start.getNext();

		while (tmp != null) {
			if (tmp.getValue() == b) {
				previous.setNext(tmp.getNext());
				return;
			}
			previous = tmp;
			tmp = tmp.next;
		}
	}

	/**
	 * removing boolean by index
	 * 
	 * @param index
	 *            from which boolean needs to be deleted
	 * @param b
	 *            boolean that needs to be deleted
	 * 
	 *            first checking if there is any booleans in list, then checking
	 *            if index is good. Finding a boolean by index in list and
	 *            checking if it has right value. If value is right, remove
	 *            boolean, if not do nothing
	 */
	public void remove(int index, Boolean b) {

		if (start == null) {
			return;

		}
		if (index < 0 || index >= size()) {
			throw new IllegalArgumentException("The index is out of bounds.");
		}

		Node previous = start;

		for (int i = 0; i < index - 1; i++) {

			previous = previous.getNext();
		}
		Node tmp = previous.getNext();

		for (int i = index; i < size(); i++) {
			if (tmp.getValue() == b) {
				previous.setNext(tmp.getNext());
				return;

			}
		}
	}

	/**
	 * returning a size of a list
	 * 
	 * @return
	 */
	public int size() {
		if (start == null) {
			return 0;
		}
		Node tmp = start;
		int size = 0;
		while (tmp != null) {
			size++;
			tmp = tmp.getNext();
		}
		return size;
	}

	/**
	 * checking if element is in list, and return true, if not return false
	 * 
	 * @param b
	 *            element that we are searching
	 * @return
	 */
	public Boolean contains(Boolean b) {
		if (start == null) {
			return false;
		}
		Node tmp = start;
		for (int i = 0; i < size(); i++) {
			if (tmp.getValue() == b)
				return true;
		}
		return false;
	}

	/**
	 * checking if list is alternating returning true if it is, and false if not
	 * 
	 * @return
	 */
	public Boolean isAlternating() {
		if (start == null) {
			return false;
		} else {

			Node temp = start;

			while (temp.getNext() != null) {
				if (temp.getValue() == temp.getNext().value) {
					return false;
				}
				temp = temp.getNext();
			}
			return true;
		}
	}

	public String toString() {

		if (start == null) {
			return "List is empty";
		}
		return start.toString() + " ";
	}

	public static void main(String[] args) {

		LinkedListBoolean ll = new LinkedListBoolean();

		System.out.println("Adding booleans to list");
		ll.add(true);
		ll.add(true);
		ll.add(false);
		ll.add(true);
		ll.add(false);
		ll.add(false);
		System.out.println(ll);
		System.out.println("*************************************");

		System.out.println("Removing boolean from list");
		ll.remove(true);
		System.out.println(ll);
		System.out.println("*************************************");

		System.out.println("Removing booelan by index");
		ll.remove(4, false);
		System.out.println(ll);
		System.out.println("*************************************");

		System.out.println("Checking if list is alternating");
		System.out.println(ll.isAlternating());
		System.out.println("*************************************");

	}

}
