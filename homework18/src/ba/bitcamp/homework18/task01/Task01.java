package ba.bitcamp.homework18.task01;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Task01 extends JFrame {
	private static final long serialVersionUID = 2435358512158269248L;

	/**
	 * creating slider, label
	 */
	JSlider slider = new JSlider(0, 100);
	JLabel label = new JLabel("Text");
	int size = 30;

	public Task01() {
		/**
		 * setting layout for frame
		 */

		setLayout(new BorderLayout());

		/**
		 * setting font for label, adding label set alignment adding slider on
		 * frame
		 */
		label.setFont(new Font("Sans", Font.ITALIC, size));
		add(label, BorderLayout.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		add(slider, BorderLayout.SOUTH);

		/**
		 * adding change listener for slider
		 */
		slider.addChangeListener(new ChangeListener() {

			@Override
			/**
			 * changing a font size when slider is dragged
			 */
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();
				label.setFont(new Font("Sans", Font.ITALIC, slider.getValue()));

			}

		});

		setTitle("Task01");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Task01();

	}

}
