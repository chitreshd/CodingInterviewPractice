package com.algos.practice.concepts;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by cdeshpande on 6/13/17.
 */
public class SegmentTreeSumOfGivenRangeTest {

    @Test
    public void construct() throws Exception {
        int[] input = new int[] {10,7,8,5,2,4,11};
        SegmentTreeSumOfGivenRange tree = new SegmentTreeSumOfGivenRange(input);
        int[] expected = new int[] {47,30,17,17,13,6,11,10,7,8,5,2,4,0,0};
        assertArrayEquals(expected, tree.getSegments());
    }

    @Test
    public void query() throws Exception {
        int[] input = new int[] {10,7,8,5,2,4,11};
        SegmentTreeSumOfGivenRange tree = new SegmentTreeSumOfGivenRange(input);
        assertEquals(22,tree.query(1,4));
        assertEquals(17,tree.query(0,1));
        assertEquals(20,tree.query(1,3));
    }

}