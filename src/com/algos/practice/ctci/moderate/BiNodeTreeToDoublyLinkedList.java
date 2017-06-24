package com.algos.practice.ctci.moderate;

/**
 * Created by cdeshpande on 6/23/17.
 */
public class BiNodeTreeToDoublyLinkedList {

    public void convert(BiNode root) {
        doConvert(root, false); // isLeft = false or true doesnt matter for root node.
    }

    private BiNode doConvert(BiNode node, boolean isLeft) {
        if(node == null)
            return null;

        BiNode left = doConvert(node.node1, true);
        if(left != null) {
            node.node1 = left;
            left.node2 = node;
        }


        BiNode right = doConvert(node.node2, false);
        if(right != null) {
            node.node2 = right;
            right.node1 = node;
        }

        BiNode result = null;
        if(isLeft) {
            result = node.node2 == null ? node : node.node2;
        } else {
            result = node.node1 == null ? node : node.node1;
        }

        return result;
    }

    public static class BiNode {
        public BiNode node1, node2;
        public int data;

        public BiNode(int data) {
            this.data = data;
        }
        public String toString() {
            return String.format("(%s -- %s -- %s)", node1.data, data, node2.data);
        }
    }
}
