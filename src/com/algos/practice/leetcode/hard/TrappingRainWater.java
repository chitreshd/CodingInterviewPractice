package com.algos.practice.leetcode.hard;

import java.util.Stack;

/**
 * Created by cdeshpande on 6/27/17.
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        return cleanerTrap(height);
    }

    private int cleanerTrap(int [] height) {
        if(height == null || height.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int maxWater = 0;
        while(i < height.length) {
            if(stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            } else {
                int poppedBar = stack.pop();
                int barWater;
                if(!stack.isEmpty()) {
                    // left wall is present
                    int rightWall = height[i];
                    int leftWall = height[stack.peek()];
                    int poppedBarVal = height[poppedBar];
                    int distanceBetweenLeftAndRightWall = i - stack.peek() - 1;
                    barWater = ( Math.min(leftWall, rightWall) - poppedBarVal ) * distanceBetweenLeftAndRightWall;
                    maxWater += barWater;
                }
            }

        }

        return maxWater;

    }

    /**
     * Idea:
     * 1. Find first non-zero index
     * 2.
     * @param height
     * @return
     */
    private int messyTrap(int [] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        int firstNonZero = 0;
        while(firstNonZero < height.length && height[firstNonZero] == 0) {
            firstNonZero++;
        }

        if(firstNonZero == height.length) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int lastMax = height[firstNonZero];
        stack.push(lastMax);

        for(int i = firstNonZero + 1; i < height.length; i++) {
            int curr = height[i];
            if(!stack.isEmpty() && lastMax <= curr) {
                int popped = 0;
                int poppedSum = 0;
                while(stack.size() > 1) {
                    popped++;
                    poppedSum += stack.pop();
                }
                int currSum = (popped * lastMax) - poppedSum;
                sum += currSum;
                lastMax = curr;
                stack.pop();
            }
            stack.push(curr);
        }

        lastMax = stack.pop();
        int popped = 0;
        int poppedSum = 0;

        while(stack.size() > 1) {
            int curr = stack.pop();

            if(curr >= lastMax) {
                int currSum = (popped * lastMax) - poppedSum;
                sum += currSum;
                lastMax = curr;
                popped = 0;
                poppedSum = 0;
            } else {
                popped++;
                poppedSum += curr;
            }
        }

        sum += (popped * lastMax) - poppedSum;

        return sum;
    }
}
