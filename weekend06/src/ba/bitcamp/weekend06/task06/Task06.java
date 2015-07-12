package ba.bitcamp.weekend06.task06;

public class Task06 {

	public static void main(String[] args) {
		int[][] matrix = new int[4][5];

		fillArray(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void fillArray(int[][] matrix) {
		fillArray(matrix, 0, 0, 0);
	}

	/**
	 * 
	 * @param matrix
	 * @param i
	 *            number of rows
	 * @param j
	 *            number of columns
	 * @param a
	 *            number
	 */
	public static void fillArray(int[][] matrix, int i, int j, int a) {
		/**
		 * if i equals matrix length return the loop is over
		 */
		if (i == matrix.length) {
			return;
		}
		/**
		 * adding a numbers in a rows and columns
		 */
		if (j == matrix[i].length - 1) {
			matrix[i][j] = a;
			j = 0;
			i += 1;
			a += 1;
		} else {
			matrix[i][j] = a;
			j += 1;
			a += 1;
		}
		fillArray(matrix, i, j, a);

	}
}