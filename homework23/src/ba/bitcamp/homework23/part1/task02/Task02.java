package ba.bitcamp.homework23.part1.task02;

public class Task02 {
	/**
	 * creating a node head and constructor
	 */

	private Node head;

	public Task02() {
		head = null;
	}

	/**
	 * creating a node class which contains string and pointer to next node
	 * 
	 * @author User
	 *
	 */
	public class Node {

		private String str;
		private Node next;

		public Node(String str) {
			super();
			this.str = str;
			next = null;
		}

		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public String toString() {
			if (next == null) {
				return str + " ";
			} else
				return str + " " + next.toString();
		}

	}

	/**
	 * checking if stack is empty
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	/**
	 * adding elements to stack saying that new element is head of stack
	 */


	public String push(String str) {
		Node tmp = null;
		if (head == null) {
			head = new Node(str);
		} else {

			tmp = new Node(str);
			tmp.setNext(head);
			head = tmp;
		}

		return str;
	}

	/**
	 * removing elements from stack
	 * 
	 * @return
	 * @throws NullPointerException
	 *             if there is no elements to remove therow exception
	 */
	public String pop() throws NullPointerException {
		String tmp = "";
		if (head == null) {
			throw new NullPointerException();
		} else {

			tmp = head.getStr();
			head = head.getNext();
		}
		return tmp;
	}

	/**
	 * just returning the head of stack
	 * 
	 * @return
	 */
	public String peek() {
		if (head == null) {
			return null;
		} else {

			return head.getStr();
		}
	}

	/**
	 * searching element in stack if stack is empty return -1 if element is
	 * found return 1 if there is no element in stack return -1
	 * 
	 * @param s
	 * @return
	 */
	public int search(String s) {
		if (head == null) {
			return -1;
		}
		Node tmp = null;
		tmp = head;

		while (tmp.getNext() != null) {
			tmp = tmp.getNext();

			if (tmp.getStr().equals(s)) {
				return 1;
			}
		}
		return -1;
	}

	public String toString() {
		if (head == null) {
			return "Empty";
		} else
			return head.toString() + " ";

	}

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		Task02 stack = new Task02();
		stack.push("Edvin");
		stack.push("Mulabdic");
		stack.push("Sarajevo");
		stack.push("Bit");
		stack.push("Camp");
		stack.push("IUS");
		
		System.out.println("Time to add elements in miliseconds " + (System.currentTimeMillis() - start));
		System.out.println("**************************************");
		
		System.out.println("Printing stack");
		System.out.println(stack);
		System.out.println("**************************************");

		System.out.println("Removing");
		System.out.println(stack.pop());
		System.out.println("**************************************");

		System.out.println("Stack after removing element");
		System.out.println(stack);
		System.out.println("**************************************");

		System.out.println("Search ");
		System.out.println(stack.search("Edvin"));
		System.out.println(stack.search("Neko"));
		System.out.println("**************************************");

		System.out.println("Peek");
		System.out.println(stack.peek());
		System.out.println("**************************************");

		System.out.println("Is stack empty");
		System.out.println(stack.isEmpty());
		System.out.println("**************************************");
	}

}
