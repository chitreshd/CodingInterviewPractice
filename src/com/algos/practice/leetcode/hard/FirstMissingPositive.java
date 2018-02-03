package com.algos.practice.leetcode.hard;

/**
 * Created by cdeshpande on 6/10/17.
 */
public class FirstMissingPositive {


    protected int firstMissingPostiveRevision(int [] nums) {
        if(nums == null || nums.length == 0)
            return 1;

        for(int currIndex = 0; currIndex < nums.length; currIndex++) {

            while(nums[currIndex] > 0 && nums[currIndex] <= nums.length && !isIntegerAtCorrectIndex(nums, currIndex)) {
                int correctLocForCurrValue = nums[currIndex] - 1;
                swap(nums, correctLocForCurrValue, currIndex);
            }

        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public int firstMissingPositive(int [] nums) {
        // put the integers in its corresponding indexes.
        // then traverse the modified array to check which index is missing the number

        for(int i = 0; i < nums.length; i++) {
            // we are trying to find the right number for this index and hence we swap curr value at i
            // with the value from the correct index for current value.
            while(nums[i] > 0 && nums[i] <= nums.length && !isIntegerAtItsIndex(nums, i)) {
                // nums not at its correct location.
                //int currIndex = i;
                int correctLoc = nums[i] - 1;
                swap(nums, i, correctLoc);
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
        ans = solve.firstMissingPostiveRevision(new int[]{3,4,-1,1});
        //[3,4,-1,1]
        System.out.println("Ans: " + ans);

    }



    private boolean isIntegerAtCorrectIndex(int [] nums, int indexToBeChecked) {
        int intToBeChecked = nums[indexToBeChecked];
        int desiredLoc = intToBeChecked - 1;
        return nums[desiredLoc] == intToBeChecked;
    }




}
