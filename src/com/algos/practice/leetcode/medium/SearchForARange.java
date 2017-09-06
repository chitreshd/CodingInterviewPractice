package com.algos.practice.leetcode.medium;

import java.util.Arrays;

/**
 * Created by cdeshpande on 9/3/17.
 */
public class SearchForARange {

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[] {-1,-1};

        int foundIndex = Arrays.binarySearch(nums, target);
        if(foundIndex < 0) {
            return new int[] {-1,-1};
        }

        int left = foundIndex;
        while(left - 1 >= 0 && (nums[left - 1] == target) ) {
            left--;
        }

        int right = foundIndex;
        while(right + 1 < nums.length && (nums[right + 1] == target) ) {
            right++;
        }

        return new int[] {left, right};

    }
}
