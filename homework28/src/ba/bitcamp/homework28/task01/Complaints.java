package ba.bitcamp.homework28.task01;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Complaints extends JFrame {
	private static final long serialVersionUID = 6731746686844967836L;
	
	/**
	 * Creating connection, array list, and text area
	 */
	private static Connection conn;
	private static ArrayList<Complaint> complaints = new ArrayList<>();
	private JTextArea area = new JTextArea();

	/**
	 * Method which collects complaints from data base, and display them on text area
	 */
	public static void listOfComplaints() {

		try {
			/**
			 * connecting to a data base and creating query
			 */
			conn = DriverManager
					.getConnection("jdbc:sqlite:C:/Users/User/Desktop/sqlite3/data.db");
			Statement statement = conn.createStatement();
			
			ResultSet result = statement
					.executeQuery("select * from complaint");
			
			/**
			 * taking elements from data base and creating a complaint with them
			 */
			while (result.next()) {

				Integer id = result.getInt(1);
				String date = result.getString(2);
				String time = result.getString(3);
				String name = result.getString(4);
				String complaint = result.getString(5);

				Complaint c = new Complaint(id, time, date, name, complaint);

				/**
				 * adding complaint to array list
				 */
				complaints.add(c);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}

	}
	/**
	 * constructor for complaints
	 */
	public Complaints() {
		/**
		 * adding text area on JFrame
		 * setting area editable on false
		 * setting font, and color
		 */
		add(area);
		area.setEditable(false);
		area.setFont(new Font("Sans", Font.BOLD, 15));
		area.setForeground(Color.BLACK);

		/**
		 * taking complaints one by one from array list,
		 * and appending them to area
		 */
		for (Complaint c : complaints) {
			area.append(c.toString());
			area.append("\n");
		}

		/**
		 * setting title, size, location, close operation 
		 * and visibility od frame 
		 */
		setTitle("Complaints");
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		/**
		 * calling method list of complaints
		 */
		listOfComplaints();
		new Complaints();

	}

}
