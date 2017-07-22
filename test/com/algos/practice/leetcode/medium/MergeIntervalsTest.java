package com.algos.practice.leetcode.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.algos.practice.leetcode.medium.MergeIntervals.*;
import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 7/20/17.
 */
public class MergeIntervalsTest {

    MergeIntervals solve = new MergeIntervals();

    @Test
    public void merge() throws Exception {
        List<Interval> input = generate(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        List<Interval> merged = solve.mergeUsingSort(input);
        System.out.println(merged);

        input = generate(new int[][]{{1,4},{0,4}});
        merged = solve.mergeUsingSort(input);
        System.out.println(merged);
    }

    private List<Interval> generate(int[][] input2D) {
        List<Interval> intervals = new ArrayList<>();
        for(int [] i : input2D) {
            intervals.add(new Interval(i[0],i[1]));
        }
        return intervals;
    }

}