package ba.bitcamp.homework18.task07;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Task07 extends JFrame {
	private static final long serialVersionUID = -554477771853397026L;

	/**
	 * Creating JPanel, x and y numbers, width boolean and slider
	 */
	private JPanel panel = new JPanel();
	private int x;
	private int y;
	private int width;

	private boolean isClicked = false;
	JSlider slider = new JSlider(0, 300);

	public Task07() {

		/**
		 * adding panel to frame adding mouse listener to panel setting starting
		 * value of slider
		 */
		add(panel);
		panel.addMouseListener(new Mouse());
		panel.add(slider);
		slider.setValue(0);

		/**
		 * adding a listener to slider and creating anonymous class
		 */
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();
				/**
				 * setting a width from slider
				 */
				width = slider.getValue();

			}
		});

		/**
		 * setting size, title, location, close operation, and visibility for
		 * frame
		 */
		setSize(600, 400);
		setTitle("Circle Drawer");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Task07();

	}

	public class Mouse implements MouseListener {

		@Override
		/**
		 * setting action when mouse is clicked
		 * taking mouse coordinates of x and y 
		 */
		public void mouseClicked(MouseEvent e) {
			if (e.getSource().equals(panel)) {
				x = e.getX();
				y = e.getY();
				isClicked = true;
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}

	}

	@Override
	/**
	 * painting a circle at the coordinates taken from mouse click
	 */
	public void paint(Graphics g) {
		super.paint(g);
		if (isClicked == true) {
			g.setColor(Color.BLACK);
			g.drawOval(x, y, width, width);
		}

		repaint();

	}
}
