package com.algos.practice.leetcode.medium;

import java.util.PriorityQueue;

/**
 * Created by cdeshpande on 8/6/17.
 *
 Problem: Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ? k ? array's length.

 *
 */
public class KthLargest {

    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums)  {
            if(minHeap.size() < k) {
                minHeap.add(num);
            } else {
                if(num > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(num);
                }
            }
        }

        return minHeap.poll();
    }

}
