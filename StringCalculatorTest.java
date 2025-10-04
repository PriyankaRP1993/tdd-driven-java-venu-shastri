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
    
    /**
     * Test 3: Two numbers separated by comma
     * Input: "1,2"
     * Expected: 3
     */
    @Test
    void add_TwoNumbers_ReturnsSum() {
        // Arrange
        String input = "1,2";
        
        // Act
        int result = calculator.add(input);
        
        // Assert
        assertEquals(3, result, "Two numbers '1,2' should return 3");
    }
    
    /**
     * Test 4: Multiple numbers (unknown amount)
     * Input: "1,2,3,4,5"
     * Expected: 15
     */
    @Test
    void add_MultipleNumbers_ReturnsSum() {
        // Arrange
        String input = "1,2,3,4,5";
        
        // Act
        int result = calculator.add(input);
        
        // Assert
        assertEquals(15, result, "Multiple numbers '1,2,3,4,5' should return 15");
    }
    
    /**
     * Test 5: Numbers separated by newlines
     * Input: "1\n2,3"
     * Expected: 6
     */
    @Test
    void add_NewlineDelimiters_ReturnsSum() {
        // Arrange
        String input = "1\n2,3";
        
        // Act
        int result = calculator.add(input);
        
        // Assert
        assertEquals(6, result, "Numbers '1\\n2,3' should return 6");
    }
    
    /**
     * Test 6: Numbers separated only by newlines
     * Input: "1\n2\n3"
     * Expected: 6
     */
    @Test
    void add_OnlyNewlineDelimiters_ReturnsSum() {
        // Arrange
        String input = "1\n2\n3";
        
        // Act
        int result = calculator.add(input);
        
        // Assert
        assertEquals(6, result, "Numbers '1\\n2\\n3' should return 6");
    }
    
    /**
     * Test 7: Custom delimiter with semicolon
     * Input: "//;\n1;2"
     * Expected: 3
     */
    @Test
    void add_CustomDelimiterSemicolon_ReturnsSum() {
        // Arrange
        String input = "//;\n1;2";
        
        // Act
        int result = calculator.add(input);
        
        // Assert
        assertEquals(3, result, "Custom delimiter '//;\\n1;2' should return 3");
    }
    
    /**
     * Test 8: Custom delimiter with pipe
     * Input: "//|\n1|2|3"
     * Expected: 6
     */
    @Test
    void add_CustomDelimiterPipe_ReturnsSum() {
        // Arrange
        String input = "//|\n1|2|3";
        
        // Act
        int result = calculator.add(input);
        
        // Assert
        assertEquals(6, result, "Custom delimiter '//|\\n1|2|3' should return 6");
    }
    
    /**
     * Test 9: Single negative number throws exception
     * Input: "-1"
     * Expected: IllegalArgumentException with message "negatives not allowed: -1"
     */
    @Test
    void add_SingleNegativeNumber_ThrowsException() {
        // Arrange
        String input = "-1";
        
        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> calculator.add(input)
        );
        assertEquals("negatives not allowed: -1", exception.getMessage());
    }
    
    /**
     * Test 10: Multiple negative numbers throws exception with all negatives
     * Input: "1,-2,3,-4"
     * Expected: IllegalArgumentException with message "negatives not allowed: -2, -4"
     */
    @Test
    void add_MultipleNegativeNumbers_ThrowsExceptionWithAllNegatives() {
        // Arrange
        String input = "1,-2,3,-4";
        
        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> calculator.add(input)
        );
        assertEquals("negatives not allowed: -2, -4", exception.getMessage());
    }
    
    /**
     * Test 11: Numbers bigger than 1000 should be ignored
     * Input: "2,1001"
     * Expected: 2 (1001 is ignored)
     */
    @Test
    void add_NumbersBiggerThan1000_AreIgnored() {
        // Arrange
        String input = "2,1001";
        
        // Act
        int result = calculator.add(input);
        
        // Assert
        assertEquals(2, result, "Numbers bigger than 1000 should be ignored: '2,1001' should return 2");
    }
    
    /**
     * Test 12: Numbers equal to 1000 should be included
     * Input: "2,1000"
     * Expected: 1002
     */
    @Test
    void add_NumbersEqualTo1000_AreIncluded() {
        // Arrange
        String input = "2,1000";
        
        // Act
        int result = calculator.add(input);
        
        // Assert
        assertEquals(1002, result, "Numbers equal to 1000 should be included: '2,1000' should return 1002");
    }
    
    /**
     * Test 13: Multi-character delimiter with bracket notation
     * Input: "//[***]\n1***2***3"
     * Expected: 6
     */
    @Test
    void add_MultiCharacterDelimiterWithBrackets_ReturnsSum() {
        // Arrange
        String input = "//[***]\n1***2***3";
        
        // Act
        int result = calculator.add(input);
        
        // Assert
        assertEquals(6, result, "Multi-character delimiter '//[***]\\n1***2***3' should return 6");
    }
    
    /**
     * Test 14: Multi-character delimiter with different characters
     * Input: "//[abc]\n1abc2abc3"
     * Expected: 6
     */
    @Test
    void add_MultiCharacterDelimiterDifferentChars_ReturnsSum() {
        // Arrange
        String input = "//[abc]\n1abc2abc3";
        
        // Act
        int result = calculator.add(input);
        
        // Assert
        assertEquals(6, result, "Multi-character delimiter '//[abc]\\n1abc2abc3' should return 6");
    }
}
