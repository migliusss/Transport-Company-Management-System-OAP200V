package appGui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

import database.DatabaseHelper;

public class FileManagerFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    final String[] selectedFolder = {"C:\\"};

    public FileManagerFrame() {
        setResizable(false);
        setTitle("File Manager");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnSelectFolder = new JButton("Select Folder");
        btnSelectFolder.setBounds(316, 189, 117, 29);
        contentPane.add(btnSelectFolder);

        JButton btnSaveFromDatabase = new JButton("Save From Database");
        btnSaveFromDatabase.setBounds(6, 189, 200, 29);
        contentPane.add(btnSaveFromDatabase);

        JLabel lblCurrentFolder = new JLabel("Current Folder: " + selectedFolder[0]);
        lblCurrentFolder.setBounds(6, 250, 479, 16);
        contentPane.add(lblCurrentFolder);

        // Add ActionListener to the Save From Database button
        btnSaveFromDatabase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Check if a folder has been selected
                if (selectedFolder[0].equals("C:\\")) {
                    JOptionPane.showMessageDialog(FileManagerFrame.this, "Please select a folder first", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Stop the save operation if no folder is selected
                }

                // Create a database helper instance
                DatabaseHelper dbHelper = new DatabaseHelper();

                // Get the list of table names from the database
                try {
                    List<String> tableNames = dbHelper.getTableNames();
                    if (tableNames.isEmpty()) {
                        JOptionPane.showMessageDialog(FileManagerFrame.this, "No tables found in the database", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Create a popup menu with table names
                        JPopupMenu popupMenu = new JPopupMenu();
                        for (String tableName : tableNames) {
                            JMenuItem menuItem = new JMenuItem(tableName);
                            menuItem.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    // Handle the selection of a table
                                    String selectedTable = ((JMenuItem) e.getSource()).getText();
                                    // Perform the save operation for the selected table
                                    saveFromDatabase(selectedTable);
                                }
                            });
                            popupMenu.add(menuItem);
                        }

                        // Show the popup menu
                        popupMenu.show(btnSaveFromDatabase, 0, btnSaveFromDatabase.getHeight());
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(FileManagerFrame.this, "Error fetching table names from the database", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add ActionListener to the Select Folder button
        btnSelectFolder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a customized file chooser using FileSystemView
                JFileChooser fileChooser = new JFileChooser(selectedFolder[0], FileSystemView.getFileSystemView()) {
                    private static final long serialVersionUID = 1L;

					@Override
                    protected JDialog createDialog(Component parent) throws HeadlessException {
                        JDialog dialog = super.createDialog(parent);

                        // Ensure that the container has at least 2 components before attempting removal
                        if (dialog.getContentPane().getComponentCount() > 1) {
                            // Remove the second component, which is the "Save as:" panel
                            dialog.getContentPane().remove(1);
                        }

                        return dialog;
                    }
                };

                // Set the file chooser to allow selection of directories only
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        return f.isDirectory();
                    }

                    @Override
                    public String getDescription() {
                        return "Directories only";
                    }
                });

                // Show the dialog and get the selected folder
                int result = fileChooser.showSaveDialog(FileManagerFrame.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Update the selectedFolder array with the chosen path
                    selectedFolder[0] = fileChooser.getSelectedFile().getPath();
                    lblCurrentFolder.setText("Current Folder: " + selectedFolder[0]);
                }
            }
        });
    }

    private void saveFromDatabase(String tableName) {
        // Get the selected folder path
        String selectedFolderPath = selectedFolder[0];

        // Specify the file path where the table will be saved (you can customize the file name)
        String filePath = selectedFolderPath + File.separator + tableName + ".txt";

        // Create a database helper instance
        DatabaseHelper dbHelper = new DatabaseHelper();

        // Perform the save operation for the selected table
        try {
            dbHelper.saveTableToFile(tableName, filePath);
            JOptionPane.showMessageDialog(FileManagerFrame.this, "Table saved to file: " + filePath, "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(FileManagerFrame.this, "Error saving table to file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
