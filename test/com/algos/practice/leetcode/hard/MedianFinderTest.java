package com.algos.practice.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/11/17.
 */
public class MedianFinderTest {


    @Test
    public void addNumAndFindMedian() throws Exception {
        MedianFinder finder = new MedianFinder();
        finder.addNum(3);
        finder.addNum(2);
        finder.addNum(4);
        assertEquals(3,finder.findMedian(),0.0);

        finder = new MedianFinder();
        finder.addNum(3);
        finder.addNum(2);
        assertEquals(2.5,finder.findMedian(),0.0);
    }

    @Test
    public void findMedian() throws Exception {

    }

}