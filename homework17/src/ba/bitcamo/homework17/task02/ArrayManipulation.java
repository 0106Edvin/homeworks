package ba.bitcamo.homework17.task02;

import ba.bircamp.homework17.task01.Computer;

public class ArrayManipulation {
	/**
	 * Extending array for one space
	 * 
	 * @param c
	 */
	public static Computer[] extendArray(Computer[] c) {

		Computer[] newComp = new Computer[c.length + 1];
		for (int i = 0; i < c.length; i++) {
			newComp[i] = c[i];

		}
		return newComp;

	}

	/**
	 * Reducing array
	 * 
	 * @param c
	 *            array
	 * @param a
	 *            a number of computer which needs to be leave out
	 */
	public static Computer[] shrinkArray(Computer[] c, int a) {

		Computer[] newComp = new Computer[c.length - 1];

		for (int i = 0; i < newComp.length; i++) {
			if (i < a) {
				newComp[i] = c[i];
			} else {

				newComp[i] = c[i + 1];
			}

		}
		return newComp;
	}

}
