package com.algos.practice.revision2025;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for IncreasingSubsequenceLength3
 * 
 * Comprehensive test coverage for the increasing subsequence of length 3 problem including:
 * - Basic examples from problem description
 * - Edge cases (empty, small arrays, boundary conditions)
 * - Various patterns (increasing, decreasing, mixed, duplicates)
 * - Performance tests with larger inputs
 * - Corner cases with negative numbers and extreme values

 * - Consistency checks between solution methods
 */
public class IncreasingSubsequenceLength3Test {

    private IncreasingSubsequenceLength3 solution;

    @BeforeEach
    void setUp() {
        solution = new IncreasingSubsequenceLength3();
    }

    // Basic test cases from problem examples
    @Test
    void testBasicIncreasingArray() {
        // Test case: [1, 2, 3, 4, 5] → true
        int[] arr = {1, 2, 3, 4, 5};
        assertTrue(solution.hasIncreasingSubsequence(arr));
        assertTrue(solution.findIncreasingSubsequence(arr));

    }

    @Test
    void testBasicDecreasingArray() {
        // Test case: [5, 4, 3, 2, 1] → false
        int[] arr = {5, 4, 3, 2, 1};
        assertFalse(solution.hasIncreasingSubsequence(arr));
        assertFalse(solution.findIncreasingSubsequence(arr));

    }

    @Test
    void testComplexCaseWithTriplet() {
        // Test case: [2, 1, 5, 0, 4, 6] → true
        // Should find triplet like (0, 4, 6) or (1, 4, 6)
        int[] arr = {2, 1, 5, 0, 4, 6};
        assertTrue(solution.hasIncreasingSubsequence(arr));
        assertTrue(solution.findIncreasingSubsequence(arr));

    }

    @Test
    void testAlternatingPattern() {
        // Test case: [1, 2, 1, 2] → false
        int[] arr = {1, 2, 1, 2};
        assertFalse(solution.hasIncreasingSubsequence(arr));
        assertFalse(solution.findIncreasingSubsequence(arr));

    }

    // Edge cases - array length
    @Test
    void testMinimumValidLength() {
        // Test case: [1, 2, 3] → true (minimum possible valid case)
        int[] arr = {1, 2, 3};
        assertTrue(solution.hasIncreasingSubsequence(arr));

    }

    @Test
    void testArrayTooShort() {
        // Arrays with length < 3 should return false
        assertFalse(solution.hasIncreasingSubsequence(new int[]{}));
        assertFalse(solution.hasIncreasingSubsequence(new int[]{1}));
        assertFalse(solution.hasIncreasingSubsequence(new int[]{1, 2}));
        

    }

    @Test
    void testNullInput() {
        // Null input should return false
        assertFalse(solution.hasIncreasingSubsequence(null));
        assertFalse(solution.findIncreasingSubsequence(null));
    }

    // Pattern-based tests
    @Test
    void testStrictlyIncreasingSequence() {
        // All elements in strictly increasing order
        int[] arr = {1, 3, 5, 7, 9, 11};
        assertTrue(solution.hasIncreasingSubsequence(arr));

    }

    @Test
    void testStrictlyDecreasingSequence() {
        // All elements in strictly decreasing order
        int[] arr = {10, 8, 6, 4, 2};
        assertFalse(solution.hasIncreasingSubsequence(arr));

    }

    @Test
    void testAllElementsEqual() {
        // All elements are the same
        int[] arr = {5, 5, 5, 5, 5};
        assertFalse(solution.hasIncreasingSubsequence(arr));

    }

    @Test
    void testTripletAtDifferentPositions() {
        // Test triplet at beginning
        int[] arr1 = {1, 2, 3, 0, 0};
        assertTrue(solution.hasIncreasingSubsequence(arr1));

        
        // Test triplet at end
        int[] arr2 = {5, 5, 1, 2, 3};
        assertTrue(solution.hasIncreasingSubsequence(arr2));

        
        // Test triplet in middle
        int[] arr3 = {0, 0, 1, 2, 3, 0};
        assertTrue(solution.hasIncreasingSubsequence(arr3));

    }

    @Test
    void testWithDuplicateElements() {
        // Test cases with duplicate elements
        int[] arr1 = {1, 1, 2, 2, 3, 3}; // Should find triplet
        assertTrue(solution.hasIncreasingSubsequence(arr1));

        
        int[] arr2 = {3, 3, 2, 2, 1, 1}; // No triplet with duplicates
        assertFalse(solution.hasIncreasingSubsequence(arr2));

        
        int[] arr3 = {1, 2, 2, 3}; // Triplet with some duplicates
        assertTrue(solution.hasIncreasingSubsequence(arr3));

    }

    @Test
    void testWithNegativeNumbers() {
        // Test cases with negative numbers
        int[] arr1 = {-3, -2, -1}; // Negative increasing
        assertTrue(solution.hasIncreasingSubsequence(arr1));

        
        int[] arr2 = {-1, -2, -3}; // Negative decreasing
        assertFalse(solution.hasIncreasingSubsequence(arr2));

        
        int[] arr3 = {-2, 0, 2}; // Mix of negative, zero, positive
        assertTrue(solution.hasIncreasingSubsequence(arr3));

        
        int[] arr4 = {-5, -10, -1, 0, 1}; // Complex negative pattern
        assertTrue(solution.hasIncreasingSubsequence(arr4));

    }

