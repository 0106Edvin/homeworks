package ba.bitcamp.homework18.task06;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Task06 extends JFrame {
	private static final long serialVersionUID = 6566231480600174488L;
	/**
	 * creating a button, text field where number will be written, and label for
	 * counting seconds
	 */
	JButton button = new JButton("Start");
	JTextField text = new JTextField();
	JLabel label = new JLabel();
	int a = 0;

	public Task06() {
		/**
		 * setting layout for frame
		 */

		setLayout(new GridLayout(3, 1));

		/**
		 * setting alignment for label adding label to frame setting alignment
		 * for text adding text to frame
		 */
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);

		/**
		 * adding listener to button, and creating a anonymous class
		 */
		button.addActionListener(new ActionListener() {

			@Override
			/**
			 * setting action when button is clicked
			 * setting label text and converting it to number
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					label.setText(text.getText());
					a = Integer.parseInt(label.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"You insert a wrong number");
				}
			}
		});
		/**
		 * adding timer that counts every second, and creating anonymous class
		 */
		Timer t = new Timer(1000, new ActionListener() {

			@Override
			/**
			 * setting action that will be done every second
			 * every second a number from a label will be decreased by 1
			 */
			public void actionPerformed(ActionEvent e) {
				if (a > 0) {
					a--;
					label.setText(a + "");

				} else {
					label.setText("0");
				}

			}
		});
		/**
		 * starting a timer
		 */
		t.start();
		/**
		 * adding a button to a frame
		 */
		add(button);

		/**
		 * setting title, frame size, close operation, location and set
		 * visibility for frame
		 */
		setTitle("Task03");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Task06();

	}

}
