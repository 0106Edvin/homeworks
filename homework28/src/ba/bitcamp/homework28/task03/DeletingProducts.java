package ba.bitcamp.homework28.task03;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class DeletingProducts extends JFrame {
	private static final long serialVersionUID = -9111612685245721243L;

	/**
	 * creating panel, array list of products, JList, default list model, button, connection
	 */
	private JPanel panel = new JPanel();
	private ArrayList<Product> products = new ArrayList<Product>();
	private JList<Product> toDelete = null;
	private DefaultListModel<Product> model = null;
	private JButton button = new JButton("Delete");

	private Connection conn;

	public DeletingProducts() {
		/**
		 * adding panel on frame and setting layout
		 */
		add(panel);
		panel.setLayout(new BorderLayout());

		try {
			/**
			 * connecting to data base product
			 */
			conn = DriverManager
					.getConnection("jdbc:sqlite:C:/Users/User/Desktop/sqlite3/product.db");
			Statement statement = conn.createStatement();
			/**
			 * taking elements from data base, and creating product
			 */
			String query = "select * from product";
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				Integer id = result.getInt(1);
				String name = result.getString(2);
				long code = result.getLong(3);
				Double price = result.getDouble(4);

				/**
				 * adding product to list
				 */
				Product p = new Product(id, name, code, price);
				products.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		/**
		 * creating list with model
		 */
		model = new DefaultListModel<Product>();
		toDelete = new JList<Product>(model);

		/**
		 * adding proucts to list
		 */
		for (Product p : products) {
			model.addElement(p);

		}

		/**
		 * adding action listener to button
		 */
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Product p = (Product) toDelete.getSelectedValue();

				Statement statement;
				try {
					/**
					 * building query that will delete product from data base 
					 */
					statement = conn.createStatement();
					statement.executeQuery("delete from product where id ="
							+ p.getId());

					setVisible(true);

				} catch (SQLException e1) {

				}
				
				for (Product p1 : products) {
					model.addElement(p1);
				}
				model.clear();
			}
		});
		panel.add(toDelete);
		panel.add(button, BorderLayout.SOUTH);

		setTitle("Delete Product");
		setSize(400, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new DeletingProducts();

	}
}
