package com.algos.practice.concepts;

import java.util.Arrays;

/**
 * Created by cdeshpande on 6/12/17.
 * Problem:
 Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 Note that there may be more than one LIS combination,
 it is only necessary for you to return the length.
 Solution:
 For a given array [0..i], the LIS at i can be expressed as:
 L(i) = 1 + max(L(j)) where j = 0:(i-1) and A[j] < A[i]

 Optimization 1: Memoization

 */
public class LongestIncreasingSubsequence {



    public int lengthOfLIS(int[] nums) {
        return lisWithMemoization(nums);
    }

    protected int lisWithMemoization(int [] nums) {
        int maxAlongArr = Integer.MIN_VALUE;
        int [] results = new int[nums.length];

        for(int i = 0 ; i < nums.length; i++) {
            int max = lisWithMemoization(nums, i, results);
            maxAlongArr = Math.max(max, maxAlongArr);
        }

        return maxAlongArr;
    }

    private int lisWithMemoization(int [] nums, int i, int [] results) {
        if(i < 0)
            return 0;

        if(results[i] == 0) {
            int max = 0;

            for(int j = i - 1; j >= 0; j--) {
                if(nums[j] < nums[i]) {
                    int curr = lisWithMemoization(nums, j, results);
                    max = Math.max(curr, max);
                }

            }

            results[i] = max + 1;
        }
        return results[i];
    }

    protected int lisNoMemoization(int [] nums) {
        int maxAlongArr = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length; i++) {
            int max = lisNoMemoization(nums, i);
            maxAlongArr = Math.max(max, maxAlongArr);
        }
        return maxAlongArr;
    }

    private int lisNoMemoization(int [] nums, int i) {
        if(i < 0)
            return 0;

        int max = 0;

        for(int j = i - 1; j >= 0; j--) {
            if(nums[j] < nums[i]) {
                int curr = lisNoMemoization(nums, j);
                max = Math.max(curr, max);
            }

        }

        return max + 1;
    }

    /**
     * Algo: https://leetcode.com/articles/longest-increasing-subsequence/#approach-4-dynamic-programming-with-binary-searchaccepted
     * Gotchas:
     * a. Although the len will give current max subsequence length, the array doesn't necessarily correspond to
     * current max subsequence.
     * b. Why algo works?
     * i. Consider a semi-elastic band that once stretched remains stretched. Similarly, the dp used to store the
     * max subsequence will be stretched to max subsequence length when iterating through array. In other words,
     * we are only increasing the len and never decreasing it, so increased len indicates that somewhere during
     * iteration, we encountered the subsequence big enough to justify this length.
     * ii. Another key observation:
     * Consider this array: 15 17 10 11 19 1 2 3 4 5 6
     * After encountering 10, the algo replaces 15 with 10 and doesnt add 10 to the start. Why is this important?
     * Well because it maintains the "core idea" of only stretching the dp array when a longer subsequence is encountered.
     *
     * dp = [15,17] [10,17]
     *
     * Thus, when 11 is found, 17 will be replaced still maintaining the len. But when 19 is found, the len is increased
     * to 3 : dp = [10,11,19] and notice the till now, 3 is the longest subsequence.
     *
     * @param nums
     * @return
     */
    protected int lisUsingBinarySearch(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

}
