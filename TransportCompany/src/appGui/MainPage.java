package appGui;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public MainPage() {
        setResizable(false);
        setTitle("Transport Company");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 540, 410);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblMainPageGreeting = new JLabel("Transport Company Software");
        lblMainPageGreeting.setFont(new Font("Serif", Font.BOLD, 24));
        lblMainPageGreeting.setBounds(109, 21, 315, 29);
        contentPane.add(lblMainPageGreeting);

        JButton btnNewButton = new JButton("Customers");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(203, 93, 145, 29);
        contentPane.add(btnNewButton);

        JButton btnOrders = new JButton("Orders");
        btnOrders.setBounds(204, 150, 145, 29);
        contentPane.add(btnOrders);

        /**
         * Button for opening the Products page
         */
        JButton btnProducts = new JButton("Products");
        btnProducts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openProductsFrame();
            }
        });
        btnProducts.setBounds(204, 212, 145, 29);
        contentPane.add(btnProducts);

        JButton btnNewButton_1 = new JButton("Log Out");
        btnNewButton_1.setBounds(422, 325, 83, 29);
        contentPane.add(btnNewButton_1);

        // Add ActionListener to the Log Out button
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Dispose of the current frame (main page)
                dispose();
                // Open the login page
                openLoginPage();
            }
        });

        JButton btnPayments = new JButton("Payments");
        btnPayments.setBounds(204, 274, 145, 29);
        contentPane.add(btnPayments);

        JButton btnFileManagement = new JButton("File Management");
        btnFileManagement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFileManagerFrame();
            }
        });
        btnFileManagement.setBounds(0, 325, 156, 29);
        contentPane.add(btnFileManagement);
    }

    /**
     * Method for opening the products window
     */
    private void openProductsFrame() {
        ProductsFrame productsFrame = new ProductsFrame();
        productsFrame.setVisible(true);
    }

    private void openFileManagerFrame() {
        FileManagerFrame fileManagerFrame = new FileManagerFrame();
        fileManagerFrame.setVisible(true);
    }

    /**
     * Method for opening the login page
     */
    private void openLoginPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
    }
}
