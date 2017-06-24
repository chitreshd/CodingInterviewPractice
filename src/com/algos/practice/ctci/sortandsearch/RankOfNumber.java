package com.algos.practice.ctci.sortandsearch;

import static com.algos.practice.leetcode.hard.BinaryTreeMaximumPathSum.TreeNode;

/**
 * Created by cdeshpande on 6/23/17.
 */
public class RankOfNumber {
    private AugmentedTreeNode root;

    public int getRankOfNumber(int x) {
        return 0;
    }

    public void track(int x) {
        if(root == null)
            root = insert(root,x);
        else
            insert(root, x);
    }

    public String toString() {
        return AugmentedTreeNode.printInOrder(root);
    }
    private AugmentedTreeNode insert(AugmentedTreeNode node, int x) {
        // TODO
        /*
        Bug 1: Doesn't handle duplicates. If for example 5 is root and 4 was inserted twice, although the element
        node is added only once but the numOfValuesOnLeft for 5 is incremented twice.
        Now depending in situation, it can be handled in 2 ways:
        a. Add duplicate nodes
        b. Increment the counter for duplicate node as well. So in above example, the numOfValuesOnLeft for 4 for
        2nd addition will be 1 ( as a 4 was already added before it ).
         */
        if(node == null) {
            return new AugmentedTreeNode(x);
        }

        if(node.val == x){
            return node;
        }

        if(x < node.val) {
            // go left
            node.numOfValuesOnLeft++;
            node.left = insert((AugmentedTreeNode) node.left, x);
        }

        if(x > node.val) {
            // go right
            node.right = insert((AugmentedTreeNode) node.right, x);
        }
        return node;

    }

    public static class AugmentedTreeNode extends TreeNode {
        int numOfValuesOnLeft = 0;

        public AugmentedTreeNode(int x) {
            super(x);
        }

        public String toString() {
            return String.format("(%s, %s)", this.val, this.numOfValuesOnLeft);
        }
        public static String printInOrder(AugmentedTreeNode root) {
            StringBuffer buffer = new StringBuffer("[ ");
            print(root, buffer);
            buffer.append("] ");
            return buffer.toString();
        }

        private static void print(AugmentedTreeNode node, StringBuffer buffer) {
            if(node == null)
                return;

            print((AugmentedTreeNode) node.left, buffer);
            buffer.append(node.toString()).append(", ");
            print((AugmentedTreeNode) node.right, buffer);

        }
    }
}
