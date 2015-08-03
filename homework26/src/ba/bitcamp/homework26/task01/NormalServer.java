package ba.bitcamp.homework26.task01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class NormalServer {

	public static void main(String[] args) {

		try {
			/**
			 * creating server, and socket
			 */
			ServerSocket server = new ServerSocket(8000);
			Socket toCLient = server.accept();

			/**
			 * creating reader and writer for server
			 */
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					toCLient.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
					"ClientLinks.txt"), true));

			String input = "";
			String link = "";
			String linkName = "";

			/**
			 * splitting input from client to linkName and link
			 */
			while (reader.ready()) {

				if (input.split(" ").length > 1) {

					linkName = input.split(" ")[0];
					link = input.split(" ")[1];

				}

			}
			/**
			 * writing link name and link into a file
			 */

			writer.write(linkName + " " + link);
			writer.newLine();
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
