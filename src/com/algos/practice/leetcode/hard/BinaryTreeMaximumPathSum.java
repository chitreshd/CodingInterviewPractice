package com.algos.practice.leetcode.hard;

/**
 * Created by cdeshpande on 6/12/17.
 * Problem:
 * Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the
 parent-child connections. The path must contain at least one node and does not need to go through the root.

 For example:
 Given the below binary tree,

    1
   / \
  2   3
 Return 6.

 Solution:
 Using recursion
 f(a):
    if(a == null) return null;
    maxVal = max(maxVal, f(a.left) + f(a.right) + a.val )
    return max(f(a.left), f(a.right) ) + a.val


 */
public class BinaryTreeMaximumPathSum {

    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        calcMaxSumEndingAtNode(root);
        return maxSum;
    }

    private int calcMaxSumEndingAtNode(TreeNode node) {
        if(node == null)
            return 0;

        // we want to use left or right side sum only if its going to contribute
        // to sum calculated at this stage
        // hence, if the sum is negative, we take 0.
        int left = Math.max(calcMaxSumEndingAtNode(node.left), 0);
        int right = Math.max(calcMaxSumEndingAtNode(node.right), 0);

        // when calculating the max sum at this node, both left and right can be
        // used, consider node 1 in above description.
        maxSum = Math.max(maxSum, left + right + node.val);

        // when returning max sum path, only left or right can be used, depending on
        // which is max.
        return Math.max(left, right) + node.val;
    }


    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) {
            this.val = x;
        }
    }
}
