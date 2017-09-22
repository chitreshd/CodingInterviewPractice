package com.algos.practice.leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 9/18/17.
 */
public class NumberOfIslandsTest {

    private NumberOfIslands solve = new NumberOfIslands();

    @Test
    public void numIslands() throws Exception {
        char [][] grid = convertTo2D(new String[]{"11110","11010","11000","00000"});
        /*for(int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }*/
        assertEquals("testcase: 1", 1, solve.numIslands(grid));
        grid = convertTo2D(new String[]{"11000","11000","00100", "00011"});
        assertEquals("testcase: 2", 3, solve.numIslands(grid));
        grid = convertTo2D(new String[]{"111","010","111"});
        assertEquals("testcase: 3", 1, solve.numIslands(grid));
        System.out.println("success");
    }

    private char [][] convertTo2D(String [] strings) {
        char [][] grid = new char[strings.length][strings[0].length()];
        for(int i = 0; i < grid.length; i++) {
            grid[i] = strings[i].toCharArray();
        }
        return grid;
    }

}