package ba.bitcamp.homework24.task02;

public class UniqueStackInt {

	private Node start;

	public UniqueStackInt() {
		start = null;

	}

	public class Node {

		private Integer value;
		private Node next;

		public Node(Integer value) {
			this.value = value;
			next = null;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
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
			} else {
				return value + " " + next.toString();
			}
		}

	}

	/**
	 * Adding numbers to stack checking if number is already in stack if it
	 * is,do nothing, if it's not add to stack
	 * 
	 * @param i
	 * @return
	 */
	public Integer push(Integer i) {

		if (start == null) {
			start = new Node(i);
		} else {
			Node tmp = start;
			while (tmp.getNext() != null) {
				if (tmp.getValue() == i) {
					return i;

				}
				tmp = tmp.next;
			}
			tmp = new Node(i);
			tmp.setNext(start);
			start = tmp;
		}

		return i;
	}

	/**
	 * removing number from stack, removes number that is last added
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public Integer pop() throws NullPointerException {
		Integer tmp = 0;
		if (start == null) {
			throw new NullPointerException();
		} else {

			tmp = start.getValue();
			start = start.getNext();
		}
		return tmp;
	}

	/**
	 * checking of numbers in stack are increasing
	 * 
	 * @return
	 */
	public Boolean isIncreacing() {
		if (start == null) {
			return false;
		} else {

			Integer tmp = start.getValue();
			Node temp = start;

			while (temp.getNext() != null) {
				temp = temp.next;

				if (temp.getValue() >= tmp) {
					tmp = temp.getValue();
				} else
					return false;
			}
			return true;
		}
	}

	public String toString() {
		if (start == null) {
			return "Stack is empty";
		}
		return start.toString();
	}

	public static void main(String[] args) {

		UniqueStackInt stack = new UniqueStackInt();

		System.out.println("Adding numbers to stack");
		stack.push(56);
		stack.push(55);
		stack.push(22);
		stack.push(22);
		System.out.println(stack);
		System.out.println("************************************");

		System.out.println("Removing number from stack");
		stack.pop();
		System.out.println(stack);
		System.out.println("************************************");

		System.out.println("Checking if stack is increasing");
		System.out.println(stack.isIncreacing());

	}
}
