package com.algos.practice.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 9/14/17.
 */
public class BurstBallonsTest {

    private BurstBallons solve = new BurstBallons();


    @Test
    public void maxCoins() throws Exception {
        int[] nums = new int[]{3, 1, 5, 8};
        assertEquals(167, solve.maxCoins(nums));

        nums = new int[]{9};
        assertEquals(9, solve.maxCoins(nums));
    }

    @Test
    public void testMaxCoinsDP() {
        int[] nums = new int[]{3, 1, 5, 8};
        assertEquals(167, solve.maxCoinsDP(nums));

        nums = new int[]{9};
        assertEquals(9, solve.maxCoinsDP(nums));
    }
    @Test
    public void getLeft() throws Exception {

        int[] nums = new int[]{3, -4, -1, 5, 8};
        assertEquals(0,solve.getLeft(nums, 3));

    }

    @Test
    public void getRight() throws Exception {

        int[] nums = new int[]{3, 4, -1, -5, 8};
        assertEquals(4,solve.getRight(nums, 1));

    }





}