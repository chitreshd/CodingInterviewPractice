package com.algos.practice.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/5/17.
 */
public class AtoITest {
    AtoI solution = new AtoI();

    @Test
    public void myAtoi() throws Exception {
        assertEquals(12, solution.myAtoi("12"));
        assertEquals(-12, solution.myAtoi("-12"));
        assertEquals(12, solution.myAtoi("    12"));
        assertEquals(12, solution.myAtoi("12    "));
        assertEquals(7, solution.myAtoi("  7&8  "));
        assertEquals(0, solution.myAtoi("  &&8  "));
        assertEquals(0, solution.myAtoi("  &7&8  "));
        assertEquals(2147483647, solution.myAtoi("2147483647"));
        assertEquals(2147483647, solution.myAtoi("2147483648"));
        assertEquals(-2147483648, solution.myAtoi("-2147483648"));
        assertEquals(0, solution.myAtoi("  +b12102370352"));
    }

}