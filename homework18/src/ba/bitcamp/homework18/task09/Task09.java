package ba.bitcamp.homework18.task09;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Task09 extends JFrame {
	private static final long serialVersionUID = 9090316501668631466L;

	/**
	 * Creating two panels, one for read from file, and second for showing text
	 */
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();

	/**
	 * Creating label and text, where user can input file location
	 */
	JLabel label1 = new JLabel(
			"Please insert a file location you want to read from");
	JTextField text = new JTextField();
	/**
	 * Creating text area, where text from file will be dispalyed
	 */
	JTextArea textArea = new JTextArea();
	private String textFromFile = "";

	public Task09() {

		/**
		 * setting layout of frame
		 */
		setLayout(new BorderLayout());

		/**
		 * adding panel 1 to frame at the position "NORTH" setting border for
		 * panel 1 setting panel 1 layout adding label 1 to panel 1 adding text
		 * to label 1 adding key listener to text
		 */
		add(panel1, BorderLayout.NORTH);
		panel1.setBorder(BorderFactory.createTitledBorder("Read From File"));
		panel1.setLayout(new GridLayout(1, 2));
		panel1.add(label1);
		panel1.add(text);
		text.addKeyListener(new Key());

		/**
		 * adding panel 2 to frame at the position "CENTER" setting border for
		 * panel2 setting panel 2 layout adding textArea to panel 2
		 */
		add(panel2, BorderLayout.CENTER);
		panel2.setBorder(BorderFactory.createTitledBorder("Text"));
		panel2.setLayout(new BorderLayout());
		panel2.add(textArea);

		/**
		 * setting size, title, location, close operation, and visibility for
		 * frame
		 */

		setSize(600, 400);
		setTitle("Import Text File");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Task09();
	}

	private class Key implements KeyListener {

		@Override
		/**
		 * setting action if key ENTER is pressed
		 * try to read from file location user entered, and put that in string textFromFIle
		 * and then put that string in textArea
		 * if can't read display message
		 */
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				try {
					TextIO.readFile(text.getText());
					while (!TextIO.eof()) {
						textFromFile += TextIO.getln() + "\n";

					}
					textArea.setText(textFromFile);

				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(null, "Can't open file"
							+ "  " + text.getText());
				}

			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
