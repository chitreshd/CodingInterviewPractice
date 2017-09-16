package com.algos.practice.leetcode.medium;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 9/12/17.
 */
public class WiggleSortIITest {

    public WiggleSortII solve = new WiggleSortII();

    @Test
    public void wiggleSort() throws Exception {
        int [] nums = new int[] {5,3,11,2,8,7,1};
        solve.wiggleSort(nums);
        boolean isWiggled = isWiggled(nums);
        System.out.println(String.format("wiggle sorted: %s, isWiggled: %s", Arrays.toString(nums), isWiggled));
        assertTrue(isWiggled);

        nums = new int[] {3,2,1,3,4,5};
        solve.wiggleSort(nums);
        isWiggled = isWiggled(nums);
        System.out.println(String.format("wiggle sorted: %s, isWiggled: %s", Arrays.toString(nums), isWiggled));
        assertTrue(isWiggled);

    }

    private boolean isWiggled(int [] nums) {

        for(int i = 1; i < nums.length; i+= 2 ) {
            if(nums[i] <= nums[i - 1]
                    || ( (i < nums.length - 1) && nums[i] <= nums[i + 1] )) {
                return false;
            }
        }

        return true;
    }
    @Test
    public void merge() {
        int [] nums = new int[] {3,2,1,3,4,5};
    }
    @Test
    public void testRank() {

        int [] nums = new int[] {5,1,4,3,2,3};
        int median =  WiggleSortII.rank(nums, nums.length / 2); //solve.findKthSmallest(nums, nums.length / 2);
        System.out.println(String.format("nums: %s, median: %s", Arrays.toString(nums), median));
        assertEquals(3, median);


    }
    @Test
    public void findKthSmallest() throws Exception {
        int [] nums;
        for(int i = 0; i < 4; i++) {
            // since a randomization is algo is used, we test it multiple times
            nums = new int[] {5,3,11,2,8,7,1};
            int thirdSmallest = solve.findKthSmallest(nums, 3);
            assertEquals(3, thirdSmallest);
        }

        for(int i = 0; i < 4; i++) {
            // since a randomization is algo is used, we test it multiple times
            nums = new int[] {5,3,11,2,8,7,1};
            int median = solve.findKthSmallest(nums, nums.length / 2);
            assertEquals(3, median);
        }


    }

    @Test
    public void partition() throws Exception {

        int [] nums = new int[] {5,3,11,2,8,7,1};
        int left = solve.partition(nums, 0, nums.length - 1, 5);
        int [] expected = new int[]{5, 3, 1, 2, 8, 7, 11};
        int expectedLeft = 4;
        assertArrayEquals(expected, nums);
        assertEquals(expectedLeft, left);

    }

}