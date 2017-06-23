package com.algos.practice.leetcode.hard;

/**
 * Created by cdeshpande on 6/10/17.
 */
public class FirstMissingPositive {


    public int firstMissingPositive(int [] nums) {
        // put the integers in its corresponding indexes.
        // then traverse the modified array to check which index is missing the number
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] > 0 && nums[i] <= nums.length && !isIntegerAtItsIndex(nums, i)) {
                // nums not at its correct location.
                int currIndex = i;
                int correctLoc = nums[i] - 1;
                swap(nums, currIndex, correctLoc);
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return (i + 1);
            }
        }

        return nums.length + 1;
    }

    private boolean isIntegerAtItsIndex(int [] nums, int currIndex) {
        int numAtCurrIndex = nums[currIndex];
        int correctIndexLoc = numAtCurrIndex - 1; // -1 because index starts from 0 : (0,1,2) = [1,2,3]

        return nums[correctIndexLoc] == numAtCurrIndex; // true: the number is at correct location. i.e. 1 at 0, 2 at 1
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive solve = new FirstMissingPositive();
        int ans = solve.firstMissingPositive(new int[]{30,40,-10,100});
        //[3,4,-1,1]
        System.out.println("Ans: " + ans);
        ans = solve.firstMissingPositive(new int[]{3,4,-1,1});
        //[3,4,-1,1]
        System.out.println("Ans: " + ans);

    }
}
