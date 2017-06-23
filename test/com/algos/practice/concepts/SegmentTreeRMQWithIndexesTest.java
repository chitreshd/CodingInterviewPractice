package com.algos.practice.concepts;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by cdeshpande on 6/13/17.
 */
public class SegmentTreeRMQWithIndexesTest {

    @Test
    public void construct() throws Exception {
        int[] input = new int[] {10,7,8,5,2,4,11};
        SegmentTreeRMQWithIndexes tree = new SegmentTreeRMQWithIndexes(input);
        int[] expected = new int[] {4,3,4,1,3,4,6,0,1,2,3,4,5,0,0};
        assertArrayEquals(expected, tree.getSegments());
    }

    @Test
    public void query() throws Exception {
        int[] input = new int[] {10,7,8,5,2,4,11};
        SegmentTreeRMQWithIndexes tree = new SegmentTreeRMQWithIndexes(input);
        assertEquals(4,tree.query(1,4));
        assertEquals(1,tree.query(0,1));
        assertEquals(3,tree.query(1,3));
    }

}