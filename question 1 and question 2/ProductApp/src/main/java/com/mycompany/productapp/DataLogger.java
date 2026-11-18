/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productapp;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class DataLogger {

    private static final String FILE_NAME = "data.txt";

    private DataLogger() { }

    public static void save(String customer, String product,
                            double vat, double commission, double total) throws IOException {

        File file = new File(FILE_NAME);
        // If the file doesn't exist, OR if it is empty, we need to write the header
        boolean isNewFile = !file.exists() || file.length() == 0;

        // The 'true' here means we append to the file, rather than overwriting it
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
           
            if (isNewFile) {
                writer.write("DATA LOG");
                writer.newLine();
                writer.write("***************************");
                writer.newLine();
            }
           
            writer.write("Customer Name: " + customer);
            writer.newLine();
            writer.write("Product: " + product);
            writer.newLine();
            writer.write("VAT: R " + vat);
            writer.newLine();
            writer.write("COMMISSION: R " + commission);
            writer.newLine();
            writer.write("TOTAL: R " + total);
            writer.newLine();
            writer.write("***************************");
            writer.newLine();
            writer.newLine(); // Add an extra blank line between records for neatness
        }
    }
}