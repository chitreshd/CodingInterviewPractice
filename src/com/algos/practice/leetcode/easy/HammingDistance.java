package com.algos.practice.leetcode.easy;

public class HammingDistance {

    public int solve(int x, int y) {
        return Integer.bitCount(x ^ y);
    }



}
