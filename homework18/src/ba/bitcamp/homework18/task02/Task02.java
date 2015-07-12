package ba.bitcamp.homework18.task02;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task02 extends JFrame {
	private static final long serialVersionUID = 8039332411357657235L;
	/**
	 * creating label, button, and two check boxes
	 */
	JLabel label = new JLabel("Example text");
	JButton button = new JButton("Apply");
	JCheckBox cb1 = new JCheckBox("Bold");
	JCheckBox cb2 = new JCheckBox("Italic");

	public Task02() {
		/**
		 * setting frame layout
		 */
		setLayout(new GridLayout(4, 1));

		/**
		 * setting font for label, alignment and adding label on frame adding
		 * check boxes on frame adding button on frame
		 */
		label.setFont(new Font("Monospace", Font.PLAIN, 22));
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		add(cb1);
		add(cb2);
		add(button);
		/**
		 * adding action listener on button
		 */
		button.addActionListener(new Action());

		setTitle("Task02");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Task02();

	}

	/**
	 * creating class Action which implements action listener
	 *
	 */
	public class Action implements ActionListener {

		@Override
		/**
		 * setting action when button is pressed
		 */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button) {
			}
			/**
			 * if both check boxes are selected change font to monospace, bold
			 * and italic if check box 1 is selected change font to bold if
			 * check box 2 is selected chamge font to italic
			 */
			if (cb1.isSelected() && cb2.isSelected()) {
				label.setFont(new Font("Monospace", Font.BOLD + Font.ITALIC, 22));
			} else if (cb1.isSelected()) {
				label.setFont(new Font("Monospace", Font.BOLD, 22));
			} else if (cb2.isSelected()) {

				label.setFont(new Font("Monospace", Font.ITALIC, 22));
			} else if (!cb1.isSelected() && !cb2.isSelected()) {
				label.setFont(new Font("Monospace", Font.PLAIN, 22));
			}
		}
	}

}
