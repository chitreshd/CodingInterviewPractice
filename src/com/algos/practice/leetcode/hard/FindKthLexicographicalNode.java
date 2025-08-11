package com.algos.practice.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cdeshpande on 12/14/16.
 */
public class FindKthLexicographicalNode {

    /**
     * Algorithm:
     *  Consider a tree
     *  0
     *      1
     *          10
     *              100
     *            ..109
     *          11
     *        ..19
     *      2
     *      3
     *  Now the lexical order is just the pre-order traversal of this tree.
     *  Thus, the kth step is the answer.
     *  Optimization: No need to actually traverse k steps. Some steps can be skipped.
     *  If:   steps <= k, move to next node on the same level ( thus skipping the nodes below that level )
     *  else: move by one node, i.e. to next level
     *
     * @param n
     * @param k
     * @return
     *
     *
     * Ref: https://discuss.leetcode.com/topic/64624/concise-easy-to-understand-java-5ms-solution-with-explaination/2
     */
    public static int findKthSmallestNode(int n, int k) {
        int curr = 1;
        k = k - 1;
        while(k > 0) {
            int steps = calSteps(curr, curr + 1, n);
            if(steps <= k ) {
                curr++;
                k -= steps;
            } else {
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    private static boolean isEndOfLevel(int curr) {
        int lastDigit;
        int remainingDigit = curr;
        do {
            lastDigit = remainingDigit % 10;
            remainingDigit = remainingDigit / 10;
            if(lastDigit != 9)
                return false;
        } while(remainingDigit > 0);

        return true;
    }


    /**
     * Algorithm:
     *
     *
     * @param n1
     * @param n2
     * @param n
     * @return
     */
    private static int calSteps(int n1, int n2, int n) {
        int steps = 0;
        while(n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }

    public static void main(String[] args) {
        /*execute(13,2, 10);
        //execute(190,78, 17);
        execute(10,2, 10);
        //execute(10,2, 2);
        execute(100,100, 99);*/
        //System.out.println(isEndOfLevel(0));
        printOrder(13);
        printOrder(130);
    }

    private static void execute(int n, int k, int expected) {
        int ans = findKthSmallestNode(n,k);
        System.out.println(String.format("n: %s, k: %s, lexical node: %s", n, k, ans));
        if (ans != expected) {
            throw new RuntimeException("incorrect ans: expected " + expected + " but got " + ans);
        }
    }

    public static void printOrder(int n) {
        List<String> nums = new ArrayList<>();
        for(int i = 1; i <= n;i++) {
            nums.add(Integer.toString(i));
        }
        Collections.sort(nums);
        System.out.println(nums);
        System.out.println(calSteps(1, 2, 340));
    }
}
