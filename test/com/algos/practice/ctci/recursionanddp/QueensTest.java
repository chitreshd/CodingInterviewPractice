package com.algos.practice.ctci.recursionanddp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 8/5/17.
 */
public class QueensTest {

    @Test
    public void valid() throws Exception {
        assertFalse(solve.valid(2,2,new int[]{0,-1,-1,-1}));
        assertFalse(solve.valid(2,2,new int[]{-1,-1,0,-1}));
        assertFalse(solve.valid(1,2,new int[]{-1,-1,-1,0}));

        assertTrue(solve.valid(2,2,new int[]{-1,-1,-1,-1}));
        assertTrue(solve.valid(1,2,new int[]{-1,-1,-1,-1}));
    }

    private Queens solve = new Queens();

    @Test
    public void totalNQueens() throws Exception {
        int actual = solve.totalNQueens(1);
        assertEquals(1,actual);

        actual = solve.totalNQueens(4);
        assertEquals(2,actual);
    }

}