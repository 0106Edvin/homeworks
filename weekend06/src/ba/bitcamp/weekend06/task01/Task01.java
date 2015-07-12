package ba.bitcamp.weekend06.task01;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Task01 extends JFrame {
	private static final long serialVersionUID = -1771585344752786245L;

	/**
	 * Creating an array of buttons
	 */
	private JButton[] buttons = new JButton[10];
	/**
	 * Creating an array of numbers that will appear on buttons
	 */
	private String[] numbers = new String[] { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9" };
	/**
	 * a counter that will be used for counting clicks on buttons
	 */
	private int counter = 0;
	private String newNumber = "";

	/**
	 * Creating constructor
	 */
	public Task01() {
		/**
		 * Creating layout, with 10 rows and 1 column
		 */
		setLayout(new GridLayout(10, 1));

		/**
		 * adding numbers on buttons and for every button we have to add a
		 * listener
		 */
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(numbers[i]);
			buttons[i].addActionListener(new Action());

			/**
			 * Adding buttons on layout
			 */
			add(buttons[i]);

		}
		/**
		 * Setting a title of a frame, size setting location on a center of
		 * display, enabling to close window on exit and set frame visible
		 */
		setTitle("Task01");
		setSize(400, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Creating a class Action which implements Action Listener
	 */
	private class Action implements ActionListener {
		/**
		 * Creating a loop which adds numbers on buttons to a new Number counter
		 * counts how many times user click on a button Disabling a button when
		 * a user click on it
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < buttons.length; i++) {
				if (e.getSource() == buttons[i]) {
					newNumber += numbers[i];
					buttons[i].setEnabled(false);
				}
			}
			counter++;

			/**
			 * If user clicks 3 times on a button, a message dialog will appear
			 * with a number
			 * 
			 */
			if (counter == 3) {

				JOptionPane.showMessageDialog(null, "Your number is: "
						+ newNumber);
				System.exit(EXIT_ON_CLOSE);
			}
		}
	}

	public static void main(String[] args) {
		new Task01();

	}
}