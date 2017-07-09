package com.algos.practice.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdeshpande on 7/6/17.
 *
 * Problem:
 * Given an integer matrix, find the length of the longest increasing path.

 From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

 Example 1:

 nums = [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]
 Return 4
 The longest increasing path is [1, 2, 6, 9].

 Example 2:

 nums = [
 [3,4,5],
 [3,2,6],
 [2,2,1]
 ]
 Return 4
 The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.


 *
 */
public class LongestIncreasingPathInMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        return 0;
    }

    protected int findLIPUsingCache(int [][] matrix) {
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                int curr = doFindLIPUsingCache(matrix, i, j, cache);
                max = Math.max(max, curr);
            }
        }

        return max;

    }

    protected int doFindLIPUsingCache(int [][] matrix,int row, int col, int [][] cache) {
        if(cache[row][col] > 0)
            return cache[row][col];

        int max = 1;
        List<int []> validAdjacents = getValidAdjacents(matrix, row, col);
        int curr = matrix[row][col];
        matrix[row][col] = Integer.MAX_VALUE;

        for(int [] next : validAdjacents) {
            int len = doFindLIPUsingCache(matrix, next[0], next[1], cache);
            max = Math.max(max, len + 1);
        }

        matrix[row][col] = curr;
        cache[row][col] = max;
        return max;

    }


    protected int findLIP(int [][] matrix) {
        Max max = new Max();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                doFindLIP(matrix, i, j, 1, max);
            }
        }

        return max.val;

    }


    protected void doFindLIP(int [][] matrix, int row, int col, int currLen, Max max) {
        max.val = Math.max(currLen, max.val);
        List<int []> validAdjacents = getValidAdjacents(matrix, row, col);
        int curr = matrix[row][col];
        matrix[row][col] = Integer.MAX_VALUE;

        for(int [] next : validAdjacents) {
            doFindLIP(matrix, next[0], next[1], currLen + 1, max);
        }

        matrix[row][col] = curr;


    }

    protected List<int []> getValidAdjacents(int [][] matrix, int row, int col) {
        List<int []> adjacents = new ArrayList<>();
        int curr = matrix[row][col];

        if(col > 0) {
            int left = matrix[row][col - 1];
            if(left != Integer.MAX_VALUE && left > curr) {
                adjacents.add(new int[]{row, col - 1});
            }
        }
        if(col < matrix[0].length - 1) {
            int right = matrix[row][col + 1];
            if(right != Integer.MAX_VALUE && right > curr) {
                adjacents.add(new int[]{row, col + 1});
            }
        }
        if(row > 0) {
            int up = matrix[row - 1][col];
            if(up != Integer.MAX_VALUE && up > curr) {
                adjacents.add(new int[]{row - 1, col});
            }
        }
        if(row < matrix.length - 1) {
            int down = matrix[row + 1][col];
            if(down != Integer.MAX_VALUE && down > curr) {
                adjacents.add(new int[]{row + 1, col});
            }
        }
        return adjacents;
    }

    class Max {
        int val;
    }
}
