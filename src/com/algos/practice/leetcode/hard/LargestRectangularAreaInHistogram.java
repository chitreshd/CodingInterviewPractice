package com.algos.practice.leetcode.hard;

import com.algos.practice.concepts.SegmentTreeRMQWithIndexes;

import java.util.Stack;

/**
 * Created by cdeshpande on 6/13/17.
 * Problem:

 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 The largest rectangle is shown in the shaded area, which has area = 10 unit.

 For example,
 Given heights = [2,1,5,6,2,3],
 return 10.

 For pics and description refer: https://leetcode.com/problems/largest-rectangle-in-histogram/#/description

 Solution references:
 Simple solution O(n^2):
 Considering each bar as start of rectangle, iterate through rest of array for the end of
 rectangle. This should give all possible rectangles and thus also finding the one
 with max area.

 Divide and Conquer O(nlogn): http://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/
 Linear O(n) http://www.geeksforgeeks.org/largest-rectangle-under-histogram/

 *
 */
public class LargestRectangularAreaInHistogram {

    public int largestRectangleArea(int[] heights) {
        return largestRectangleAreaUsingDivideAndConquer(heights);
    }

    /**
     *
     * Core idea:
     * max area is max of one of the followings:
     * 1. max area to the right of min
     * 2. max area to the left of min
     * 3. min * Num of bars
     * @param heights
     * @return
     */
    protected int largestRectangleAreaUsingDivideAndConquer(int [] heights) {
        SegmentTreeRMQWithIndexes rmq = new SegmentTreeRMQWithIndexes(heights);
        return maxRecUsingDivideAndConquer(heights, rmq, 0, heights.length - 1);

    }

    private int maxRecUsingDivideAndConquer(int[] heights, SegmentTreeRMQWithIndexes rmq, int start, int end) {
        if(start == end)
            return heights[start];

        if(start > end)
            // invalid node
            return 0;

        int min = rmq.query(start, end);
        int left = maxRecUsingDivideAndConquer(heights, rmq, start, min - 1);
        int right = maxRecUsingDivideAndConquer(heights, rmq, min + 1, end);
        int minMultipliedByAll = heights[min] * ((end - start) + 1);
        return Math.max(Math.max(left, right), minMultipliedByAll);
    }


    public int getMaxArea(int [] hist) {
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        int top;
        int areaWithTop;
        int n = hist.length;
        int i = 0;
        while(i < n) {

            if(s.isEmpty() || hist[s.peek()] <= hist[i]) {
                s.push(i++);
            } else {
                top = s.pop();
                areaWithTop = hist[top] * (s.isEmpty() ? i : i - s.peek() - 1);

                maxArea = Math.max(maxArea, areaWithTop);
            }
        }

        while(!s.isEmpty()) {
            top = s.pop();
            areaWithTop = hist[top] * (s.isEmpty() ? i : i - s.peek() - 1);

            maxArea = Math.max(maxArea, areaWithTop);

        }
        return maxArea;
    }
}
