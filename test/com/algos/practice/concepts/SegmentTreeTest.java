package com.algos.practice.concepts;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/13/17.
 */
public class SegmentTreeTest {

    @Test
    public void construct() throws Exception {
        int[] input = new int[] {10,7,8,5,2,4,11};
        SegmentTree tree = new SegmentTree(input);
        int[] expected = new int[] {2,5,2,7,5,2,11,10,7,8,5,2,4,0,0};
        assertArrayEquals(expected, tree.getSegments());
        input = new int[] {2,1,5,6,2,3};
        tree = new SegmentTree(input);
        expected = new int[] {1, 1, 2, 1, 5, 2, 3, 2, 1, 0, 0, 6, 2, 0, 0};
        assertArrayEquals(expected, tree.getSegments());
    }

    @Test
    public void query() throws Exception {
        int[] input = new int[] {10,7,8,5,2,4,11};
        SegmentTree tree = new SegmentTree(input);
        assertEquals(2,tree.query(1,4));
        assertEquals(7,tree.query(0,1));
        assertEquals(5,tree.query(1,3));
    }

}