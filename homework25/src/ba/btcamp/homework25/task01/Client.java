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
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame {
	private static final long serialVersionUID = -4175265375770545437L;

	/**
	 * Creating panel, text area, and text field
	 */
	JPanel panel = new JPanel();
	JTextArea text = new JTextArea();
	JTextField message = new JTextField();

	/**
	 * Creating socket, reader, and writer and setting them to null
	 */
	static Socket client = null;
	static BufferedReader reader = null;
	static BufferedWriter writer = null;

	/**
	 * creating constructor
	 * 
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public Client() throws UnknownHostException, IOException {

		/**
		 * setting title, size, location and close operation for frame
		 */
		setTitle("Client");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/**
		 * connecting clinet to server
		 */
		client = new Socket("localhost", 8000);

		/**
		 * adding panel on frame, and text area and message field to panel
		 */
		add(panel);
		panel.setLayout(new BorderLayout());
		panel.add(text, BorderLayout.CENTER);
		panel.add(message, BorderLayout.SOUTH);
		text.setEnabled(false);
		text.setOpaque(true);
		text.setFont(new Font("Sans", Font.BOLD, 15));
		text.setBackground(Color.BLACK);

		setVisible(true);

		while (true) {

			/**
			 * Creating a reader that wait for a message from server and then
			 * decide what to do
			 */
			reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			String s = reader.readLine();
			if (s.length() > 0)
				doSomething(s);

			/**
			 * Creating key listener for a message text field
			 */
			message.addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {
				}

				@Override
				public void keyReleased(KeyEvent e) {
				}

				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {

						/**
						 * 
						 * when client press enter, the message in text area
						 * will be sent to a server, and will be displayed in
						 * text area
						 */
						try {
							writer = new BufferedWriter(new OutputStreamWriter(
									client.getOutputStream()));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							writer.write(message.getText());
							writer.newLine();
							writer.flush();

							if (message.getText().length() > 0) {
								text.append("Client: " + message.getText()
										+ "\n");
							}
							message.setText("");

						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			});

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
			text.append("Server: " + s + "\n");
		}

	}

	public static void main(String[] args) throws UnknownHostException,
			IOException {

		new Client();

	}

}
