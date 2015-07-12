package ba.bitcamp.weekend06.task02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task02 extends JFrame {
	private static final long serialVersionUID = -8521544803930083904L;
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JLabel text1 = new JLabel();
	private String name;
	private String lastName;

	/**
	 * Creating a constructor
	 */
	public Task02() {
		/**
		 * setting layout, and adding buttons on layout adding action listener
		 * to buttons
		 */
		setLayout(new BorderLayout());

		button1.setText("First Name");
		button2.setText("Last Name");
		add(button1, BorderLayout.WEST);
		add(button2, BorderLayout.EAST);

		text1.setHorizontalAlignment(JLabel.CENTER);

		add(text1, BorderLayout.CENTER);

		button1.addActionListener(new Action());
		button2.addActionListener(new Action());

		/**
		 * Setting a frame title, size, location on center of display closing on
		 * exit and making frame visible
		 */
		setTitle("Task02");
		setSize(500, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Creating a class Action which implements Action Listener
	 */
	private class Action implements ActionListener {

		@Override
		/**
		 * action listener
		 * when user click on button1, adds first name
		 * when user click on button2, adds last name
		 * first and last name are generated randomly from arrays
		 */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1) {
				name = new FirstName().toString();
				text1.setText(name + lastName);
			} else if (e.getSource() == button2) {
				lastName = new LastName().toString();
				text1.setText(name + lastName);
			}

		}
	}

	/**
	 * class that generates first names
	 *
	 */
	static class FirstName {

		private String[] firstNames = new String[] { "Gordan", "Mladen",
				"Medina", "Adis", "Dinko", "Ajla", "Zeljko", "Edvin" };

		public String generateFirstName() {
			return firstNames[(int) (Math.random() * firstNames.length)];
		}

		public String toString() {
			return generateFirstName();
		}
	}

	/**
	 * class that generates last names
	 *
	 */
	static class LastName {

		private String[] lastNames = new String[] { "Masic", "Teofilovic",
				"Banjic", "Cehajic", "Hodzic", "El Tabari", "Miljevic",
				"Mulabdic" };

		public String generateLastName() {
			return lastNames[(int) (Math.random() * lastNames.length)];
		}

		public String toString() {
			return generateLastName();
		}
	}

	public static void main(String[] args) {
		new Task02();

	}
}