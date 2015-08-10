package ba.bitcamp.weekend08.task01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		try {
			/**
			 * Creating a client and connecting him to server.
			 * Creating writer, and Scanner
			 */
			Socket client = new Socket ("localhost", 8000);
			BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(client.getOutputStream()));
			
			Scanner input = new Scanner (System.in);
			
			/**
			 * sending a message to a server
			 */
			writer.write(input.nextLine());
			writer.newLine();
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
