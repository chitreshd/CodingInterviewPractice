package com.algos.practice.leetcode.hard;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static com.algos.practice.leetcode.hard.BinaryTreeMaximumPathSum.*;

/**
 * Created by cdeshpande on 6/20/17.
 *
 * Learning: Although using json format for serializing and deserializing is a good way, writing it
 * in a time bound interview is really difficult. Also, parsing would require lot of testing and
 * there are higher chances of bug.
 * !Tried writing a parser: took around 50 mins but still couldnt get away with bugs.
 */
public class SerializeAndDeserializeTree {


    public String serialize(TreeNode node) {
        StringBuilder builder = new StringBuilder();
        doSerialize(node, builder);
        return builder.toString();
    }

    private void doSerialize(TreeNode node, StringBuilder builder) {
        if(node == null) {
            builder.append("X");
            builder.append(",");
            return;
        }

        builder.append(node.val);
        builder.append(",");
        doSerialize(node.left,builder);
        doSerialize(node.right,builder);
    }

    public TreeNode deserialize(String input) {
        String[] splits = input.split(",");
        Deque<String> nodes = new ArrayDeque<>(Arrays.asList(splits));
        return doDeserialize(nodes);

    }

    private TreeNode doDeserialize(Deque<String> nodes) {
        String nodeStr = nodes.remove();
        if(nodeStr.equals("X")) {
            return null;
        }

        int nodeVal = Integer.valueOf(nodeStr);
        TreeNode node = new TreeNode(nodeVal);
        node.left = doDeserialize(nodes);
        node.right = doDeserialize(nodes);
        return node;
    }

    public String serializeUsingJson(TreeNode node) {
        if(node == null) {
            return null;
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        buffer.append(String.format("%s:%s","val",node.val));
        String left = serializeUsingJson(node.left);
        if(left != null) {
            buffer.append(",");
            buffer.append(String.format("%s:%s","left",left));
        }

        String right = serializeUsingJson(node.right);
        if(right != null) {
            buffer.append(",");
            buffer.append(String.format("%s:%s","right",right));
        }
        buffer.append("}");
        return buffer.toString();
    }

    public TreeNode deserializeUsingJson(String jsonStr) {
        return doDeserializeJsonStr(jsonStr).node;
    }

    private ResultPair doDeserializeJsonStr(String jsonStr) {
        if(jsonStr == null || jsonStr.isEmpty())
            return null;

        if(!jsonStr.startsWith("{")) {
            throw new IllegalArgumentException("String for node should start with {");
        }

        int valIndex = jsonStr.indexOf("val:") + "val:".length();
        int valIndexComma = jsonStr.indexOf(",",valIndex);
        String valStr = jsonStr.substring(valIndex + 1, valIndexComma);
        int val = Integer.parseInt(valStr);
        TreeNode node = new TreeNode(val);
        int lftStrStrt = jsonStr.indexOf("left:") + "left:".length();
        int lastIndex = -1;

        if(lftStrStrt != -1) {
            String leftSubStr = jsonStr.substring(lftStrStrt + 1);
            ResultPair leftResult = doDeserializeJsonStr(leftSubStr);
            node.left = leftResult.node;
            lastIndex = Math.max(lastIndex, leftResult.lastIndex);
        }
        int rightStrStrt = jsonStr.indexOf("right:") + "right:".length();
        if(rightStrStrt != -1) {
            String rightSubStr = jsonStr.substring(rightStrStrt + 1);
            ResultPair rightResult = doDeserializeJsonStr(rightSubStr);
            node.right = rightResult.node;
            lastIndex = Math.max(lastIndex, rightResult.lastIndex);
        }
        if(lastIndex == -1) {
            // no left or right nodes
            lastIndex = jsonStr.length() - 1;
        } else {
            lastIndex += 1;
        }
        if(lastIndex >= jsonStr.length()) {
            throw new IllegalArgumentException("String for node should end with }, lastIndex: " + lastIndex);
        }
        if(jsonStr.charAt(lastIndex) != '}') {
            throw new IllegalArgumentException("String for node should end with }, found: " + jsonStr.charAt(lastIndex));
        }

        ResultPair result = new ResultPair();
        result.node = node;
        result.lastIndex = lastIndex;
        return result;
    }

    private static class ResultPair {
        TreeNode node;
        int lastIndex;
    }
}
