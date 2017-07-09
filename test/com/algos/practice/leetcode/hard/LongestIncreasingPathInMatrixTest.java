package com.algos.practice.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 7/6/17.
 */
public class LongestIncreasingPathInMatrixTest {

    LongestIncreasingPathInMatrix solve = new LongestIncreasingPathInMatrix();

    @Test
    public void findLIP() throws Exception {
        int[][] matrix = new int [][] {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        assertEquals(4, solve.findLIP(matrix));

        matrix = new int [][] {
                {3,4,5},
                {3,2,6},
                {2,2,1}
        };
        assertEquals(4, solve.findLIP(matrix));
    }

    @Test
    public void findLIPUsingCache() throws Exception {
        int[][] matrix = new int [][] {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        assertEquals(4, solve.findLIPUsingCache(matrix));

        matrix = new int [][] {
                {3,4,5},
                {3,2,6},
                {2,2,1}
        };
        assertEquals(4, solve.findLIPUsingCache(matrix));
    }

}