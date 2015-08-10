package ba.bitcamp.weekend08.task03;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task03 extends JFrame {
	private static final long serialVersionUID = -847330498937882306L;

	static JLabel label = new JLabel();
	static JButton button = new JButton("STOP");
	static volatile boolean isRunning = true;
	static String alphabet = "";

	public Task03() {
		add(label);
		label.setLayout(new BorderLayout());
		label.add(button, BorderLayout.SOUTH);

		Thread t1 = new MyThread();
		t1.start();

		label.setText(t1.toString());
		label.setHorizontalAlignment(getX());
		label.setFont(new Font("Sans", Font.BOLD, 20));

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				t1.interrupt();

			}
		});

		setTitle("Alphabet");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Task03();
	}

	private class MyThread extends Thread {

		@Override
		public void run() {

			try {
				for (int i = 65; i <= 90; i++) {
					alphabet += (char) i;
					label.setText(alphabet);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted");
			}
		}

	}

}
