package com.algos.practice.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/22/17.
 */
public class CoinsChangeIITest {
    CoinsChangeII solve = new CoinsChangeII();

    @Test
    public void change() throws Exception {
        assertEquals(4, solve.change(5, new int[]{1,2,5}));
    }

}