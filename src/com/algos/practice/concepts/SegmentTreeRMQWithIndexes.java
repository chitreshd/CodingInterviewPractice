package com.algos.practice.concepts;

import java.util.Arrays;

/**
 * Created by cdeshpande on 6/13/17.
 * Refs: http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 */
public class SegmentTreeRMQWithIndexes {
    private int [] segments;
    private int n;
    private int [] input;

    public SegmentTreeRMQWithIndexes(int [] nums) {
        this.n = nums.length;
        this.input = nums;
        int maxHeight = (int) Math.ceil((log2(n)));
        int maxSize = 2*(int)Math.pow(2, maxHeight) - 1;
        segments = new int[maxSize];
        construct(0,n - 1,0);
    }

    private double log2(int n) {
        return Math.log(n) / Math.log(2);
    }

    private int construct(int start, int end, int segmentArrIndex) {
        if(start == end) {
            segments[segmentArrIndex] = start;
            return start;
        }

        int mid = ( start + end ) >> 1;
        int leftResult = construct(start, mid, 2 * segmentArrIndex + 1);
        int rightResult = construct(mid + 1, end, 2 * segmentArrIndex + 2);
        int val = applySegmentFunction(leftResult, rightResult);
        segments[segmentArrIndex] = val;

        return val;

    }

    public int query(int start, int end) {
        // Check for erroneous input values
        if (start < 0 || end > n - 1 || start > end) {
            System.out.println("Invalid Input");
            return -1;
        }

        return doQuery(0, n - 1, start, end, 0);
    }

    private int doQuery(int ss, int se, int qs, int qe, int index) {
        // if segment of this node i.e. ss and se are between queried range
        if(qs <= ss && se <= qe) {
            return segments[index];
        }

        if (se < qs || ss > qe)
            return defaultValue();

        int mid = (ss + se) >> 1;
        int leftResult = doQuery(ss, mid, qs, qe, 2 * index + 1);
        int rightResult = doQuery(mid + 1, se, qs, qe, 2 * index + 2);
        return applySegmentFunction(leftResult,rightResult);
    }

    protected int defaultValue() {
        return n;
    }

    protected int applySegmentFunction(int leftResult, int rightResult) {
        int left = leftResult >= n ? Integer.MAX_VALUE : input[leftResult];
        int right = rightResult >= n ? Integer.MAX_VALUE : input[rightResult];
        if(left < right) {
            return leftResult;
        } else {
            return rightResult;
        }
    }

    protected int [] getSegments() {
        return Arrays.copyOf(segments, segments.length);
    }
}
