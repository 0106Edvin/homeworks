package ba.bitcamp.weekend08.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		try {
			/**
			 * creating server and reader
			 */
			ServerSocket server = new ServerSocket(8000);
			Socket client = server.accept();

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			/**
			 * putting message from client into a string
			 */
			String inputMessage = "";
			inputMessage = reader.readLine();
			System.out.println(inputMessage);

			/**
			 * checking if file that client sent exist on server computer.
			 * If exist print 1, if not print 0
			 */

			File fileToCheck = new File(inputMessage);
			if (fileToCheck.exists()) {
				System.out.println("1");
			} else
				System.out.println("0");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
