package com.algos.practice.revision2025;

import java.util.*;

/**
 * Problem: 3Sum
 * 
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation: 
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * 
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * 
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * 
 * Constraints:
 * - 3 <= nums.length <= 3000
 * - -10^5 <= nums[i] <= 10^5
 * 
 * Approach: Two Pointer Technique
 * 1. Sort the array
 * 2. For each element, use two pointers to find pairs that sum to negative of current element
 * 3. Skip duplicates to avoid duplicate triplets
 * Time Complexity: O(n^2) - nested loops with two pointers
 * Space Complexity: O(1) - excluding space for output
 */
public class ThreeSum {

    /**
     * Finds triplets that sum to a specific target (generalized version)
     * 
     * @param nums array of integers
     * @param target target sum
     * @return list of triplets that sum to target
     */
    public List<List<Integer>> threeSumTarget(int[] nums, int target) {
        List<List<Integer>> triplets = new ArrayList<>();
        if (nums == null ) {
            return triplets;
        }
        
        Arrays.sort(nums);

        for (int outer = 0; outer < nums.length - 1 ; outer++) {
            if (outer > 0 && nums[outer] == nums[outer - 1]) {
                // current outer number is same as previous one, this will generate duplicate
                continue;
            }

            for (int left = outer + 1, right = nums.length - 1; left < right ; ) {
                int tempSum = nums[outer] + nums[left] + nums[right];
                if ( tempSum == target ) {
                    triplets.add(Arrays.asList(nums[outer], nums[left], nums[right]));
                    while (left < right && (nums[left] == nums[left + 1]) ) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                }
                if ( tempSum < target ) {
                    left++;
                } else {
                    // tempSum > target
                    right--;
                }
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        
        // Test case 1: Basic example with multiple triplets
        System.out.println("Test 1: Basic example");
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: " + Arrays.toString(nums1));
        try {
            System.out.println("Output: " + solution.threeSumTarget(nums1, 0));
        } catch (UnsupportedOperationException e) {
            System.out.println("Output: Not implemented yet");
        }
        System.out.println("Expected: [[-1,-1,2],[-1,0,1]]");
        System.out.println();
        
        // Test case 2: No valid triplets
        System.out.println("Test 2: No valid triplets");
        int[] nums2 = {0, 1, 1};
        System.out.println("Input: " + Arrays.toString(nums2));
        try {
            System.out.println("Output: " + solution.threeSumTarget(nums2, 0));
        } catch (UnsupportedOperationException e) {
            System.out.println("Output: Not implemented yet");
        }
        System.out.println("Expected: []");
        System.out.println();
        
        // Test case 3: All zeros
        System.out.println("Test 3: All zeros");
        int[] nums3 = {0, 0, 0};
        System.out.println("Input: " + Arrays.toString(nums3));
        try {
            System.out.println("Output: " + solution.threeSumTarget(nums3, 0));
        } catch (UnsupportedOperationException e) {
            System.out.println("Output: Not implemented yet");
        }
        System.out.println("Expected: [[0,0,0]]");
        System.out.println();
        

    }
}