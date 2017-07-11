package com.algos.practice.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cdeshpande on 7/10/17.
 * Problem:
 * Given an array of integers where 1 ? a[i] ? n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]

 */
public class FindDisappearedNums {

    /**
     * Mark nums as negative. Then in 2nd iteration, if a num is not marked
     * as negative we found the missing number, so add it to the result
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        System.out.println(Arrays.toString(nums));

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }

    public List<Integer> findDisappearedNumbersStartingFrom0(int [] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if(nums[val] >= 0) {
                nums[val] = -nums[val];
            }

        }

        System.out.println(Arrays.toString(nums));

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                result.add(i);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        FindDisappearedNums solve = new FindDisappearedNums();
        int [] nums = new int[]{3,3,1};
        List<Integer> result = solve.findDisappearedNumbers(nums);
        System.out.println(result);

        nums = new int[]{4,3,2,7,8,2,3,1};
        result = solve.findDisappearedNumbers(nums);
        System.out.println(result);


        nums = new int[]{2,1,2};
        result = solve.findDisappearedNumbersStartingFrom0(nums);
        System.out.println(result);

        nums = new int[]{4,3,2,7,0,2,3,1};
        result = solve.findDisappearedNumbersStartingFrom0(nums);
        System.out.println(result);
    }

}
