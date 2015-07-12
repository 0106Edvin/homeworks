package ba.bitcamp.weekend06.task04;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task04 extends JFrame {
	private static final long serialVersionUID = 6661238195803456191L;

	private String sign = "_";
	private String chars = "";
	JLabel text = new JLabel(sign);
	JButton button1 = new JButton("Char: ");
	JButton button2 = new JButton("Insert ");
	JButton button3 = new JButton("<");
	JButton button4 = new JButton(">");

	public Task04() {
		/**
		 * setting border layout
		 */
		setLayout(new BorderLayout());
		/**
		 * adding listeners to buttons and then adding buttons on layout
		 */
		button1.addActionListener(new Action());
		button2.addActionListener(new Action());
		button3.addActionListener(new Action());
		button4.addActionListener(new Action());
		add(button1, BorderLayout.NORTH);
		add(button2, BorderLayout.SOUTH);
		add(button3, BorderLayout.WEST);
		add(button4, BorderLayout.EAST);

		/**
		 * setting text to the center of label adding text to label
		 */
		text.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		add(text);

		setTitle("Task04");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Random r = new Random();
			char c = (char) (r.nextInt(26) + 'a');
			/**
			 * generate random characters
			 */
			if (e.getSource() == button1) {
				button1.setText(c + "");
				/**
				 * inserts characters in label
				 */
			} else if (e.getSource() == button2) {
				int index = text.getText().indexOf(sign);
				chars = text.getText().substring(0, index);
				chars += button1.getText();
				chars += sign;
				chars += text.getText().substring(index + 1,
						text.getText().length());
				text.setText(chars);
				/**
				 * moves "_" to the left
				 */
			} else if (e.getSource() == button3) {
				int index = text.getText().indexOf(sign);
				String s;
				if (index > 0) {
					index--;
				    s = chars.substring(0, index);
					s += sign;
					s += chars.substring(index, chars.length() - 1);

					text.setText(s);
				}
			/**
			 * moves "_" to the right
			 */
			} else if (e.getSource() == button4) {
				int index = text.getText().indexOf(sign);
					String s;
					if(index < chars.length()){
						index++;
						s = chars.substring(0, index);
						s += sign;
						s += chars.substring(index, chars.length() - 1);

						text.setText(s);
					}
				}
			}
		}

	

	public static void main(String[] args) {
		new Task04();

	}
}