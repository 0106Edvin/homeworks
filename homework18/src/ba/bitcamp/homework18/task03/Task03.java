package ba.bitcamp.homework18.task03;

import java.awt.GridLayout;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Task03 extends JFrame {
	private static final long serialVersionUID = 6169394187236939257L;

	/**
	 * creating text field, password field, label for name and password
	 */
	JTextField text = new JTextField();
	JPasswordField password1 = new JPasswordField();
	JLabel name = new JLabel("Name: ");
	JLabel password = new JLabel("Password: ");
	private String s = "";

	public Task03() {
		/**
		 * setting layout for frame
		 */
		setLayout(new GridLayout(2, 2));
		/**
		 * adding name, text field, password , and password field
		 */
		add(name);
		add(text);
		add(password);
		add(password1);

		/**
		 * adding a listener to password field
		 */
		password1.addKeyListener(new Key());

		setTitle("Task03");
		setSize(300, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Task03();

	}

	public class Key implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		/**
		 * setting action when key is pressed
		 */
		public void keyPressed(KeyEvent e) {
			/**
			 * if user pressed enter, password characters will be added to a "S"
			 * string, and then checking the fields if user name is Mujo and
			 * password is 1234, window will close, if not display message If
			 * user name or password is incorrect, it fields will clear
			 */
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				for (int i = 0; i < password1.getPassword().length; i++) {
					s += password1.getPassword()[i];
				}
				if (text.getText().equals("Mujo") && s.equals("1234")) {
					System.exit(EXIT_ON_CLOSE);
				} else {
					JOptionPane.showMessageDialog(null,
							"Incorrect username or password");

					password1.setText(null);
					text.setText("");
					s = "";

				}

			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
