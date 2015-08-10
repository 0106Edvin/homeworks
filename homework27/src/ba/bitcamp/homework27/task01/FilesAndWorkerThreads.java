package ba.bitcamp.homework27.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class FilesAndWorkerThreads {

	/**
	 * variables
	 */
	private static Integer counter = 0;
	private static BufferedReader reader = null;
	private static char firstChar;
	private static LinkedBlockingQueue<Runnable> jobs;
	private static ArrayList<Producer> producers;
	private static Object lock = new Object();

	public static void main(String[] args) {

		try {
			/**
			 * Initialising buffered reader Finding a first char in file
			 */
			reader = new BufferedReader(new FileReader(new File("text.txt")));
			String lineTask = "";

			firstChar = (char) reader.read();

			/**
			 * Initialising blocking queue
			 */
			jobs = new LinkedBlockingQueue<Runnable>();
			while ((lineTask = reader.readLine()) != null) {
				jobs.add(new Task(lineTask));
			}

			/**
			 * Initialising producers Creating 8 producers(threads), staring
			 * them and adding to array list
			 */
			producers = new ArrayList<>();

			for (int i = 0; i < 8; i++) {
				Producer p = new Producer();
				p.start();
				producers.add(p);
			}
			for (Producer p : producers) {
				try {
					p.join();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			/**
			 * Printing the result
			 */
			System.out.println("A character " + firstChar + " is found  "
					+ counter + " times in file");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static class Producer extends Thread {

		/**
		 * Creating producers(threads) who takes jobs from queue, and do jobs
		 */
		@Override
		public void run() {
			while (!jobs.isEmpty()) {
				Runnable job = jobs.poll();
				if(job == null){
					break;
				}
				job.run();
			}

		}

	}

	static class Task implements Runnable {

		String line = "";

		/**
		 * creating constructor for class Task
		 * 
		 * @param line
		 */
		public Task(String line) {
			this.line = line;
		}

		/**
		 * Looking for a first character in words and increasing counter if
		 * character is found
		 */
		@Override
		public void run() {

			for (int i = 0; i < line.length(); i++) {

				if (String.valueOf(firstChar).equalsIgnoreCase(
						Character.toString(line.charAt(i)))) {
					synchronized (lock) {
						counter++;
					}

				}
			}

		}

	}
}