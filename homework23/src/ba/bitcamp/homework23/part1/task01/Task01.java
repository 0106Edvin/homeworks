package ba.bitcamp.homework23.part1.task01;

import java.util.Arrays;

public class Task01 {

	/**
	 * creating an array of strings and a constructor
	 */
	private String[] str;

	public Task01() {
		str = new String[0];
	}

	/**
	 * checking if array is empty
	 * 
	 * @return
	 */

	public boolean isEmpty() {
		if (str.length == 0) {
			return true;
		}
		return false;
	}

	/**
	 * adding elements to an array creating a new bigger array copy old array to
	 * a new one and add element
	 */


	public String push(String s) {

		str = Arrays.copyOf(str, str.length + 1);
		str[str.length - 1] = s;

		return s;
	}

	/**
	 * removing element from an array create a new shorter array and copy old
	 * array to a new one
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public String pop() throws NullPointerException {
		if (str.length > 0) {

			String s = str[str.length - 1];
			str = Arrays.copyOf(str, str.length - 1);
			return s;
		} else
			throw new NullPointerException();
	}

	/**
	 * method just return last element and do nothing
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public String peek() throws NullPointerException {
		if (str.length > 0) {
			return str[str.length - 1];

		} else
			throw new NullPointerException();
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < str.length; i++) {
			s += str[i] + " ";
		}
		return s;

	}

	/**
	 * searching for an element that user insert if there is element in array
	 * return index if not return -1
	 * 
	 * @param s
	 *            element we are searching
	 * @return
	 */
	public int search(String s) {
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals(s)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		Task01 stack = new Task01();
		long start = System.currentTimeMillis();


		stack.push("Edvin");
		stack.push("Mulabdic");
		stack.push("Sarajevo");
		stack.push("Bit");
		stack.push("Camp");
		stack.push("IUS");
		
		System.out.println("Time to add elements in milisecodns " + (System.currentTimeMillis() - start));
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

		System.out.println("Search");
		System.out.println(stack.search("Bit"));
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
