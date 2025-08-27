package com.algos.practice.revision2025;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * Test class for ThreeSum
 * 
 * Comprehensive test coverage for the 3Sum target problem including:
 * - Basic examples with target 0
 * - Different target values
 * - Edge cases (empty, small arrays, boundary conditions)
 * - Various patterns (all positive, all negative, mixed, duplicates)
 * - Performance tests with larger inputs
 * - Corner cases with extreme values and specific patterns
 */
public class ThreeSumTest {

    private ThreeSum solution;

    @BeforeEach
    void setUp() {
        solution = new ThreeSum();
    }

    @Test
    void testThreeSumTargetZero() {
        // Test case: [-1,0,1,2,-1,-4] with target 0 → [[-1,-1,2],[-1,0,1]]
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSumTarget(nums, 0);
        
        // Verify all triplets sum to 0
        for (List<Integer> triplet : result) {
            assertEquals(0, triplet.stream().mapToInt(Integer::intValue).sum());
        }
        
        // Should find valid triplets
        assertFalse(result.isEmpty());
    }

    @Test
    void testThreeSumTargetPositive() {
        // Test case with positive target
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSumTarget(nums, 3);
        
        // Verify all triplets sum to 3
        for (List<Integer> triplet : result) {
            assertEquals(3, triplet.stream().mapToInt(Integer::intValue).sum());
        }
    }

    @Test
    void testThreeSumTargetNegative() {
        // Test case with negative target
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSumTarget(nums, -3);
        
        // Verify all triplets sum to -3
        for (List<Integer> triplet : result) {
            assertEquals(-3, triplet.stream().mapToInt(Integer::intValue).sum());
        }
    }

    @Test
    void testNoValidTripletsForTarget() {
        // Test case: [0,1,1] with target 0 → []
        int[] nums = {0, 1, 1};
        List<List<Integer>> result = solution.threeSumTarget(nums, 0);
        assertTrue(result.isEmpty());
    }

    @Test
    void testAllZerosWithTargetZero() {
        // Test case: [0,0,0] with target 0 → [[0,0,0]]
        int[] nums = {0, 0, 0};
        List<List<Integer>> result = solution.threeSumTarget(nums, 0);
        assertEquals(1, result.size());
        List<Integer> triplet = result.get(0);
        assertEquals(Arrays.asList(0, 0, 0), triplet);
    }

    @Test
    void testMinimumLength() {
        // Test case: minimum valid length (3 elements)
        int[] nums = {1, -1, 0};
        List<List<Integer>> result = solution.threeSumTarget(nums, 0);
        assertEquals(1, result.size());
        assertEquals(0, result.get(0).stream().mapToInt(Integer::intValue).sum());
    }

    @Test
    void testArrayTooShort() {
        // Arrays with length < 3 should return empty list
        assertTrue(solution.threeSumTarget(new int[]{}, 0).isEmpty());
        assertTrue(solution.threeSumTarget(new int[]{1}, 0).isEmpty());
        assertTrue(solution.threeSumTarget(new int[]{1, 2}, 0).isEmpty());
    }

    @Test
    void testNullInput() {
        // Null input should return empty list
        assertTrue(solution.threeSumTarget(null, 0).isEmpty());
    }

    @Test
    void testAllPositiveNumbers() {
        // All positive numbers with target 6
        int[] nums = {1, 2, 3, 4, 5};
        List<List<Integer>> result = solution.threeSumTarget(nums, 6);
        
        // Should find triplets that sum to 6
        for (List<Integer> triplet : result) {
            assertEquals(6, triplet.stream().mapToInt(Integer::intValue).sum());
        }
        assertFalse(result.isEmpty());
    }

    @Test
    void testAllNegativeNumbers() {
        // All negative numbers with target -6
        int[] nums = {-1, -2, -3, -4, -5};
        List<List<Integer>> result = solution.threeSumTarget(nums, -6);
        
        // Should find triplets that sum to -6
        for (List<Integer> triplet : result) {
            assertEquals(-6, triplet.stream().mapToInt(Integer::intValue).sum());
        }
        assertFalse(result.isEmpty());
    }

    @Test
    void testMixedNumbers() {
        // Mix of positive and negative numbers
        int[] nums = {-2, 0, 1, 1, 2};
        List<List<Integer>> result = solution.threeSumTarget(nums, 2);
        
        // Verify all triplets sum to 2
        for (List<Integer> triplet : result) {
            assertEquals(2, triplet.stream().mapToInt(Integer::intValue).sum());
        }
    }

    @Test
    void testWithDuplicates() {
        // Test cases with many duplicate elements
        int[] nums1 = {-1, 0, 1, 2, -1, -4, -1, 0, 1};
        List<List<Integer>> result1 = solution.threeSumTarget(nums1, 0);
        
        // Verify all triplets sum to 0
        for (List<Integer> triplet : result1) {
            assertEquals(0, triplet.stream().mapToInt(Integer::intValue).sum());
        }
        
        // Test with all same elements
        int[] nums2 = {3, 3, 3, 3, 3};
        List<List<Integer>> result2 = solution.threeSumTarget(nums2, 9);
        
        // Should find triplets that sum to 9
        for (List<Integer> triplet : result2) {
            assertEquals(9, triplet.stream().mapToInt(Integer::intValue).sum());
        }
    }

