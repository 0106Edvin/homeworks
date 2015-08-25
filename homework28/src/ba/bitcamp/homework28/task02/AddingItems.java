package ba.bitcamp.homework28.task02;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddingItems extends JFrame {
	private static final long serialVersionUID = -1778530873341102023L;

	private JPanel panel = new JPanel();
	private JLabel name = new JLabel("Name");
	private JLabel code = new JLabel("Prodcut Code");
	private JLabel price = new JLabel("Product Price");
	private JTextField fieldName = new JTextField();
	private JTextField fieldCode = new JTextField();
	private JTextField fieldPrice = new JTextField();
	private JButton button = new JButton("Add");

	private Connection conn;

	static long productCode;

	private AddingItems() {
		add(panel);
		panel.setLayout(new GridLayout(7, 1));
		panel.add(name);
		panel.add(fieldName);
		panel.add(code);
		panel.add(fieldCode);
		panel.add(price);
		panel.add(fieldPrice);
		panel.add(button);

		/**
		 * adding action listener to button
		 */
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/**
				 * taking product name from text field and put into string productName
				 */
				String productName = fieldName.getText().toString();
				
				/**
				 * checking if product code have 10 digits
				 * If not show message dialog and exit program
				 */
				if (fieldCode.getText().length() != 10) {
					JOptionPane.showMessageDialog(null,
							"Your product code is incorrect");
					System.exit(1);
				} else {
					/**
					 * if code is correct parse it and put into long productCode
					 */
					productCode = Long.parseLong(fieldCode.getText()
							);
				}
				
				/**
				 * taking price from text field and put into double price
				 */
				Double price = Double.parseDouble(fieldPrice.getText()
						.toString());

				try {
					/**
					 * connect to data base product
					 */
					conn = DriverManager
							.getConnection("jdbc:sqlite:C:/Users/User/Desktop/sqlite3/product.db");
					System.out.println("Connected");
					Statement statement = conn.createStatement();

					/**
					 * checking if there is already product in data base
					 * with same code as product we want to add
					 * If there is, show message dialog and exit 
					 */
					ResultSet result = statement
							.executeQuery("select * from product where code ="
									+ productCode);
					while (result.next()) {
						if (productCode == result.getLong(3)) {
							JOptionPane.showMessageDialog(null,
									"Product code already exist");
							System.exit(1);
						}
						
					}
					/**
					 * inserting product into data base
					 */

					String query = "insert into product (id, name, code, price) Values (null"
							+ ",'"
							+ productName
							+ "',"
							+ productCode
							+ ","
							+ price + ");";

					/**
					 * executing query
					 */
					statement.executeUpdate(query);

				} catch (SQLException e1) {
					e1.printStackTrace();
					System.exit(1);
				}
				/**
				 * if product is added show message dialog
				 */
				JOptionPane.showMessageDialog(null,
						"Your product has been successfully added");
				System.exit(1);
			}
		});

		setTitle("Add Product");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AddingItems();
	}
}
