package com.algos.practice.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 9/23/17.
 */
public class MaximalRectangleTest {
    @Test
    public void usingLargestHistogramIdea() throws Exception {
        /*
        "1 0 1 0 0"
        "1 0 1 1 1"
        "1 1 1 1 1"
        "1 0 0 1 0"
         */
        char [][] matrix = new char[4][5];
        matrix[0] = "10100".toCharArray();
        matrix[1] = "10111".toCharArray();
        matrix[2] = "11111".toCharArray();
        matrix[3] = "10010".toCharArray();

        int largestArea = solve.usingLargestHistogramIdea(matrix);
        assertEquals(6, largestArea);
    }

    @Test
    public void maximalRectangleEndingAtARow() throws Exception {
        int largestArea = solve.maximalRectangleEndingAtARow(new int[]{3,1,3,2,2});
        assertEquals(6, largestArea);
    }

    @Test
    public void usingLargestRectangle() throws Exception {
        /*
        "1 0 1 0 0"
        "1 0 1 1 1"
        "1 1 1 1 1"
        "1 0 0 1 0"
         */
        char [][] matrix = new char[4][5];
        matrix[0] = "10100".toCharArray();
        matrix[1] = "10111".toCharArray();
        matrix[2] = "11111".toCharArray();
        matrix[3] = "10010".toCharArray();

        int largestArea = solve.usingLargestRectangle_2(matrix);
        assertEquals(6, largestArea);

    }

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