/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mattressapp;



/**
 * Product class encapsulates sales data for three products over three months.
 * Demonstrates use of single- and two-dimensional arrays.
 */
public class Product implements IProduct {

    // Single-dimensional array: product names
    private final String[] productNames;
    // Two-dimensional array: [productIndex][monthIndex]
    private final int[][] sales;

    /**
     * Constructor accepts product names and a 2D sales array.
     * Defensive copies are made so internal state cannot be mutated externally.
     */
    public Product(String[] productNames, int[][] sales) {
        if (productNames == null || sales == null)
            throw new IllegalArgumentException("Arrays cannot be null");
        if (productNames.length != sales.length)
            throw new IllegalArgumentException("Mismatched dimensions");

        this.productNames = productNames.clone();
        this.sales = new int[sales.length][];
        for (int i = 0; i < sales.length; i++) {
            this.sales[i] = sales[i].clone();
        }
    }

    // Returns the total of all sales across all products and months. */
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int[] row : sales) {
            for (int value : row) {
                total += value;
            }
        }
        return total;
    }

    // Returns the average sales per product (rounded to 2 decimals). */
    @Override
    public double GetAverageProductSold() {
        if (productNames.length == 0) return 0.0;
        return (double) GetTotalProductsSold() / productNames.length;
    }

    /**
     * Returns the most popular product in the format "Name (total)".
     * If tie, returns the first encountered.
     */
    @Override
    public String GetMostPopularProduct() {
        int bestIndex = 0;
        int bestTotal = sumRow(0);
        for (int i = 1; i < sales.length; i++) {
            int current = sumRow(i);
            if (current > bestTotal) {
                bestTotal = current;
                bestIndex = i;
            }
        }
        return productNames[bestIndex] + " (" + bestTotal + ")";
    }

    // Helper: sum one row of the 2D array. */
    private int sumRow(int row) {
        int sum = 0;
        for (int v : sales[row]) sum += v;
        return sum;
    }

    // Accessors used by PrintProduct / tests
    public String[] getProductNames() { return productNames.clone(); }
    public int[][] getSales() {
        int[][] copy = new int[sales.length][];
        for (int i = 0; i < sales.length; i++) copy[i] = sales[i].clone();
        return copy;
    }
}