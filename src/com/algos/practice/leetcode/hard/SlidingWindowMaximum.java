package com.algos.practice.leetcode.hard;

import java.util.*;

/**
 * Created by cdeshpande on 7/5/17.
 *
 * Problems:
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].

 Note:
 You may assume k is always valid, ie: 1 ? k ? input array's size for non-empty array.

 Follow up:
 Could you solve it in linear time?
 */

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        return null;
    }

    /*protected int[] usingPQ(int [] nums, int k) {

    }*/

    protected int[] linearAlgoUsingDeque(int [] nums, int k) {
        if(nums == null || nums.length == 0)
            return new int[0];

        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> results = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {

            int curr = nums[i];

            if(!deque.isEmpty() && !inRange(deque.getFirst(), i, k)) {
                deque.removeFirst();
            }

            while(!deque.isEmpty() && nums[deque.getLast()] <= curr) {
                deque.removeLast();
            }

            deque.addLast(i);

            if(i >= (k - 1)) {
                results.add(nums[deque.getFirst()]);
            }
        }

        int [] resultsArr = new int[results.size()];
        for(int i = 0; i < results.size(); i++) {
            resultsArr[i] = results.get(i);
        }
        return resultsArr;
    }

    protected boolean inRange(Integer headOfQueue, int currIndex, int k) {
        return (currIndex - headOfQueue) < k;
    }

}
