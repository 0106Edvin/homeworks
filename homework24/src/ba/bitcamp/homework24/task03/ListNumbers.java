package ba.bitcamp.homework24.task03;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListNumbers {

	public static void main(String[] args) {
		/**
		 * creating integer list
		 */

		ArrayList<Integer> al = new ArrayList<>();
		al.add(2);
		al.add(4);
		al.add(3);
		al.add(5);
		al.add(2);
		al.add(9);
		al.add(2);

		System.out.println(al);

		/**
		 * creating iterator
		 * 
		 */
		ListIterator<Integer> it = al.listIterator();

		while (it.hasNext()) {
			int temp = it.next();
			if (it.hasNext()) {
				it.remove();
				temp += it.next();
				it.set(temp);
			}

		}
		System.out.println(al);

	}

}