    @Test
    void testExtremeValues() {
        // Test with Integer.MIN_VALUE and Integer.MAX_VALUE
        int[] arr1 = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
        assertTrue(solution.hasIncreasingSubsequence(arr1));

        
        int[] arr2 = {Integer.MAX_VALUE, 0, Integer.MIN_VALUE};
        assertFalse(solution.hasIncreasingSubsequence(arr2));

        
        int[] arr3 = {Integer.MIN_VALUE, Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 2};
        assertTrue(solution.hasIncreasingSubsequence(arr3));

    }

    @Test
    void testComplexPatterns() {
        // Mountain pattern: increases then decreases
        int[] arr1 = {1, 2, 4, 3, 1};
        assertTrue(solution.hasIncreasingSubsequence(arr1));

        
        // Valley pattern: decreases then increases
        int[] arr2 = {5, 3, 1, 2, 4};
        assertTrue(solution.hasIncreasingSubsequence(arr2));

        
        // Zigzag pattern
        int[] arr3 = {1, 4, 2, 5, 3, 6};
        assertTrue(solution.hasIncreasingSubsequence(arr3));

        
        // Wave pattern without valid triplet
        int[] arr4 = {3, 1, 4, 1, 5, 1};
        assertTrue(solution.hasIncreasingSubsequence(arr4));

    }

    @Test
    void testLargerArrays() {
        // Test with larger arrays to ensure O(n) performance
        int[] largeIncreasing = new int[1000];
        for (int i = 0; i < 1000; i++) {
            largeIncreasing[i] = i;
        }
        assertTrue(solution.hasIncreasingSubsequence(largeIncreasing));
        
        int[] largeDecreasing = new int[1000];
        for (int i = 0; i < 1000; i++) {
            largeDecreasing[i] = 1000 - i;
        }
        assertFalse(solution.hasIncreasingSubsequence(largeDecreasing));
        
        // Pattern that has triplets
        int[] largePattern = new int[1000];
        for (int i = 0; i < 1000; i++) {
            largePattern[i] = i % 10; // Creates repeating pattern 0,1,2,...,9
        }
        assertTrue(solution.hasIncreasingSubsequence(largePattern));
    }

    @Test
    void testSpecialCases() {
        // Case where first element gets reset but triplet still exists
        int[] arr1 = {10, 1, 2, 3}; // Should find (1,2,3)
        assertTrue(solution.hasIncreasingSubsequence(arr1));
        
        // Case with multiple potential starts
        int[] arr2 = {10, 9, 2, 5, 3, 7, 101};
        assertTrue(solution.hasIncreasingSubsequence(arr2));
        
        // No triplet despite having some increasing pairs
        int[] arr3 = {1, 2, 0, 1};
        assertFalse(solution.hasIncreasingSubsequence(arr3));
    }



    @Test
    void testConsistencyBetweenMethods() {
        // Test that all methods give consistent results
        int[][] testCases = {
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1},
            {2, 1, 5, 0, 4, 6},
            {1, 2, 1, 2},
            {-1, 0, 1},
            {10, 9, 2, 5, 3, 7, 101},
            {},
            {1},
            {1, 2}
        };
        
        for (int[] arr : testCases) {
            boolean result1 = solution.hasIncreasingSubsequence(arr);
            boolean result2 = solution.findIncreasingSubsequence(arr);
            
            assertEquals(result1, result2, 
                "hasIncreasingSubsequence and findIncreasingSubsequence differ for: " + 
                java.util.Arrays.toString(arr));
        }
    }

    @Test
    void testPerformanceRequirement() {
        // Implicit test that solution should be O(n) time, O(1) space
        // This is more of a documentation test since we can't directly measure complexity
        
        // Large array test to ensure reasonable performance
        int[] largeArray = new int[50000];
        for (int i = 0; i < 50000; i++) {
            largeArray[i] = (i * 17) % 1000; // Some pattern
        }
        
        long startTime = System.nanoTime();
        boolean result = solution.hasIncreasingSubsequence(largeArray);
        long endTime = System.nanoTime();
        
        // Should complete in reasonable time (less than 10ms for 50k elements)
        long durationMs = (endTime - startTime) / 1_000_000;
        assertTrue(durationMs < 10, "Solution should run efficiently on large inputs");
        
        // The result doesn't matter for this test, just that it completes quickly
        // (result could be true or false depending on the pattern)
    }

    @Test
    void testBoundaryAndEdgeCombinations() {
        // Test combinations of edge cases
        

        // Array with all negative except one
        int[] arr2 = {-5, -3, -1, 0};
        assertTrue(solution.hasIncreasingSubsequence(arr2));
        
        // Large numbers close to overflow
        int[] arr3 = {Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
        assertTrue(solution.hasIncreasingSubsequence(arr3));
        
        // Mixed extreme values
        int[] arr4 = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
        assertTrue(solution.hasIncreasingSubsequence(arr4));
    }
}