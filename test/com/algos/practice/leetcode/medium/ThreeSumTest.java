package com.algos.practice.leetcode.medium;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 8/29/17.
 */
public class ThreeSumTest {
    private ThreeSum solve = new ThreeSum();

    @Test
    public void threeSum() throws Exception {
        List<List<Integer>> results = solve.threeSum(new int[] {-3,0,2,1,0}, 3);
        System.out.println(results);
        results = solve.threeSum(new int[] {-1, 0, 1, 2, -1, -4}, 0);
        System.out.println(results);
    }

}