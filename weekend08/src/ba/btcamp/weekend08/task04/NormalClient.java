package ba.btcamp.weekend08.task04;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class NormalClient {

	public static void main(String[] args) {

		try {
			Socket client = new Socket("localhost", 8888);
			System.out.println("Client connected");
			// Reading from file output.jpg
			FileInputStream reader = new FileInputStream(new File("image.jpg"));
			OutputStream writer = client.getOutputStream();

			byte[] buffer = new byte[1024];
			int readBytes;
			// writing files to server
			while ((readBytes = reader.read(buffer, 0, 1024)) > 0) {
				writer.write(buffer, 0, readBytes);
			}
			System.out.println("File sent");
			writer.close();
			client.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
