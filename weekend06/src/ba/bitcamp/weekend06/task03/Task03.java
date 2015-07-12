package ba.bitcamp.weekend06.task03;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Task03 extends JFrame {
	private static final long serialVersionUID = 1012774011746178822L;

	/**
	 * Creating array of buttons, and array of numbers that will be added to
	 * buttons array, 
	 * Counter that will count clicks on buttons, 
	 * k counter for array
	 */
	private JButton[] buttons = new JButton[10];
	private int[] numbers = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private int[] array = new int[5];
	private int counter = 0;
	private int k = 0;

	public Task03() {
		/**
		 * Setting Grid Layout with 2 rows and 5 columns
		 */
		setLayout(new GridLayout(2, 5));

		/**
		 * Adding buttons and action listener to every button
		 */
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(numbers[i] + "");
			buttons[i].addActionListener(new Action());
			add(buttons[i]);

		}
		/**
		 * Setting title, size location on the center of display enabling window
		 * to close on exit setting window visible
		 */
		setTitle("Task03");
		setSize(500, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private class Action implements ActionListener {

		@Override
		/**
		 * Adding actions on Action listener
		 * when user click on button, a number that is added on that button will be added to new array,
		 *  on position k which is at the start 0, and increasing with every click by 1
		 *  When user click on one button in a column the other button is disabled 
		 */
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < buttons.length; i++) {
				if (e.getSource() == buttons[i]) {
					array[k] = numbers[i];
					k++;
					if (i < 5) {
						buttons[i + 5].setEnabled(false);
					} else {
						buttons[i - 5].setEnabled(false);
					}
					buttons[i].setEnabled(false);
				}
			}
			counter++;

			/**
			 * Creating a message dialog with a result (array with numbers)
			 * Ending program on close
			 */
			if (counter == 5) {
				JOptionPane.showMessageDialog(null, Arrays.toString(array));
				System.exit(EXIT_ON_CLOSE);
			}
		}
	}

	public static void main(String[] args) {
		new Task03();

	}
}