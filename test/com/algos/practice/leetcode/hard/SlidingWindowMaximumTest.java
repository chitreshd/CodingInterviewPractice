package com.algos.practice.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 7/6/17.
 */
public class SlidingWindowMaximumTest {
    private SlidingWindowMaximum solve = new SlidingWindowMaximum();

    @Test
    public void maxSlidingWindow() throws Exception {

    }

    @Test
    public void linearAlgoUsingDeque() throws Exception {
        int[] nums = new int[]{1,3,1,2,0,5};
        int k = 3;
        int [] actual = solve.linearAlgoUsingDeque(nums, k);
        int [] expected = new int[]{3,3,2,5};
        assertArrayEquals(actual, expected);


    }

    @Test
    public void inRange() {
        assertTrue(solve.inRange(0,2,3));
        assertTrue(solve.inRange(1,2,3));
        assertFalse(solve.inRange(1,4,3));
        assertTrue(solve.inRange(2,4,3));
    }

}