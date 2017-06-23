package com.algos.practice.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by cdeshpande on 6/11/17.
 */
public class MedianFinder {
    /** initialize your data structure here. */
    private PriorityQueue<Integer> leftMaxHeap;
    private PriorityQueue<Integer> rightMinHeap;
    private static final int INITIAL_CAPACITY = 10;

    public MedianFinder() {
        Comparator<? super Integer> maxHeapComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
        leftMaxHeap = new PriorityQueue<>(INITIAL_CAPACITY, maxHeapComparator);

        Comparator<? super Integer> minHeapComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        rightMinHeap = new PriorityQueue<>(INITIAL_CAPACITY, minHeapComparator);

    }

    public void addNum(int num) {
        if(leftMaxHeap.size() == 0) {
            leftMaxHeap.add(num);
            return;
        }

        if(num > leftMaxHeap.peek()) {
            rightMinHeap.add(num);
        } else {
            leftMaxHeap.add(num);
        }

        if(leftMaxHeap.size() - rightMinHeap.size() > 1) {
            int temp = leftMaxHeap.poll();
            rightMinHeap.add(temp);
        } else if(rightMinHeap.size() > leftMaxHeap.size()) {
            int temp = rightMinHeap.poll();
            leftMaxHeap.add(temp);
        }
    }

    public double findMedian() {
        if(leftMaxHeap.size() > rightMinHeap.size()) {
            return leftMaxHeap.peek();
        } else if(leftMaxHeap.size() == rightMinHeap.size()) {
            return (leftMaxHeap.peek() + rightMinHeap.peek()) * 1.0 / 2;
        }

        return Integer.MIN_VALUE; // error
    }


}
