package com.algos.practice.leetcode.medium;

import com.algos.practice.leetcode.hard.BinaryTreeMaximumPathSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.algos.practice.leetcode.hard.BinaryTreeMaximumPathSum.*;

/**
 * Created by cdeshpande on 6/21/17.
 */
public class ZigZagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return Collections.emptyList();

        /*Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        boolean orderRev = false;
        while(!queue.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            List<TreeNode> thisLevel = new ArrayList
            List<Integer> thisLevelVals = new ArrayList<>();



        }*/
        List<List<Integer>> levelArr = new ArrayList<>();
        levelTraversal(root, 0, levelArr);
        flipAlternateLevelOrder(levelArr);
        return levelArr;
    }

    private void flipAlternateLevelOrder(List<List<Integer>> levelArr) {
        boolean orderRev = false;
        for(List<Integer> levelList : levelArr) {
            if(orderRev) {
                Collections.reverse(levelList);
            }
            orderRev = !orderRev;
        }
    }

    private void levelTraversal(TreeNode node, int level, List<List<Integer>> levelArr) {
        if(node == null)
            return;

        if(level == levelArr.size()) {
            levelArr.add(new ArrayList<Integer>() );
        }

        levelArr.get(level).add(node.val);
        levelTraversal(node.left, level + 1, levelArr);
        levelTraversal(node.right, level + 1, levelArr);
    }

}
