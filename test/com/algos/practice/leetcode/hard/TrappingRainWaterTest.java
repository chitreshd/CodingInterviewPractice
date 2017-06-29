package com.algos.practice.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/27/17.
 */
public class TrappingRainWaterTest {
    private TrappingRainWater solve = new TrappingRainWater();

    @Test
    public void trap() throws Exception {
        int [] heights = new int[]{2,0,2};
        assertEquals(2, solve.trap(heights));
        heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        assertEquals(6, solve.trap(heights));
        heights = new int[]{4,2,3};
        assertEquals(1, solve.trap(heights));
    }

}