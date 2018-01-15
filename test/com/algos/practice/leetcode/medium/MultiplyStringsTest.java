package com.algos.practice.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplyStringsTest {
    MultiplyStrings solve = new MultiplyStrings();
    @Test
    public void multiply() throws Exception {
        String actual = solve.multiply("321", "425");
        String expected = "136425";
        assertEquals(expected, actual);

        actual = solve.multiply("123", "45");
        expected = "5535";
        assertEquals(expected, actual);

        actual = solve.multiply("0", "0");
        expected = "0";
        assertEquals(expected, actual);
    }

}