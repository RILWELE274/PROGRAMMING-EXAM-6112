/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.productapptest;

/**
* Unit tests for the Product class (Question 1).
*/
public class ProductTest {

    /**
     * Helper method to build the sample data exactly as shown in the exam paper.
     */
    private Product buildSampleProduct() {
        String[] names = {
                "Cozy Nights Monarch mattress",
                "Restonic Barbados mattress",
                "Sealy Phuket mattress"
        };
        int[][] sales = {
                {25, 18, 20},   // Total = 63
                {15, 10, 12},   // Total = 37
                {18, 15, 20}    // Total = 53
        };
        return new Product(names, sales);
    }

    /**
     * Unit Test 1 (Required)
     * Verifies that GetTotalProductsSold() returns 153.
     */
    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        // Arrange
        Product product = buildSampleProduct();

        // Act
        int actualTotal = product.GetTotalProductsSold();

        // Assert
        assertEquals("Total products sold should be 153", 153, actualTotal);
    }

    /**
     * Unit Test 2 (Required)
     * Verifies that GetAverageProductSold() returns 51.0 (153 total / 3 products).
     */
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        // Arrange
        Product product = buildSampleProduct();

        // Act
        double actualAverage = product.GetAverageProductSold();

        // Assert
        assertEquals("Average products sold should be 51.0", 51.0, actualAverage, 0.0001);
    }
}

