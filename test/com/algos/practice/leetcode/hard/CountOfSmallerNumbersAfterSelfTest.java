package com.algos.practice.leetcode.hard;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CountOfSmallerNumbersAfterSelfTest {

    CountOfSmallerNumbersAfterSelf solve = new CountOfSmallerNumbersAfterSelf();

    @Test
    public void doCountSmaller() throws Exception {
        int [] input = {5, 2, 6, 1};
        List<Integer> result = solve.doCountSmaller(input);
        System.out.println(result);

        int [] input1 = {6, 5, 2, 1};
        result = solve.doCountSmaller(input1);
        System.out.println(result);

        int [] input2 = {0,1,2};
        result = solve.doCountSmaller(input2);
        System.out.println(result);
    }

}