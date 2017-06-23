package com.algos.practice.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/14/17.
 */
public class LargestRectangularAreaInHistogramTest {

    @Test
    public void largestRectangleAreaUsingDivideAndConquer() throws Exception {
        LargestRectangularAreaInHistogram solve = new LargestRectangularAreaInHistogram();
        assertEquals(10, solve.largestRectangleAreaUsingDivideAndConquer(new int[]{2,1,5,6,2,3}));
        assertEquals(12, solve.largestRectangleAreaUsingDivideAndConquer(new int[]{6, 1, 5, 4, 5, 2, 6}));
    }

    @Test
    public void largestRectangleAreaUsingStack() throws Exception {
        LargestRectangularAreaInHistogram solve = new LargestRectangularAreaInHistogram();
        assertEquals(10, solve.getMaxArea(new int[]{2,1,5,6,2,3}));
        assertEquals(12, solve.getMaxArea(new int[]{6, 1, 5, 4, 5, 2, 6}));
    }

}