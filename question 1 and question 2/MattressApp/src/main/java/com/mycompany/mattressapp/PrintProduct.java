/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mattressapp;


/**
* PrintProduct is responsible for printing the sales report to the console.
* It is kept separate from the Product class so that calculation logic
* and presentation logic remain independent (single-responsibility principle).
*/
public class PrintProduct {

    // The Product instance whose data will be printed.
    private final Product product;

    /**
     * Constructor receives the Product object that holds the sales data.
     *
     * @param product the Product to be reported on
     */
    public PrintProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        this.product = product;
    }

    /**
     * Prints the total number of products sold across all products and months.
     * Delegates the actual calculation to the Product class.
     */
    public void printTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    /**
     * Prints the average number of products sold per product.
     * The sample screenshot shows a whole number, so we round the result.
     */
    public void printAverageProductSales() {
        System.out.println("AVERAGE PRODUCT SALES: "
                + Math.round(product.GetAverageProductSold()));
    }

    /**
     * Prints the most popular product in the format "Name (total)".
     * Delegates the determination to the Product class.
     */
    public void printMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }

    /**
     * Prints the full formatted report: header, total, average, and
     * the most popular product. This is the method called by the driver.
     */
    public void printReport() {
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("***************************");
        printTotalProductSales();
        printAverageProductSales();
        printMostPopularProduct();
    }
}