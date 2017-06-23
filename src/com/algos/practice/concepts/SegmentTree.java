package com.algos.practice.concepts;

import java.util.Arrays;

/**
 * Created by cdeshpande on 6/13/17.
 * Refs: http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 */
public class SegmentTree {
    private int [] segments;
    private int n;

    public SegmentTree(int [] nums) {
        this.n = nums.length;

        int maxHeight = (int) Math.ceil((log2(n)));
        int maxSize = 2*(int)Math.pow(2, maxHeight) - 1;
        segments = new int[maxSize];
        construct(nums,0,n - 1,0);
    }

    private int construct(int[] nums, int start, int end, int segmentArrIndex) {
        if(segmentArrIndex > segments.length - 1)
            return defaultValue();

        if(start == end) {
            segments[segmentArrIndex] = nums[start];
            return nums[start];
        }

        int mid = ( start + end ) >> 1;
        int leftResult = construct(nums, start, mid, 2 * segmentArrIndex + 1);
        int rightResult = construct(nums, mid + 1, end, 2 * segmentArrIndex + 2);
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
        return Integer.MAX_VALUE;
    }

    protected int applySegmentFunction(int leftResult, int rightResult) {
        return Math.min(leftResult, rightResult);
    }

    protected int [] getSegments() {
        return Arrays.copyOf(segments, segments.length);
    }

    public static void main(String[] args) {
        int n = 7;
        int x = (int) Math.ceil((log2(n)));
        int max_size = 2*(int)Math.pow(2, x) - 1;

        int sizeFromLen = 2 * n - 1;
        System.out.println(String.format("height: %s, size: %s, size from input length: %s", x, max_size, sizeFromLen));
    }

    private static double log2(int n) {
        return Math.log(n) / Math.log(2);
    }
}
