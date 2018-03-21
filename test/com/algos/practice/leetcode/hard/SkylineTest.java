package com.algos.practice.leetcode.hard;

import org.junit.Test;
import static org.junit.Assert.*;
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
        assertEquals("[[2, 10][3, 15][7, 12][12, 0][15, 10][20, 8][24, 0]]", solve.convertToString(results));

        buildings = new int [][] {{0,2,3},{2,5,3}};
        results = solve.getSkyline(buildings);
        System.out.println(solve.convertToString(results));
        assertEquals("[[0, 3][5, 0]]", solve.convertToString(results));

        buildings = new int [][] {{1,2,1},{1,2,2},{1,2,3}};
        results = solve.getSkyline(buildings);
        System.out.println(solve.convertToString(results));
        assertEquals("[[1, 3][2, 0]]", solve.convertToString(results));

        buildings= new int [][] {{2,13,10},{10,17,25},{12,20,14}};
        results = solve.getSkyline(buildings);
        System.out.println(solve.convertToString(results));
        assertEquals("[[2, 10][10, 25][17, 14][20, 0]]", solve.convertToString(results));
    }



    @Test
    public void split() throws Exception {
        int [][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<Skyline.Triplet> triplets = solve.split(buildings);
        System.out.println(triplets);

    }

}