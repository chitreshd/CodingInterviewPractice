package com.algos.practice.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 8/6/17.
 */
public class KthLargestTest {

    private KthLargest solve = new KthLargest();

    @Test
    public void findKthLargest() throws Exception {
        assertEquals(5, solve.findKthLargest(new int[] {3,2,1,5,6,4}, 2));
        assertEquals(2, solve.findKthLargest(new int[] {3,2}, 3));
        assertEquals(2, solve.findKthLargest(new int[] {3,2}, 2));
        assertEquals(0, solve.findKthLargest(new int[] {}, 2));
    }

}