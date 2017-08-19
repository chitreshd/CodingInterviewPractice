package com.algos.practice.leetcode.hard;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.algos.practice.leetcode.hard.InsertInterval.*;
import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 8/15/17.
 */
public class InsertIntervalTest {
    private InsertInterval solve = new InsertInterval();

    @Test
    public void insert() throws Exception {
        List<Interval> intervals = Arrays.asList(new Interval(1,3), new Interval(6,9));
        Interval newInterval = new Interval(2,5);
        List<Interval> actual = solve.insert(intervals, newInterval);
        System.out.println(actual); // [(1, 5), (6, 9)]
        intervals = Arrays.asList(new Interval(1,2), new Interval(3,5),
                                  new Interval(6,7), new Interval(8,10),
                                  new Interval(12,16));
        newInterval = new Interval(4,9);
        actual = solve.insert(intervals, newInterval);
        System.out.println(actual); // [(1, 2), (3, 10), (12, 16)]


        intervals = Arrays.asList(new Interval(1,5));
        newInterval = new Interval(6,8);// [(1, 5), (6, 8)]
        actual = solve.insert(intervals, newInterval);
        System.out.println(actual);

        intervals = Arrays.asList(new Interval(1,5));
        newInterval = new Interval(0,3);
        actual = solve.insert(intervals, newInterval);
        System.out.println(actual); // [(0, 5)]


        intervals = Arrays.asList(new Interval(1,5));
        newInterval = new Interval(0,1);
        actual = solve.insert(intervals, newInterval);
        System.out.println(actual); // [(0, 5)]

        intervals = Arrays.asList(new Interval(1,5));
        newInterval = new Interval(0,0);
        actual = solve.insert(intervals, newInterval);
        System.out.println(actual); // [[0,0],[1,5]]



    }





}