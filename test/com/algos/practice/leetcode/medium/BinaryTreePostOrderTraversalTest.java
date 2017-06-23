package com.algos.practice.leetcode.medium;

import com.algos.practice.leetcode.medium.BinaryTreePostOrderTraversal;
import org.junit.Test;

import java.util.List;

import static com.algos.practice.leetcode.hard.BinaryTreeMaximumPathSum.*;

/**
 * Created by cdeshpande on 6/20/17.
 */
public class BinaryTreePostOrderTraversalTest {
    BinaryTreePostOrderTraversal solve = new BinaryTreePostOrderTraversal();
    @Test
    public void postorderTraversal() throws Exception {
        TreeNode root = sampleTree();
        List<Integer> result = solve.postorderTraversal(root);
        System.out.println(result);

        root = sampleTree1();
        result = solve.postorderTraversal(root);
        System.out.println(result);
    }

    private TreeNode sampleTree() {
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        TreeNode _4 = new TreeNode(4);
        TreeNode _5 = new TreeNode(5);
        _1.left = _2;
        _1.right = _3;
        _3.left = _4;
        _3.right = _5;
        return _1;
    }

    private TreeNode sampleTree1() {
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);

        _1.right = _2;
        _2.left = _3;
        return _1;
    }

}