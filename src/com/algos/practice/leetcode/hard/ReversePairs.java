package com.algos.practice.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cdeshpande on 5/16/17.
 *
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 * You need to return the number of important reverse pairs in the given array.
 * Example1:

 Input: [1,3,2,3,1]
 Output: 2
 Example2:

 Input: [2,4,3,5,1]
 Output: 3
 *
 * Helpful Links:
 * https://leetcode.com/problems/reverse-pairs/#/solutions
 * https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/#read
 * https://cs.stackexchange.com/questions/10538/bit-what-is-the-intuition-behind-a-binary-indexed-tree-and-how-was-it-thought-a
 *
 * This problem can be efficiently solved using 3 ways:
 * 1. Self Balancing Binary Tree
 * 2. Binary Indexed Tree (BIT)
 * 3. Modifying merge sort
 *
 * Choosing 2 because of interest in BIT
 * Given an array A[0:n], consider index p. Now we need to search for number of values in
 * A[0:p-1] that are > A[p] * 2. Consider A[p] = v, then we need to search all values
 * greater than 2p.
 *
 */
public class ReversePairs {

    private  int search(int[] bit, int val) {
        // not conventional bit search. this goes in other direction i.e. from index to end
        int sum = 0;
        while (val < bit.length) {
            sum += bit[val];
            val += val & -val;
        }
        return sum;
    }

    private  void insert(int [] bit, int val) {
        // not conventional bit index. this goes in other direction i.e. from index to start
        while (val > 0) {
            bit[val] += 1;
            val -= val & -val;
        }
    }

    public  int reversePairs(int [] input) {
        int sum = 0;
        int [] sortedCopy = Arrays.copyOf(input, input.length);
        int [] bit = new int[sortedCopy.length + 1];

        Arrays.sort(sortedCopy);

        for (int inputNum : input) {
            int searchIndex = index(sortedCopy, inputNum * 2L + 1);
            sum += search(bit, searchIndex);
            int insertIndex = index(sortedCopy, inputNum);
            insert(bit, insertIndex);
        }

        return sum;
    }

    private  int index(int[] arr, long val) {
        int l = 0, r = arr.length - 1, m = 0;

        while (l <= r) {
            m = (l + r) / 2;

            if (arr[m] >= val) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l + 1;
    }


    private  List<Integer> getPathToRoot(int i) {
        List<Integer> path = new ArrayList();
        while (i > 0) {
            path.add(i);
            i -= i & -i;
        }
        return path;
    }

    public static void main(String[] args) {
        ReversePairs rp = new ReversePairs();
        int[] input = new int[]{1,3,2,3,1};
        System.out.println("Reverse Pairs: " + rp.reversePairs(input));
        input = new int[] {2,4,3,5,1};
        System.out.println("Reverse Pairs: " + rp.reversePairs(input));
    }



}
