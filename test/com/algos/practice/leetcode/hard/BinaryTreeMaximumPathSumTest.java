package com.algos.practice.leetcode.hard;

import com.algos.practice.leetcode.Util;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/12/17.
 */
public class BinaryTreeMaximumPathSumTest {

    @Test
    public void maxPathSum() throws Exception {
        BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();

        BinaryTreeMaximumPathSum.TreeNode root1 = Util.createTree(2,1,3);
        assertEquals(6, solution.maxPathSum(root1));
        BinaryTreeMaximumPathSum.TreeNode root2 = Util.createTree(4,-6,10,5,-4,2,9);
        assertEquals(20, solution.maxPathSum(root2));
    }

}