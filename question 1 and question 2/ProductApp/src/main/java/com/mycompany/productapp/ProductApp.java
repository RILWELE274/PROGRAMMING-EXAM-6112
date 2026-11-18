/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
* Swing GUI for Question 2: captures customer/product/price,
* calculates VAT, Commission and Total, saves to data.txt
* and displays a message dialog.
*/
public class ProductApp extends JFrame {

    // UI components
    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    // Drop-down product list
    private static final String[] PRODUCTS = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
    };

    public ProductApp() {
        super("Product App");
        buildUi();
        buildMenu();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(520, 260);
        setLocationRelativeTo(null);
    }

    /** Builds the main form layout. */
    private void buildUi() {
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Customer Name
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        form.add(new JLabel("Customer Name:"), gbc);
        txtCustomerName = new JTextField(20);
        gbc.gridx = 1; gbc.weightx = 1;
        form.add(txtCustomerName, gbc);

        // Product combo
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        form.add(new JLabel("Select Product:"), gbc);
        cmbProduct = new JComboBox<>(PRODUCTS);
        gbc.gridx = 1; gbc.weightx = 1;
        form.add(cmbProduct, gbc);

        // Price
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        form.add(new JLabel("Enter Price:"), gbc);
        txtPrice = new JTextField(20);
        gbc.gridx = 1; gbc.weightx = 1;
        form.add(txtPrice, gbc);

        // Process button (spans two columns)
        btnProcess = new JButton("PROCESS");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        form.add(btnProcess, gbc);

        btnProcess.addActionListener(this::processSale);

        add(form);
    }

    /** Builds File and Tools menus. */
    private void buildMenu() {
        JMenuBar bar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        bar.add(fileMenu);

        // Tools menu
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem   = new JMenuItem("Clear");

        processItem.addActionListener(this::processSale);
        clearItem.addActionListener(this::clearForm);

        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);
        bar.add(toolsMenu);

        setJMenuBar(bar);
    }

    /** Core processing: validate, calculate, display, persist. */
    private void processSale(ActionEvent e) {
        String customer = txtCustomerName.getText().trim();
        String product  = (String) cmbProduct.getSelectedItem();
        String priceStr = txtPrice.getText().trim();

        // Basic validation
        if (customer.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter the customer name.",
                    "Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
       
        double price;
        try {
            price = Double.parseDouble(priceStr);
            if (price < 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid non-negative price.",
                    "Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Calculations through the interface
        IProductCalculations calc = new ProductCalculations(price);
        double vat        = calc.GetVat();
        double commission = calc.GetCommission();
        double total      = calc.GetTotal();

        // ==========================================
        // FIXED HERE: Added for new lines
        // ==========================================
        String message =
                "Customer Name: " + customer + " " +
                "Product: " + product + " " +
                "VAT: R " + vat + " " +
                "COMMISSION: R " + commission + " " +
                "TOTAL: R " + total;

        // Message box (matches sample output)
        JOptionPane.showMessageDialog(this, message, "Message",
                JOptionPane.INFORMATION_MESSAGE);

        // Persist to data.txt
        try {
            DataLogger.save(customer, product, vat, commission, total);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error saving to file: " + ex.getMessage(),
                    "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /** Clears text fields and resets combo to index 0. */
    private void clearForm(ActionEvent e) {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}
