package com.algos.practice.interviewbit;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/19/17.
 */
public class SumOfPairWiseHammingDistanceTest {
    SumOfPairWiseHammingDistance solve = new SumOfPairWiseHammingDistance();

    @Test
    public void hammingDistance() throws Exception {
        assertEquals(8, solve.hammingDistance(Arrays.asList(2,4,6)));
        assertEquals(96, solve.hammingDistance(Arrays.asList(308, 95, 308, 248, 71)));
    }

    @Test
    public void calcSumOfPairwiseHammingDistanceUsingBits() throws Exception {
        assertEquals(8, solve.calcSumOfPairwiseHammingDistanceUsingBits(Arrays.asList(2,4,6)));
        assertEquals(96, solve.calcSumOfPairwiseHammingDistanceUsingBits(Arrays.asList(308, 95, 308, 248, 71)));
    }

    @Test
    public void getHammingDistance() throws Exception {
        assertEquals(0, solve.getHammingDistance(2,2));
        assertEquals(2, solve.getHammingDistance(2,4));
        assertEquals(1, solve.getHammingDistance(2,6));
    }

}