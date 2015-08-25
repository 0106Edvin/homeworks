package ba.bitcamp.homework28.task01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ComplaintsBook extends JFrame {
	private static final long serialVersionUID = -5449667027580959489L;
	
	/**
	 * creating text field, label , text area, and button
	 */
	private JTextField fullName = new JTextField();
	private JLabel lblFullName = new JLabel("Full Name");
	private JTextArea complaint = new JTextArea();
	private JLabel lblComplaint = new JLabel("Complaint: ");
	private JButton send = new JButton("Send");

	/**
	 * creating connection
	 */
	private Connection conn;

	/**
	 * constructor for class
	 */
	public ComplaintsBook() {
		/**
		 * setting layout
		 */
		setLayout(new BorderLayout());
		/**
		 * creating box and adding components to box
		 */
		Box box = Box.createVerticalBox();

		box.add(lblFullName);
		box.add(fullName);
		box.add(Box.createVerticalStrut(20));
		box.add(lblComplaint);
		add(box, BorderLayout.NORTH);

		add(complaint, BorderLayout.CENTER);
		add(send, BorderLayout.SOUTH);

		/**
		 * adding action listener on button
		 */
		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/**
				 * taking a name from text field and putting into string name
				 * taking complaint from area and putting into string complaints
				 */
				String name = fullName.getText().toString();
				String complaints = complaint.getText().toString();

				try {
					/**
					 * connecting to data base, and building a query
					 */
					conn = DriverManager
							.getConnection("jdbc:sqlite:C:/Users/User/Desktop/sqlite3/data.db");
					String query = "insert into complaint (id ,ts,date, name, complaint) Values (null"+","
							+ "CURRENT_TIME" +","+"CURRENT_DATE" + ",'"+name + "','" + complaints + "');";
					
					Statement statement = conn.createStatement();
					/**
					 * executing query
					 */
					statement.execute(query);

				} catch (SQLException e1) {
					e1.printStackTrace();
					System.exit(1);
				}
				/**
				 * option pane that will display if everything goes right, and closing system
				 */
				JOptionPane.showMessageDialog(null, "Your complaint has been successfully submitted");
				System.exit(1);
			}
		});

		setTitle("Complaints Book");
		setSize(400, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ComplaintsBook();

	}

}
