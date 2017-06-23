package com.algos.practice.concepts;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/12/17.
 */
public class LongestIncreasingSubsequenceTest {
    private LongestIncreasingSubsequence solve = new LongestIncreasingSubsequence();

    @Test
    public void lisNoMemoization() throws Exception {
        int[] nums = new int[]{2,3,8,1};
        assertEquals(3, solve.lisNoMemoization(nums));
        nums = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
        assertEquals(4, solve.lisNoMemoization(nums));
        nums = new int[1000];
        for(int i = 1 ; i <= 1000; i++) {
            nums[i - 1] = i;
        }
        assertEquals(1000, solve.lisNoMemoization(nums));
    }

    @Test
    public void lisWithMemoization() throws Exception {
        int[] nums = new int[]{2,3,8,1};
        assertEquals(3, solve.lisWithMemoization(nums));
        nums = new int[] {10, 9, 2, 5, 3, 7, 101, 18}; // 15 17 10 11 19 1 2 3 4 5 6
        assertEquals(4, solve.lisWithMemoization(nums));
        nums = new int[1000];
        for(int i = 1 ; i <= 1000; i++) {
            nums[i - 1] = i;
        }
        assertEquals(1000, solve.lisWithMemoization(nums));
    }

    @Test
    public void lisUsingBinarySearch() throws Exception {
        int[] nums = new int[]{2,3,8,1};
        assertEquals(3, solve.lisUsingBinarySearch(nums));
        nums = new int[] {10, 9, 2, 5, 3, 7, 101, 18, 1, 2, 3};
        assertEquals(4, solve.lisUsingBinarySearch(nums));
        nums = new int[1000];
        for(int i = 1 ; i <= 1000; i++) {
            nums[i - 1] = i;
        }
        assertEquals(1000, solve.lisUsingBinarySearch(nums));
    }

}