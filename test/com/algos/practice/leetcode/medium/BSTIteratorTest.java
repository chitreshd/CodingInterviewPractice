package com.algos.practice.leetcode.medium;

import static com.algos.practice.leetcode.hard.BinaryTreeMaximumPathSum.TreeNode;

import com.algos.practice.leetcode.Util;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 9/5/17.
 */
public class BSTIteratorTest {

    private BSTIterator solve;

    @Test
    public void hasNextAndNext() throws Exception {

        int [] expected = new int[]{5,10,12,15,16,17,20,25};
        TreeNode root = Util.createTree(expected);
        solve = new BSTIterator(root);
        int [] actual = new int[expected.length];
        int i = 0;
        while(solve.hasNext()) {
            actual[i++] = solve.next();
        }
        assertArrayEquals(expected, actual);
    }

}