package ba.bitcamp.homework26.task01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class Server {
	public static void main(String[] args) {

		try {
			/**
			 * Creating server
			 */
			ServerSocket server = new ServerSocket(8000);

			/**
			 * Creating two array lists, one for links, other for link names
			 */
			ArrayList<String> linkSet = new ArrayList<>();
			ArrayList<String> nameSet = new ArrayList<>();

			/**
			 * creating a reader that will read from file
			 */

			BufferedReader linksToRead = new BufferedReader(new FileReader(
					"ClientLinks.txt"));
			while (true) {
				Socket client = server.accept();

				/**
				 * Splitting links, and link names
				 */
				while (linksToRead.ready()) {
					String line = linksToRead.readLine();
					String link = "";
					String linkName = "";

					link = line.split(" ")[0];
					linkName = line.split(" ")[1];

					if (!link.contains("www.")) {
						linkSet.add("www." + link);
					} else {
						linkSet.add(link);
					}
					nameSet.add(linkName);
				}

				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(client.getOutputStream()));

				BufferedReader fileReader = null;
				String htmlDoc = "";

				try {
					/**
					 * reading from index.html file
					 */
					fileReader = new BufferedReader(new FileReader(new File(
							"index.html")));

				} catch (NullPointerException e) {
					continue;
				}

				while (fileReader.ready()) {
					htmlDoc += fileReader.readLine();
				}
				/**
				 * adding links to html
				 */
				Iterator<String> it = linkSet.iterator();
				int i = 0;
				while (it.hasNext()) {
					it.next();
					htmlDoc += "Site link: " + "<a href =" + "http://"
							+ linkSet.get(i) + ">" + linkSet.get(i) + "</a> "
							+ "Site Name: " + nameSet.get(i) + "<br>\n";
					i++;
				}

				htmlDoc += "</p></body></html>";
				writer.write(htmlDoc);
				writer.close();
				client.close();
				fileReader.close();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
