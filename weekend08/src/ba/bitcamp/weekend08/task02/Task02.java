package ba.bitcamp.weekend08.task02;

import java.util.Random;

public class Task02 {

	public static void main(String[] args) {

		/**
		 * creating a thread, and starting it
		 */
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		Thread t3 = new MyThread3();
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * creating thread class
	 * 
	 * @author User
	 *
	 */
	static class MyThread1 extends Thread {

		@Override
		public void run() {
			/**
			 * printing numbers from 1-10 every 200 milli Seconds
			 */
		
			for (int i = 1; i <= 10; i++) {

				System.out.println(i);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			

		}
	}

	static class MyThread2 extends Thread {
		/**
		 * printing Bit Camp four times, every second
		 */
		@Override
		public void run() {
			for (int i = 0; i < 4; i++) {
				System.out.println("Bit Camp");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}


			}

		}
	}

	static class MyThread3 extends Thread {
		@Override
		public void run() {
			Random r = new Random();
			/**
			 * printing 5 random numbers from 0-5
			 */
			for (int i = 0; i < 5; i++) {
				int number = r.nextInt(5)+1;
				System.out.println(number);

				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

}
