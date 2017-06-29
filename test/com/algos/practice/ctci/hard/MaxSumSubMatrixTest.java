package com.algos.practice.ctci.hard;

import com.algos.practice.Constants;
import com.algos.practice.leetcode.Util;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/25/17.
 */
public class MaxSumSubMatrixTest {
    MaxSumSubMatrix solve = new MaxSumSubMatrix();

    @BeforeClass
    public static void setUpClass() {
        System.setProperty(Constants.DEBUG, "false");
    }

    @Test
    public void calcMaxSumNaive() throws Exception {
        int[][] input = getSampleInput1();
        assertEquals(13, solve.calcMaxSumNaive(input));
        assertEquals(60, solve.calcMaxSumNaive(getSampleInput2()));
    }

    @Test
    public void calcSum() throws Exception {

        int[][] input = getSampleInput1();

        assertEquals(8,solve.calcSum(input, 1,2,0,2));
        assertEquals(10,solve.calcSum(input, 2,2,0,1));
        assertEquals(-8,solve.calcSum(input, 2,2,2,2));
        assertEquals(13,solve.calcSum(input, 0,2,0,2));
    }

    private int[][] getSampleInput1() {
        return new int[][]
                    {
                            {-1,2,4},
                            {3,-2,5},
                            {4,6,-8}
                    };
    }

    private int[][] getSampleInput2() {
        return new int[][]
                {
                        {-1,2,4,8,19},
                        {3,-2,5,-6,8},
                        {4,6,-8,4,3,-9},
                        {3,1,-9,7,2},
                        {6,-3,-8,3,9,5},
                };
    }

    @Test
    public void calcMaxSumUsingPreCompute() throws Exception {
        int[][] input = getSampleInput1();
        assertEquals(13, solve.calcMaxSumUsingPreCompute(input));
        assertEquals(60, solve.calcMaxSumUsingPreCompute(getSampleInput2()));
    }

    @Test
    public void precompute() {
        int [][] input = getSampleInput1();
        int [][] precomputed = solve.precompute(input);
        String ans = Util.toString(precomputed);
        System.out.println(ans);
    }

}