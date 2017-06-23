package com.algos.practice.leetcode.hard;

import com.algos.practice.leetcode.hard.MedianOf2SortedArrays;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/5/17.
 */
public class MedianOf2SortedArraysTest {
    private MedianOf2SortedArrays solution = new MedianOf2SortedArrays();


    @Test
    public void testForTwoNonEmptyArraysWithTotalSumAsOdd() {
        int [] nums1 = new int[] {1, 3};
        int [] nums2 = new int[] {2};
        assertEquals(2.0, solution.findMedianSortedArrays(nums1, nums2), 0.0);
        nums1 = new int[] {1, 2};
        nums2 = new int[] {3};
        assertEquals(2.0, solution.findMedianSortedArrays(nums2, nums1), 0.0);
    }

    @Test
    public void testForTwoNonEmptyArraysWithTotalSumAsEven() {
        int [] nums1 = new int[] {1, 3};
        int [] nums2 = new int[] {2, 4};
        assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2), 0.0);

        nums1 = new int[] {1, 2};
        nums2 = new int[] {3, 4};
        assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2), 0.0);
    }

    @Test
    public void testForOneNonEmptyArraysWithTotalSumAsEven() {
        int [] nums1 = new int[] {1, 3};
        int [] nums2 = new int[] {};
        assertEquals(2.0, solution.findMedianSortedArrays(nums1, nums2), 0.0);
    }

    @Test
    public void testForOneNonEmptyArraysWithTotalSumAsOdd() {
        int [] nums1 = new int[] {1, 3, 5};
        int [] nums2 = new int[] {};
        assertEquals(3.0, solution.findMedianSortedArrays(nums1, nums2), 0.0);
    }

    @Test
    public void testForEmptyArrays() {
        int [] nums1 = new int[] {};
        int [] nums2 = new int[] {};
        assertEquals(-1, solution.findMedianSortedArrays(nums1, nums2), 0.0);
    }

}