    @Test
    void testExtremeValues() {
        // Test with large numbers close to constraints
        int[] nums1 = {-100000, 50000, 50000};
        List<List<Integer>> result1 = solution.threeSumTarget(nums1, 0);
        assertEquals(1, result1.size());
        assertEquals(0, result1.get(0).stream().mapToInt(Integer::intValue).sum());
        
        // Test with different target
        List<List<Integer>> result2 = solution.threeSumTarget(nums1, 100000);
        for (List<Integer> triplet : result2) {
            assertEquals(100000, triplet.stream().mapToInt(Integer::intValue).sum());
        }
    }

    @Test
    void testDifferentTargets() {
        // Test same array with different targets
        int[] nums = {-3, -2, -1, 0, 1, 2, 3};
        
        // Target 0
        List<List<Integer>> result0 = solution.threeSumTarget(nums, 0);
        for (List<Integer> triplet : result0) {
            assertEquals(0, triplet.stream().mapToInt(Integer::intValue).sum());
        }
        
        // Target 3
        List<List<Integer>> result3 = solution.threeSumTarget(nums, 3);
        for (List<Integer> triplet : result3) {
            assertEquals(3, triplet.stream().mapToInt(Integer::intValue).sum());
        }
        
        // Target -3
        List<List<Integer>> resultNeg3 = solution.threeSumTarget(nums, -3);
        for (List<Integer> triplet : resultNeg3) {
            assertEquals(-3, triplet.stream().mapToInt(Integer::intValue).sum());
        }
        
        // Target 6
        List<List<Integer>> result6 = solution.threeSumTarget(nums, 6);
        for (List<Integer> triplet : result6) {
            assertEquals(6, triplet.stream().mapToInt(Integer::intValue).sum());
        }
    }

    @Test
    void testLargeTarget() {
        // Test with target that requires large numbers
        int[] nums = {10, 20, 30, 40, 50};
        List<List<Integer>> result = solution.threeSumTarget(nums, 90);
        
        // Should find triplets that sum to 90
        for (List<Integer> triplet : result) {
            assertEquals(90, triplet.stream().mapToInt(Integer::intValue).sum());
        }
        assertFalse(result.isEmpty());
    }

    @Test
    void testComplexPatterns() {
        // Complex array with various patterns
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        
        // Test multiple targets
        int[] targets = {0, 5, -5, 10, -8};
        
        for (int target : targets) {
            List<List<Integer>> result = solution.threeSumTarget(nums, target);
            
            // Verify all triplets sum to target
            for (List<Integer> triplet : result) {
                assertEquals(target, triplet.stream().mapToInt(Integer::intValue).sum());
                assertEquals(3, triplet.size());
            }
        }
    }

    @Test
    void testPerformanceRequirement() {
        // Test that solution runs efficiently on larger inputs
        List<Integer> numsList = new ArrayList<>();
        for (int i = -100; i <= 100; i++) {
            numsList.add(i);
            numsList.add(i); // Add duplicates
        }
        int[] largeArray = numsList.stream().mapToInt(Integer::intValue).toArray();
        
        long startTime = System.nanoTime();
        List<List<Integer>> result = solution.threeSumTarget(largeArray, 50);
        long endTime = System.nanoTime();
        
        // Should complete in reasonable time
        long durationMs = (endTime - startTime) / 1_000_000;
        assertTrue(durationMs < 1000, "Solution should run efficiently on larger inputs");
        
        // Verify results are correct
        for (List<Integer> triplet : result) {
            assertEquals(50, triplet.stream().mapToInt(Integer::intValue).sum());
            assertEquals(3, triplet.size());
        }
    }

    @Test
    void testSpecialCases() {
        // Case with zero target and zeros in array
        int[] nums1 = {0, -1, 1, 0, -2, 2};
        List<List<Integer>> result1 = solution.threeSumTarget(nums1, 0);
        
        // Verify all triplets sum to 0
        for (List<Integer> triplet : result1) {
            assertEquals(0, triplet.stream().mapToInt(Integer::intValue).sum());
        }
        
        // Case with same number appearing multiple times
        int[] nums2 = {1, 1, 1, 2, 2, 3};
        List<List<Integer>> result2 = solution.threeSumTarget(nums2, 6);
        
        // Should find triplets that sum to 6
        for (List<Integer> triplet : result2) {
            assertEquals(6, triplet.stream().mapToInt(Integer::intValue).sum());
        }
    }

    @Test
    void testEdgeCaseTargets() {
        int[] nums = {-10, -5, 0, 5, 10};
        
        // Very large positive target (impossible)
        List<List<Integer>> resultLarge = solution.threeSumTarget(nums, 1000);
        assertTrue(resultLarge.isEmpty());
        
        // Very large negative target (impossible)
        List<List<Integer>> resultSmall = solution.threeSumTarget(nums, -1000);
        assertTrue(resultSmall.isEmpty());
        
        // Achievable targets
        List<List<Integer>> result15 = solution.threeSumTarget(nums, 15);
        for (List<Integer> triplet : result15) {
            assertEquals(15, triplet.stream().mapToInt(Integer::intValue).sum());
        }
        
        List<List<Integer>> resultNeg15 = solution.threeSumTarget(nums, -15);
        for (List<Integer> triplet : resultNeg15) {
            assertEquals(-15, triplet.stream().mapToInt(Integer::intValue).sum());
        }
    }
}