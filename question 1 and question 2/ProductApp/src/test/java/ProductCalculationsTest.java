/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.productapp;

import org.junit.Test;
import static org.junit.Assert.*;
import package com.mycompany.productapp.ProductCalculationste;

/**
 * Unit tests for the ProductCalculations class (Question 2).
 */
public class ProductCalculationsTest {

    // The price used in the exam screenshots
    private static final double PRICE = 3500.0;

    /**
     * Unit Test 1 (Required)
     * Verifies that GetVat() returns 525.0 (15% of 3500).
     */
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        // Arrange
        ProductCalculations calc = new ProductCalculations(PRICE);

        // Act
        double actualVat = calc.GetVat();

        // Assert
        assertEquals("VAT should be 15% of 3500 = 525.0", 525.0, actualVat, 0.0001);
    }

    /**
     * Unit Test 2 (Required)
     * Verifies that GetTotal() returns 4200.0 (Price + VAT + Commission).
     */
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        // Arrange
        ProductCalculations calc = new ProductCalculations(PRICE);

        // Act
        double actualTotal = calc.GetTotal();

        // Assert
        assertEquals("Total should be 3500 + 525 + 175 = 4200.0", 4200.0, actualTotal, 0.0001);
    }

    /**
     * Bonus Test (To secure extra marks for code quality)
     * Verifies that GetCommission() returns 175.0 (5% of 3500).
     */
    @Test
    public void GetCommission_WithValidData_ReturnsCorrectValue() {
        // Arrange
        ProductCalculations calc = new ProductCalculations(PRICE);

        // Act
        double actualCommission = calc.GetCommission();

        // Assert
        assertEquals("Commission should be 5% of 3500 = 175.0", 175.0, actualCommission, 0.0001);
    }
}
