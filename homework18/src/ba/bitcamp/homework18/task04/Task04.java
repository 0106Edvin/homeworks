package ba.bitcamp.homework18.task04;

import javax.swing.JOptionPane;

public class Task04 {

	public static void main(String[] args) {
		new Task04();
		/**
		 * setting a sum,  number user need to insert on zero
		 */
		int sum = 0, a = 0, choice = 0;
		do {
			try {
				/**
				 * converting a number that user insert and adding it on sum
				 * while user don't choose to brake it by clicking on NO option
				 */
				a = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Insert a number"));
				sum += a;

				choice = JOptionPane.showConfirmDialog(null,
						"Enter another number?");
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,
						"You have to enter at least one number");
			}
		} while (choice == JOptionPane.YES_OPTION);

		if (choice == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "Sum of entered numbers is: "
					+ sum);
		} else if (choice == JOptionPane.CANCEL_OPTION) {
			System.exit(0);

		}

	}
}
