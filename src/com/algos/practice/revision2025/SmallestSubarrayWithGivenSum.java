package com.algos.practice.revision2025;

/**
 * Problem: Smallest Subarray With a Given Sum
 * 
 * Given an array of positive integers and a positive number S, find the length of 
 * the smallest contiguous subarray whose sum is greater than or equal to S. 
 * If no such subarray exists, return 0.
 * 
 * Example:
 * Input: S = 7, arr = [2, 1, 5, 2, 3, 2]
 * Output: 2
 * Explanation: The smallest subarray with a sum ≥ 7 is [5, 2] or [2, 5].
 * 
 * Approach: Sliding Window Technique
 * Time Complexity: O(n) - each element is visited at most twice
 * Space Complexity: O(1) - only using a few variables
 */
public class SmallestSubarrayWithGivenSum {

    /**
     * Finds the length of the smallest contiguous subarray whose sum is >= targetSum
     * 
     * @param targetSum the target sum to achieve
     * @param arr array of positive integers
     * @return length of smallest subarray, or 0 if no such subarray exists
     */
    public int findSmallestSubarray(int targetSum, int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        // Sliding window technique
        // Use two pointers (left and right) to maintain a window
        // Expand window by moving right pointer until sum >= targetSum
        // Then try to shrink window by moving left pointer while maintaining sum >= targetSum
        
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int currentSum = 0;
        
        for (int right = 0; right < arr.length; right++) {
            // Expand window by adding current element
            currentSum += arr[right];
            
            // Contract window from left while sum >= targetSum
            while (currentSum >= targetSum) {
                minLen = Math.min(minLen, right - left + 1);
                currentSum -= arr[left];
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


    public static void main(String[] args) {
        SmallestSubarrayWithGivenSum solution = new SmallestSubarrayWithGivenSum();
        
        // Test case 1: Example from problem
        int[] arr1 = {2, 1, 5, 2, 3, 2};
        int target1 = 7;
        System.out.println("Test 1:");
        System.out.println("Array: [2, 1, 5, 2, 3, 2], Target: 7");
        System.out.println("Expected: 2, Got: " + solution.findSmallestSubarray(target1, arr1));
        System.out.println();
        
        // Test case 2: No valid subarray
        int[] arr2 = {1, 2, 3};
        int target2 = 10;
        System.out.println("Test 2:");
        System.out.println("Array: [1, 2, 3], Target: 10");
        System.out.println("Expected: 0, Got: " + solution.findSmallestSubarray(target2, arr2));
        System.out.println();
        
        // Test case 3: Single element satisfies condition
        int[] arr3 = {1, 2, 8, 3};
        int target3 = 8;
        System.out.println("Test 3:");
        System.out.println("Array: [1, 2, 8, 3], Target: 8");
        System.out.println("Expected: 1, Got: " + solution.findSmallestSubarray(target3, arr3));
        System.out.println();
        
        // Test case 4: Entire array needed
        int[] arr4 = {1, 2, 3, 4};
        int target4 = 10;
        System.out.println("Test 4:");
        System.out.println("Array: [1, 2, 3, 4], Target: 10");
        System.out.println("Expected: 4, Got: " + solution.findSmallestSubarray(target4, arr4));
    }
}