package com.algos.practice.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class IncreasingTripletSubseqTest {
    IncreasingTripletSubseq solve = new IncreasingTripletSubseq();

    @Test
    public void increasingTriplet() throws Exception {
        assertTrue(solve.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        assertTrue(solve.increasingTriplet(new int[]{14, 4, 15, 8, 12, 9, 10}));
        assertFalse(solve.increasingTriplet(new int[]{5, 4, 3, 2, 1}));

    }

    @Test
    public void increasingNums() throws Exception {
        assertTrue(solve.increasingNums(new int[]{1, 2, 3, 4, 5}));
        assertTrue(solve.increasingNums(new int[]{14, 4, 15, 8, 12, 9, 10}));
        assertFalse(solve.increasingNums(new int[]{5, 4, 3, 2, 1}));
        assertFalse(solve.increasingNums(new int[]{1, 1, 1, 1, 1, 1}));


    }
}