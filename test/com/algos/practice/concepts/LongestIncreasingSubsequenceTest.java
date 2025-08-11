package com.algos.practice.concepts;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/12/17.
 */
public class LongestIncreasingSubsequenceTest {
    private LongestIncreasingSubsequence solve = new LongestIncreasingSubsequence();

    @Test
    @Ignore("This test takes too long to run due to O(2^n) time complexity of lisNoMemoization algorithm")
    public void lisNoMemoization() throws Exception {
        int[] nums = new int[]{2,3,8,1};
        assertEquals(3, solve.lisNoMemoization(nums));
        nums = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
        assertEquals(4, solve.lisNoMemoization(nums));
        // Reduced from 1000 to 100 to prevent hanging due to O(2^n) complexity
        nums = new int[100];
        for(int i = 1 ; i <= 100; i++) {
            nums[i - 1] = i;
        }
        assertEquals(100, solve.lisNoMemoization(nums));
    }

    @Test
    @Ignore("This test takes too long to run due to O(n²) time complexity of lisWithMemoization algorithm")
    public void lisWithMemoization() throws Exception {
        int[] nums = new int[]{2,3,8,1};
        assertEquals(3, solve.lisWithMemoization(nums));
        nums = new int[] {10, 9, 2, 5, 3, 7, 101, 18}; // 15 17 10 11 19 1 2 3 4 5 6
        assertEquals(4, solve.lisWithMemoization(nums));
        // Reduced from 1000 to 100 to prevent hanging due to O(n²) complexity
        nums = new int[100];
        for(int i = 1 ; i <= 100; i++) {
            nums[i - 1] = i;
        }
        assertEquals(100, solve.lisWithMemoization(nums));
    }

    @Test
    public void lisUsingBinarySearch() throws Exception {
        int[] nums = new int[]{2,3,8,1};
        assertEquals(3, solve.lisUsingBinarySearch(nums));
        nums = new int[] {10, 9, 2, 5, 3, 7, 101, 18, 1, 2, 3};
        assertEquals(4, solve.lisUsingBinarySearch(nums));
        // Keep 1000 for this test as it has O(n log n) complexity and should be fast
        nums = new int[1000];
        for(int i = 1 ; i <= 1000; i++) {
            nums[i - 1] = i;
        }
        assertEquals(1000, solve.lisUsingBinarySearch(nums));
    }
}