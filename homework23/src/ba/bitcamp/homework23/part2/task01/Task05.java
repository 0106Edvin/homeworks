package ba.bitcamp.homework23.part2.task01;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Task05 {

	private Double[] array;

	public Task05() {

		array = new Double[0];
	}

	/**
	 * adding elements to an array
	 * 
	 * @param element
	 * @return
	 */
	public boolean add(Double element) {

		array = Arrays.copyOf(array, array.length + 1);

		array[array.length - 1] = element;

		return true;

	}

	/**
	 * returning a head of queue
	 * 
	 * @return
	 */

	public Double peek() {

		if (array.length > 0) {
			return array[0];

		} else
			return null;
	}

	/**
	 * removing a head of queue and returning a value of head
	 * 
	 * @return
	 */
	public Double poll() {
		Double tmp = array[0];

		if (array.length > 0) {

			array = Arrays.copyOfRange(array, 1, array.length);
			return tmp;
		} else
			return null;

	}

	/**
	 * if queue have elements return head, if not throw exception
	 * 
	 * @return
	 */

	public Double element() {
		if (array.length > 0) {
			return array[0];

		} else
			throw new NoSuchElementException();

	}

	/**
	 * If queue have elements remove head of queue, create new array and copy
	 * all other elements from old queue, if there is no elements in queue throw
	 * exception
	 * 
	 * @return
	 */

	public Double remove() {
		Double tmp = array[0];

		if (array.length > 0) {
			array = Arrays.copyOfRange(array, 1, array.length);

			return tmp;
		} else
			throw new NoSuchElementException();

	}

	public String toString() {

		if (array.length == 0) {
			return "Queue is empty";

		} else {
			return Arrays.toString(array);
		}
	}

	public static void main(String[] args) {

		Task05 queue = new Task05();
		

		queue.add(5.7);
		queue.add(3.3);
		queue.add(9.9);



		System.out.println("Printing queue");
		System.out.println(queue);
		System.out.println("***************************");

		System.out.println("Peek");
		System.out.println(queue.peek());
		System.out.println("***************************");

		System.out.println("Poll");
		System.out.println(queue.poll());
		System.out.println("***************************");

		System.out.println("Remove");
		System.out.println(queue.remove());
		// System.out.println(queue.remove());
		System.out.println("***************************");
		System.out.println("The queue after all operations");
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
