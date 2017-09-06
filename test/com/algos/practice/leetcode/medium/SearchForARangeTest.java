package com.algos.practice.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 9/3/17.
 */
public class SearchForARangeTest {
    SearchForARange solve = new SearchForARange();

    @Test
    public void searchRange() throws Exception {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int [] range = solve.searchRange(nums, 8);
        assertArrayEquals(new int[]{3,4}, range);

    }

}