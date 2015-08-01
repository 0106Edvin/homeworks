package ba.btcamp.homework25.task01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends JFrame {
	private static final long serialVersionUID = -3715539087720444453L;

	/**
	 * Creating panel, text area, and text field
	 */
	JPanel panel = new JPanel();
	JTextArea text = new JTextArea();
	JTextField message = new JTextField();

	/**
	 * creating Server socket, socket, reader, and writer and setting them to
	 * null
	 */
	static ServerSocket server = null;
	static Socket toClient = null;
	static BufferedReader reader = null;
	static BufferedWriter writer = null;

	/**
	 * Constructor
	 * 
	 * @throws IOException
	 */
	public Server() throws IOException {

		/**
		 * setting title, size, location and close operation for frame
		 */
		setTitle("Server");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/**
		 * creating a server socket and giving him port 8000 creating a socket
		 * for server, and tells him to accept client
		 */
		server = new ServerSocket(8000);
		toClient = server.accept();

		/**
		 * adding panel on frame, and text area and message field to panel
		 */
		add(panel);
		panel.setLayout(new BorderLayout());
		panel.add(text, BorderLayout.CENTER);
		panel.add(message, BorderLayout.SOUTH);
		text.setEnabled(false);
		text.setOpaque(true);
		text.setOpaque(true);
		text.setFont(new Font("Sans", Font.BOLD, 15));
		text.setBackground(Color.BLACK);

		setVisible(true);

		/**
		 * adding a key listener to a message field which will wait for user to
		 * press enter, and then do some action
		 */
		while (true) {
			message.addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyPressed(KeyEvent e) {

					/**
					 * when server(user) press enter, the message in text area will be
					 * sent to a client, and will be displayed in text area
					 */
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						try {
							writer = new BufferedWriter(new OutputStreamWriter(
									toClient.getOutputStream()));
						} catch (IOException ex) {
							ex.printStackTrace();
						}

						try {
							writer.write(message.getText() + "\n");
							writer.newLine();
							writer.flush();

							if (message.getText().length() > 0) {
								text.append("Server: " + message.getText()
										+ "\n");
							}
							message.setText("");

						} catch (IOException ex) {
							ex.printStackTrace();
						}

					}

				}
			});

			/**
			 * reader wait for a message from client when client send message
			 * reader, decides what to do
			 */
			reader = new BufferedReader(new InputStreamReader(
					toClient.getInputStream()));
			String s = reader.readLine();

			if (s.length() > 0)
				doSomething(s);

		}

	}

	public void doSomething(String s) {

		/**
		 * if message that user sent contains /web open the web page that comes
		 * after /web
		 */
		if (s.split(" ")[0].contains("/web")) {
			String address = s.split(" ")[1];
			try {
				Desktop.getDesktop().browse(new URI("http://" + address));
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
			/**
			 * if message that user sent contains /open open a file that comes
			 * after /open
			 */
		} else if (s.split(" ")[0].contains("/open")) {
			String open = s.split(" ")[1];

			try {
				Desktop.getDesktop().open(new File("open"));
			} catch (IOException e) {
				e.printStackTrace();
			}

			/**
			 * if message that user sent contains /delete delete the file that
			 * comes after /delete
			 */
		} else if (s.split(" ")[0].contains("/delete")) {
			String delete = s.split(" ")[1];

			File fileToDelete = new File(delete);
			fileToDelete.delete();

			/**
			 * if message that user sent contains /list list all files that are
			 * in folder, that comes after /list
			 */
		} else if (s.split(" ")[0].contains("/list")) {
			String list = s.split(" ")[1];
			File f = new File(list);
			String[] arr = f.list();

			for (int i = 0; i < arr.length; i++) {
				text.append(arr[i] + "\n");
			}

			/**
			 * if message does not contain /web, /open, /delete, ot /list, then
			 * just print message to text area
			 */

		} else {
			text.append("Client: " + s + "\n");
		}

	}

	public static void main(String[] args) throws IOException {
		new Server();
	}

}
