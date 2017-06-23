package com.algos.practice.concepts;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by cdeshpande on 5/16/17.
 */
public class BinaryIndexTreeTests {

    @Test
    public void test() {
        BinaryIndexedTree tree = new BinaryIndexedTree(11);
        //cumulative Freq = [0,0,0,0,0,0,0,0,0,0,0]
        tree.update(5,9);
        //cumulative Freq = [0,0,0,0,0,9,9,9,9,9,9]
        for(int i : Arrays.asList(5,6,7,8,9,10)) {
            assertEquals(9, tree.lookup(i));
        }
        for(int i : Arrays.asList(0,1,2,3,4)) {
            assertEquals(0, tree.lookup(i));
        }
        tree.update(1,10);
        //cumulative Freq = [0,10,10,10,10,19,19,19,19,19,19]
        for(int i : Arrays.asList(5,6,7,8,9,10)) {
            assertEquals(19, tree.lookup(i));
        }
        for(int i : Arrays.asList(1,2,3,4)) {
            assertEquals(10, tree.lookup(i));
        }
        assertEquals(0,tree.lookup(0));
    }
}
