package com.algos.practice.leetcode.medium;

import java.util.*;

/**
 * Created by cdeshpande on 8/29/17.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            int curr = nums[i];
            List<Integer> result = new ArrayList<>();
            result.add(curr);
            doThreeSum(i + 1, nums, result, results, sum - curr);
            result.remove((Integer) curr);
        }
        List<List<Integer>> filtered = filterDuplicates(results);
        return filtered;

    }

    private List<List<Integer>> filterDuplicates(List<List<Integer>> results) {
        Set<List<Integer>> filter = new HashSet<>();
        for(List<Integer> result : results) {
            Collections.sort(result);
            if(!filter.contains(result)) {
                filter.add(result);
            }
        }
        return new ArrayList<>(filter);
    }

    protected void doThreeSum(int currIndex,
                              int[] nums,
                              List<Integer> result,
                              List<List<Integer>> results,
                              int remainingSum) {

        if(result.size() == 3) {
            if(remainingSum == 0) {
                /*List<Integer> clone = new ArrayList<>(result.size());
                Collections.copy(clone, result);*/
                results.add(clone(result));
            }
        }

        for(int i = currIndex; i < nums.length; i++) {
            int curr = nums[i];
            result.add(curr);
            doThreeSum(i + 1, nums, result, results, remainingSum - curr);
            result.remove((Integer) curr);
        }
    }

    protected List<Integer> clone(List<Integer> integers) {
        ArrayList<Integer> clone = new ArrayList<>();
        for(int i : integers) {
            clone.add(i);
        }
        return clone;
    }
}
