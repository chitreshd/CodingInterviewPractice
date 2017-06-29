package com.algos.practice.ctci.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/25/17.
 */
public class Count2sTest {

    private Count2s solve = new Count2s();

    @Test
    public void count2() throws Exception {
        assertEquals(1,solve.count2(2));
        assertEquals(15,solve.count2(42));
    }

    @Test
    public void testUsingCtCiSolution() {
        for(int i = 0; i < 1000; i++) {
            assertEquals("Test failed for n = " + i,Count2s.count2sInRange(i),solve.count2(i));
        }
    }

    @Test
    public void debug() throws Exception {
        assertEquals(15,solve.count2(42));
        assertEquals(3,solve.count2(20));
    }

}