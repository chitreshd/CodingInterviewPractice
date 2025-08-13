package com.algos.practice.revision2025;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for SmallestSubarrayWithGivenSum
 */
public class SmallestSubarrayWithGivenSumTest {

    private SmallestSubarrayWithGivenSum solution;

    @BeforeEach
    void setUp() {
        solution = new SmallestSubarrayWithGivenSum();
    }

    @Test
    void testBasicExample() {
        // Test case from problem description
        int[] arr = {2, 1, 5, 2, 3, 2};
        int target = 7;
        int expected = 2; // [5, 2] or [2, 5]
        
        assertEquals(expected, solution.findSmallestSubarray(target, arr));
    }

    @Test
    void testNoValidSubarray() {
        // Sum of entire array is less than target
        int[] arr = {1, 2, 3};
        int target = 10;
        int expected = 0;
        
        assertEquals(expected, solution.findSmallestSubarray(target, arr));
    }

    @Test
    void testSingleElementSatisfies() {
        // Single element is greater than or equal to target
        int[] arr = {1, 2, 8, 3};
        int target = 8;
        int expected = 1; // [8]
        
        assertEquals(expected, solution.findSmallestSubarray(target, arr));
    }

    @Test
    void testEntireArrayNeeded() {
        // Need entire array to meet target
        int[] arr = {1, 2, 3, 4};
        int target = 10;
        int expected = 4; // [1, 2, 3, 4]
        
        assertEquals(expected, solution.findSmallestSubarray(target, arr));
    }

    @Test
    void testSingleElement() {
        // Array with single element
        int[] arr = {5};
        int target = 3;
        int expected = 1;
        
        assertEquals(expected, solution.findSmallestSubarray(target, arr));
        
        // Single element less than target
        target = 10;
        expected = 0;
        assertEquals(expected, solution.findSmallestSubarray(target, arr));
    }

    @Test
    void testEmptyArray() {
        // Empty array
        int[] arr = {};
        int target = 5;
        int expected = 0;
        
        assertEquals(expected, solution.findSmallestSubarray(target, arr));
    }

    @Test
    void testNullArray() {
        // Null array
        int[] arr = null;
        int target = 5;
        int expected = 0;
        
        assertEquals(expected, solution.findSmallestSubarray(target, arr));
    }

    @Test
    void testTargetEqualsSum() {
        // Target equals sum of subarray
        int[] arr = {1, 4, 4};
        int target = 4;
        int expected = 1; // [4]
        
        assertEquals(expected, solution.findSmallestSubarray(target, arr));
    }

    @Test
    void testAllElementsEqual() {
        // All elements are the same
        int[] arr = {3, 3, 3, 3};
        int target = 6;
        int expected = 2; // [3, 3]
        
        assertEquals(expected, solution.findSmallestSubarray(target, arr));
    }

    @Test
    void testLargeArray() {
        // Larger array test
        int[] arr = {2, 1, 2, 4, 3, 1};
        int target = 7;
        int expected = 2; // [4, 3]
        
        assertEquals(expected, solution.findSmallestSubarray(target, arr));
    }

    @Test
    void testFirstElementSatisfies() {
        // First element satisfies the condition
        int[] arr = {8, 1, 2, 3};
        int target = 7;
        int expected = 1; // [8]
        
        assertEquals(expected, solution.findSmallestSubarray(target, arr));
    }

    @Test
    void testLastElementSatisfies() {
        // Last element satisfies the condition
        int[] arr = {1, 2, 3, 8};
        int target = 7;
        int expected = 1; // [8]
        
        assertEquals(expected, solution.findSmallestSubarray(target, arr));
    }

    
}