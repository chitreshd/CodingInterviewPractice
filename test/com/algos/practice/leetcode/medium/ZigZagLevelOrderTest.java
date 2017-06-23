package com.algos.practice.leetcode.medium;

import org.junit.Test;

import java.util.List;

import static com.algos.practice.leetcode.hard.BinaryTreeMaximumPathSum.*;
import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/21/17.
 */
public class ZigZagLevelOrderTest {

    private ZigZagLevelOrder solve = new ZigZagLevelOrder();

    @Test
    public void zigzagLevelOrder() throws Exception {
        TreeNode root = sampleTree();
        List<List<Integer>> ans = solve.zigzagLevelOrder(root);
        System.out.println(ans);
    }

    private TreeNode sampleTree() {
        TreeNode _3 = new TreeNode(3);
        TreeNode _9 = new TreeNode(9);
        TreeNode _20 = new TreeNode(20);
        TreeNode _15 = new TreeNode(15);
        TreeNode _7 = new TreeNode(7);

        _3.left = _9;
        _3.right = _20;

        _20.left = _15;
        _20.right = _7;

        return _3;

    }

}