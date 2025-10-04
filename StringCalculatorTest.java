package com.stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for StringCalculator following TDD approach.
 * Ensures 100% line and branch coverage at every step.
 * Maximum complexity (CCN) per function should be 3.
 */
public class StringCalculatorTest {
    
    private StringCalculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }
    
    /**
     * Test 1: The smallest possible failing test
     * Input: empty string ""
     * Expected: 0
     */
    @Test
    void add_EmptyString_ReturnsZero() {
        // Arrange
        String input = "";
        
        // Act
        int result = calculator.add(input);
        
        // Assert
        assertEquals(0, result, "Empty string should return 0");
    }
    
    /**
     * Test 2: Single number
     * Input: "1"
     * Expected: 1
     */
    @Test
    void add_SingleNumber_ReturnsNumber() {
        // Arrange
        String input = "1";
        
        // Act
        int result = calculator.add(input);
        
        // Assert
        assertEquals(1, result, "Single number '1' should return 1");
    }
}
