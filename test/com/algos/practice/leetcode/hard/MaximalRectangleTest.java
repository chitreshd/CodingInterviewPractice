package com.algos.practice.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 9/23/17.
 */
public class MaximalRectangleTest {
    MaximalRectangle solve = new MaximalRectangle();

    @Test
    public void maximalRectangle() throws Exception {

    }

    @Test
    public void usingHeightAndRLDiff_DP() throws Exception {
        char [][] matrix = new char[][]
                {
                    {'0','0','0','1','0','0','0'},
                    {'0','0','1','1','1','0','0'},
                    {'0','1','1','1','1','1','0'}
                };
        int maxArea = solve.usingHeightAndRLDiff_DP(matrix);
        System.out.println(maxArea);
    }

}