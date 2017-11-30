package com.algos.practice.leetcode.medium;

public class ProductOfArrayExceptSelf {

    public int [] solve(int [] input) {
        if(input == null || input.length == 0)
            return null;

        if(input.length == 1) {
            return new int[]{1};
        }

        int [] output = new int[input.length];
        int lastIndex = input.length - 1;
        output[lastIndex] = input[lastIndex];
        for(int i = input.length - 2; i > 0; i--) {
            output[i] = output[i + 1] * input[i];
        }

        int runningLeft = input[0];
        output[0] = output[1];
        for(int i = 1; i < lastIndex; i++) {
            output[i] = runningLeft * output[i+1];
            runningLeft *= input[i];
        }
        output[lastIndex] = runningLeft;
        return output;

    }
}
