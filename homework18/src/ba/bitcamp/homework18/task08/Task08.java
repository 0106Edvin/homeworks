package ba.bitcamp.homework18.task08;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Task08 extends JFrame {
	private static final long serialVersionUID = -2151427116340326719L;

	/**
	 * Creating labels for user name, password and check password
	 */
	JLabel label1 = new JLabel("Please insert a username");
	JLabel label2 = new JLabel("Please insert a password");
	JLabel label3 = new JLabel("Please insert a password again");

	/**
	 * Creating text area, where user can write a user name
	 */
	JTextField text1 = new JTextField();

	/**
	 * creating two password fields
	 */
	JPasswordField password1 = new JPasswordField();
	JPasswordField password2 = new JPasswordField();

	/**
	 * Creating two buttons( clear and submit buttons)
	 */
	JButton button1 = new JButton("Clear");
	JButton button2 = new JButton("Submit");

	/**
	 * Strings for passwords
	 */
	private String s1 = "";
	private String s2 = "";

	public Task08() {
		/**
		 * setting grid layout for frame
		 */
		setLayout(new GridLayout(4, 2));

		/**
		 * adding labels, buttons, and password fields
		 */
		add(label1);
		add(text1);
		add(label2);
		add(password1);
		add(label3);
		add(password2);
		add(button1);
		add(button2);

		/**
		 * adding action listeners on buttons
		 */
		button1.addActionListener(new Action());
		button2.addActionListener(new Action());

		/**
		 * setting size, title, location, close operation, and visibility for
		 * frame
		 */
		setSize(500, 150);
		setTitle("Register Form");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Creating class action which implements action listener
	 */
	public class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			/**
			 * putting a password characters in string s
			 */
			for (int i = 0; i < password1.getPassword().length; i++) {
				s1 += password1.getPassword()[i];
			}
			for (int i = 0; i < password2.getPassword().length; i++) {
				s2 += password2.getPassword()[i];
			}
			/**
			 * setting action for button2 if user insert a user name that is
			 * shorter than 6 characters, display message if password is shorter
			 * than 6 characters, display message if passwords did not match,
			 * display message if password did not contain at least one special
			 * character or number, display message if everything is right, then
			 * display successful
			 */
			if (e.getSource() == button2) {

				if (text1.getText().length() < 6) {
					JOptionPane.showMessageDialog(null,
							"Your username must have at least 6 characters");
					text1.setText("");
					password1.setText(null);
					password2.setText(null);
					s1 = "";
					s2 = "";

				} else if (password1.getPassword().length < 6) {
					JOptionPane.showMessageDialog(null,
							"Your password must have at least 6 characters");
					text1.setText("");
					password1.setText(null);
					password2.setText(null);
					s1 = "";
					s2 = "";

				} else if (!(s1.equals(s2))) {
					JOptionPane.showMessageDialog(null,
							"Your passwords  did not match");
					text1.setText("");
					password1.setText(null);
					password2.setText(null);
					s1 = "";
					s2 = "";
				} else if (!charactersAndDigits(password1.getPassword())) {
					JOptionPane
							.showMessageDialog(null,
									"Your password must contain at least one special character or number");
					text1.setText("");
					password1.setText(null);
					password2.setText(null);
					s1 = "";
					s2 = "";

				} else {
					JOptionPane.showMessageDialog(null, "Successful");
				}
			}
			/**
			 * setting action for button1 clear all fields
			 */
			if (e.getSource() == button1) {
				text1.setText("");
				password1.setText(null);
				password2.setText(null);
			}

		}
	}

	/**
	 * creating a boolean method which control if there is a number or special
	 * character in password, using ASCII code
	 * 
	 * @param password1
	 *            password that user insert
	 * 
	 * @return
	 */
	private boolean charactersAndDigits(char[] password1) {
		for (int i = 0; i < password1.length; i++) {
			if (password1[i] >= 48 && password1[i] <= 57) {
				return true;
			}
		}
		for (int i = 0; i < password1.length; i++) {
			if (password1[i] >= 33 && password1[i] <= 47 || password1[i] >= 58
					&& password1[i] <= 64 || password1[i] >= 91
					&& password1[i] <= 96 || password1[i] >= 123
					&& password1[i] <= 126) {
				return true;

			}
		}

		return false;

	}

	public static void main(String[] args) {
		new Task08();

	}
}
