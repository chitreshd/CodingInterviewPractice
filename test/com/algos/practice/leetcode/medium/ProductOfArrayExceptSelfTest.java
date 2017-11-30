package com.algos.practice.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductOfArrayExceptSelfTest {
    ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

    @Test
    public void solve() throws Exception {
        int [] f = new int[] {1,2,3,4};
        assertArrayEquals(new int[]{24,12,8,6}, solution.solve(f));
        f = new int[] {2,3};
        assertArrayEquals(new int[]{3,2}, solution.solve(f));
        f = new int[] {2};
        assertArrayEquals(new int[]{1}, solution.solve(f));

    }

}