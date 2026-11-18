/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mattressapp;



import java.util.Scanner;

/**
* It:
*   1. Declares a single-dimensional array holding the three product names.
*   2. Declares a two-dimensional array [product][month] to hold sales figures.
*   3. Populates the 2D array from user input (Scanner).
*   4. Builds a Product object and uses PrintProduct to display the report.
*/
public class MattressApp {

    // Single-dimensional array: the three mattress products.
    private static final String[] PRODUCT_NAMES = {
            "Cozy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
    };

    // Number of months captured per product.
    private static final int MONTHS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Two-dimensional array: rows = products, columns = months.
        int[][] sales = new int[PRODUCT_NAMES.length][MONTHS];

        // Populate the 2D array from user input.
        for (int product = 0; product < PRODUCT_NAMES.length; product++) {
            for (int month = 0; month < MONTHS; month++) {
                System.out.print("Enter number of sales for month " + (month + 1)
                        + " for " + PRODUCT_NAMES[product] + ": ");

                // Read and validate the input so the app never crashes on bad data.
                while (!scanner.hasNextInt()) {
                    System.out.print("Invalid number. Please try again: ");
                    scanner.next(); // discard the bad token
                }
                sales[product][month] = scanner.nextInt();
            }
        }

        // Build the domain object and the printer, then display the report.
        Product product = new Product(PRODUCT_NAMES, sales);
        PrintProduct printer = new PrintProduct(product);
        printer.printReport();

        scanner.close();
    }
}
