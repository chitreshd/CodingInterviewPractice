package com.algos.practice.leetcode.medium;

import static com.algos.practice.leetcode.hard.BinaryTreeMaximumPathSum.TreeNode;

import java.util.Stack;

/**
 * Created by cdeshpande on 9/5/17.
 */
public class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }

    private void pushLeft(TreeNode node) {
        TreeNode curr = node;
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        pushLeft(node.right);
        return node.val;
    }


}
