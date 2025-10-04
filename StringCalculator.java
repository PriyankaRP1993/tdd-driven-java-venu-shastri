package com.stringcalculator;

/**
 * StringCalculator implementation following TDD approach.
 * Ensures maximum complexity (CCN) per function == 3.
 */
public class StringCalculator {
    
    /**
     * Adds numbers in a string format.
     * Handles empty string, comma, newline, and custom delimiters.
     * 
     * @param numbers String containing numbers to add
     * @return Sum of the numbers
     */
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        
        return calculateSum(parseNumbers(numbers));
    }
    
    /**
     * Parses the input string and extracts numbers based on delimiters.
     * CCN = 3 (if custom delimiter + if bracket notation + return)
     */
    private String parseNumbers(String input) {
        if (input.startsWith("//")) {
            if (input.charAt(2) == '[') {
                // Handle bracket notation for multi-character delimiters
                int closeBracket = input.indexOf(']');
                String delimiter = input.substring(3, closeBracket);
                String numbers = input.substring(closeBracket + 2);
                return numbers.replace(delimiter, ",");
            } else {
                // Handle single character delimiter
                String delimiter = String.valueOf(input.charAt(2));
                return input.substring(4).replace(delimiter, ",");
            }
        }
        return input.replace("\n", ",");
    }
    
    /**
     * Calculates the sum of comma-separated numbers.
     * Validates no negative numbers are present.
     * CCN = 3 (for loop + if statement + if negative check)
     */
    private int calculateSum(String numbers) {
        String[] parts = numbers.split(",");
        int sum = 0;
        
        validateNoNegatives(parts);
        
        for (String part : parts) {
            if (!part.trim().isEmpty()) {
                int number = Integer.parseInt(part.trim());
                if (number <= 1000) {
                    sum += number;
                }
            }
        }
        
        return sum;
    }
    
    /**
     * Validates that no negative numbers are present in the array.
     * Throws IllegalArgumentException if negatives are found.
     * CCN = 3 (for loop + if negative + if not empty list)
     */
    private void validateNoNegatives(String[] parts) {
        java.util.List<String> negatives = new java.util.ArrayList<>();
        
        for (String part : parts) {
            if (!part.trim().isEmpty() && Integer.parseInt(part.trim()) < 0) {
                negatives.add(part.trim());
            }
        }
        
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + String.join(", ", negatives));
        }
    }
}
