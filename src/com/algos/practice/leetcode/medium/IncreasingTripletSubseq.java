package com.algos.practice.leetcode.medium;

import java.util.Arrays;

public class IncreasingTripletSubseq {


    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;

        for(int i : nums) {
            if(i <= small) {
                small = i;
            } else if(i <= big) {
                big = i;
            } else {
                return true;
            }

        }

        return false;

    }


    protected boolean increasingNums(int [] nums) {
        int N = 3;
        int [] mins = new int[N];
        Arrays.fill(mins, Integer.MAX_VALUE);

        for(int num : nums) {
            int i = 0;
            while(i < N) {
                if(num <= mins[i]) {
                    mins[i]= num;
                    break;
                }
                i++;
            }
            if(i == N - 1) {
                return true;
            }
        }

        return false;
    }
}
