package com.algos.practice.leetcode;

import static com.algos.practice.leetcode.hard.BinaryTreeMaximumPathSum.*;

/**
 * Created by cdeshpande on 6/20/17.
 */
public class Util {


    public static TreeNode createTree(int ... arr) {
        return createTree(arr, 0, arr.length - 1);
    }


    private static TreeNode createTree(int [] arr, int start, int end) {
        if(start > end)
            return null;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = createTree(arr, start, mid - 1);
        node.right = createTree(arr, mid + 1, end);
        return node;
    }
}
