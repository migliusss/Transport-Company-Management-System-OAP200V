package appGui;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Page for handling products 
 */

public class ProductsFrame extends JFrame {
	
	/** Unique ID for instance of object*/
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public ProductsFrame() {
		setResizable(false);
		setTitle("Products");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 338, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/**
		 * Greeting message
		 */
		JLabel productLabel = new JLabel("Products");
		productLabel.setBounds(122, 17, 95, 38);
		productLabel.setFont(new Font("Serif", Font.BOLD, 24));
		contentPane.add(productLabel);
		/**
		 * Button for viewing all the products in database
		 */
		JButton btnViewProducts = new JButton("View Products");
			btnViewProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openProductsTableFrame();
			}
		});
			btnViewProducts.setBounds(100, 72, 117, 29);
		contentPane.add(btnViewProducts);
		
		/**
		 * Button for manually updating product stock on database
		 */
		
		JButton btnUpdateStock = new JButton("Update Stock");
			btnUpdateStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openUpdateStockFrame();
			}
		});
			btnUpdateStock.setBounds(100, 113, 117, 29);
		contentPane.add(btnUpdateStock);
		
		
	}
	
	/**
	 * Method for opening the products window
	 */
	private void openProductsTableFrame() {
	     ProductsTableFrame productsTableFrame = new ProductsTableFrame();
	     productsTableFrame.setVisible(true);
	}
	
	private void openUpdateStockFrame() {
		UpdateStockFrame updateStockFrame = new UpdateStockFrame();
		updateStockFrame.setVisible(true);
		
	}
}
