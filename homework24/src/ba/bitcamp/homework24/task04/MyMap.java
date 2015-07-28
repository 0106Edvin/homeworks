package ba.bitcamp.homework24.task04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyMap {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter key value: ");
		int key = input.nextInt();
		System.out.print("Enter numbers limit: ");
		int numbersLimit = input.nextInt();

		Map<Integer, ArrayList<Integer>> map = getMap(key, numbersLimit);
		System.out.println(map);

		input.close();
	}

	/**
	 * Fills map by adding a key values to that key
	 *  if key is 1 values will be increased by 1
	 *  if key is 2 values will be increased by 2 
	 *  values will always be increased for key value
	 * 
	 * @param key
	 * @param numbersLimit
	 * @return
	 */
	public static Map<Integer, ArrayList<Integer>> getMap(int key,
			int numbersLimit) {
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 1; i <= key; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j < numbersLimit; j++) {
				list.add(i * j + 1);
			}
			map.put(i, list);
		}
		return map;
	}
}
