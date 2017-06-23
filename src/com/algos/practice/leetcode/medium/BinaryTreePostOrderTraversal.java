package com.algos.practice.leetcode.medium;

import java.util.*;

import static com.algos.practice.leetcode.hard.BinaryTreeMaximumPathSum.*;

/**
 * Created by cdeshpande on 6/20/17.
 */
public class BinaryTreePostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        HashSet<Integer> visited = new HashSet<>();

        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            while(temp != null) {
                TreeNode child = getAndMarkUnvisitedChild(temp);
                if(child != null) {
                    markAsVisited(child, visited);
                    stack.push(temp);
                } else {
                    result.add(temp.val);
                }
                temp = child;

            }
        }

        return result;
    }

    private TreeNode getAndMarkUnvisitedChild(TreeNode temp) {
        TreeNode left = temp.left;
        if(left != null) {
            temp.left = null;
            return left;
        }

        TreeNode right = temp.right;
        if(right != null) {
            temp.right = null;
            return right;
        }

        return null;
    }

    private void markAsVisited(TreeNode child, HashSet<Integer> visited) {
        visited.add(child.val);

    }

    private TreeNode getUnvisitedChild(TreeNode temp, HashSet<Integer> visited) {
        TreeNode left = temp.left;
        if(left != null && !visited.contains(left.val))
            return left;

        TreeNode right = temp.right;
        if(right != null && !visited.contains(right.val))
            return right;

        return null;
    }

    public static void main(String[] args) {
        int v = 2147483647;
        int max = Integer.MAX_VALUE;
        System.out.println("max: " + max);
        System.out.println("[2147483647] < Integer.MAX: " + (v < Long.MAX_VALUE));
        System.out.println("[2147483647] > Integer.MIN: " + (v > Long.MIN_VALUE));
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        Collections.reverse(list);
    }
}
