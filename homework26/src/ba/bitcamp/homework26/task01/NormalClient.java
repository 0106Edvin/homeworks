package ba.bitcamp.homework26.task01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class NormalClient {

	public static void main(String[] args) {
		String link = "";

		/**
		 * creating client socket and connecting him to server
		 */
		try {
			Socket client = new Socket("localhost", 8000);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					client.getOutputStream()));

			/**
			 * creating scanner, that client can write link and link name
			 */
			Scanner input = new Scanner(System.in);
			System.out.println("Please insert link and link name");
			link = input.nextLine();

			/**
			 * Checking if link is correct
			 */
			if (link.length() > 0 && link.contains(" ")) {
				writer.write(link);
				writer.newLine();
				writer.close();
			} else
				System.out.println("Your link is incorrect");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
