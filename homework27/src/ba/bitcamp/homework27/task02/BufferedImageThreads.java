package ba.bitcamp.homework27.task02;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BufferedImageThreads extends JFrame {
	private static final long serialVersionUID = -3250100492215081344L;

	private static BufferedImage image = null;
	private JPanel panel = new JPanel();
	private static LinkedBlockingQueue<Runnable> jobs;
	private ArrayList<Worker> workers;

	public static void main(String[] args) {
		new BufferedImageThreads();
	}

	public BufferedImageThreads() {

		/**
		 * Reading image from file
		 */
		try {
			image = ImageIO.read(new File("picture.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		/**
		 * adding panel on frame setting size, location, title, close operation
		 * 
		 */
		panel = new PicturePanel();
		add(panel);

		setTitle("Buffered Image");
		setSize(1366, 768);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		/**
		 * 
		 */
		jobs = new LinkedBlockingQueue<Runnable>();

		int a = 0;
		int b = 10;
		for (int i = 0; i < 136; i++) {

			jobs.add(new Task(a, b));
			a += 10;
			b += 10;

		}

		/**
		 * creating workers (threads) starting them, and adding to array list
		 */
		workers = new ArrayList<>();

		for (int i = 0; i < 8; i++) {
			Worker s = new Worker();
			s.start();
			workers.add(s);
		}
		for (Worker w : workers) {
			try {
				w.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	static class Task implements Runnable {

		/**
		 * Creating constructor for Task class
		 */
		private int a;
		private int b;

		public Task(int a, int b) {
			this.a = a;
			this.b = b;

		}

		/**
		 * 
		 *
		 */

		@Override
		public void run() {

			for (int i = a; i < b; i++) {
				for (int j = 0; j < image.getHeight(); j++) {
					int pixel = image.getRGB(i, j);
					image.setRGB(i, j, 255 - pixel);

				}

			}

		}

	}

	/**
	 * Class that is used for taking jobs until queue is empty
	 */
	static class Worker extends Thread {
		@Override
		public void run() {
			while (!jobs.isEmpty()) {
				Runnable job = jobs.poll();

				job.run();
				if (jobs == null) {
					break;
				}
			}
		}
	}

	/**
	 * Creating Picture Panel
	 * 
	 * @author User
	 *
	 */
	public class PicturePanel extends JPanel {

		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
			repaint();
		}

	}

}
