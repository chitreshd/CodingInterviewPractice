package com.algos.practice.leetcode.hard;

import com.algos.practice.leetcode.Util;
import org.junit.Test;

import static com.algos.practice.leetcode.hard.BinaryTreeMaximumPathSum.*;
import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/20/17.
 */
public class SerializeAndDeserializeTreeTest {
    SerializeAndDeserializeTree solve = new SerializeAndDeserializeTree();

    @Test
    public void serialize() {
        TreeNode root1 = Util.createTree(2,1,3);
        System.out.println(solve.serialize(root1));
    }

    @Test
    public void deserialize() {
        TreeNode root1 = Util.createTree(2,1,3);
        String root1Str = solve.serialize(root1);
        TreeNode rootD = solve.deserialize(root1Str);
        root1 = sampleTree();
        root1Str = solve.serialize(root1);
        rootD = solve.deserialize(root1Str);
        System.out.println();
    }
    @Test
    public void serializeUsingJson() throws Exception {
        TreeNode root1 = Util.createTree(2,1,3);
        System.out.println(solve.serializeUsingJson(root1));

        root1 = Util.createTree(4,-6,10,5,-4,2,9);
        System.out.println(solve.serializeUsingJson(root1));

        root1 = sampleTree();
        System.out.println(solve.serializeUsingJson(root1));
    }

    //@Test
    public void deserializeUsingJson() {
        TreeNode root1 = sampleTree();
        String jsonStr = solve.serializeUsingJson(root1);
        TreeNode root2 = solve.deserializeUsingJson(jsonStr);
        System.out.println();
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

}