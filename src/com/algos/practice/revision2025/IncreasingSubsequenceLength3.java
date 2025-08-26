package com.algos.practice.revision2025;

/**
 * Problem: Increasing Subsequence of Length 3
 * 
 * Given an unsorted array, return whether an increasing subsequence of length 3 exists or not in the array.
 * 
 * Formally the function should:
 * Return true if there exists i, j, k such that arr[i] < arr[j] < arr[k] 
 * given 0 ≤ i < j < k ≤ n-1 else return false.
 * 
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * 
 * Examples:
 * Input: [1, 2, 3, 4, 5] → Output: true
 * Input: [5, 4, 3, 2, 1] → Output: false
 * Input: [2, 1, 5, 0, 4, 6] → Output: true
 * Input: [1, 2, 1, 2] → Output: false
 * 
 * Constraints:
 * - 1 ≤ array.length ≤ 5 * 10^5
 * - -2^31 ≤ array[i] ≤ 2^31 - 1
 */
public class IncreasingSubsequenceLength3 {

    /**
     * Main solution method - checks if increasing subsequence of length 3 exists
     * Should run in O(n) time and O(1) space
     * 
     * @param arr the input array
     * @return true if increasing subsequence of length 3 exists, false otherwise
     */
    public boolean hasIncreasingSubsequence(int[] arr) {
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        if ( arr == null ) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {

            if ( arr[i] <= small ) {
                small = arr[i];
            }

            if ( arr[i] <= mid && arr[i] > small ) {
                mid = arr[i];
            }

            if ( small < mid && mid < arr[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Alternative method signature for different parameter naming
     * 
     * @param nums the input array
     * @return true if increasing subsequence of length 3 exists, false otherwise
     */
    public boolean findIncreasingSubsequence(int[] nums) {
        // TODO: Implement - can delegate to hasIncreasingSubsequence
        return hasIncreasingSubsequence(nums);
    }


}