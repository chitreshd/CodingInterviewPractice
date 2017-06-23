package com.algos.practice.leetcode.hard;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cdeshpande on 6/16/17.
 */
public class SkylineTest {

    Skyline solve = new Skyline();

    @Test
    public void getSkyline() throws Exception {
        int [][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<int []> results = solve.getSkyline(buildings);
        System.out.println(solve.convertToString(results));

        buildings = new int [][] {{0,2,3},{2,5,3}};
        results = solve.getSkyline(buildings);
        System.out.println(solve.convertToString(results));

        buildings = new int [][] {{1,2,1},{1,2,2},{1,2,3}};
        results = solve.getSkyline(buildings);
        System.out.println(solve.convertToString(results));
    }



    @Test
    public void split() throws Exception {
        int [][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<Skyline.Triplet> triplets = solve.split(buildings);
        System.out.println(triplets);

    }

}