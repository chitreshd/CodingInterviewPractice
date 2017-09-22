package com.algos.practice.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by cdeshpande on 9/18/17.
 */
public class NumberOfIslands {

    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        return usingDFS(grid);
    }

    private int usingDFS(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }

    // This is wrong, refer to testcase number 3
    private int byLookingAtNeighbour(char [][] grid) {

        if(grid == null || grid.length == 0)
            return 0;

        int rowLen = grid.length;
        int colLen = grid[0].length;
        int islandNumber = 0;
        char islandMark = 'm';

        for(int i = 0; i < rowLen; i++) {

            for(int j = 0; j < colLen; j++) {

                if(grid[i][j] == '1') {
                    if(!neighboursMarked(grid, i, j)) {
                        islandNumber++;
                    }
                    grid[i][j] = islandMark;
                }

            }

        }

        return islandNumber;

    }

    private boolean neighboursMarked(char[][] grid, int i, int j) {
        int rL = grid.length;
        int cL = grid[0].length;

        if(i > 0 && grid[i - 1][j] == 'm')
            return true;

        if(i < rL - 1 && grid[i + 1][j] == 'm')
            return true;

        if(j > 0 && grid[i][j - 1] == 'm')
            return true;

        if(j < cL - 1 && grid[i][j + 1] == 'm')
            return true;

        return false;
    }

    private int usingBFS(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;

        int rowLen = grid.length;
        int colLen = grid[0].length;
        int islandNumber = 0;
        char islandMark = 'm';

        for(int i = 0; i < rowLen; i++) {

            for(int j = 0; j < colLen; j++) {

                if(grid[i][j] == '1') {
                    bfs(grid, i, j, islandMark);
                    islandNumber++;
                }

            }

        }

        return islandNumber;
    }

    private void bfs(char[][] grid, int i, int j, char mark) {
        int rowLen = grid.length;
        int collen = grid[0].length;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(i,j));

        while(!q.isEmpty()) {
            Pair cell = q.poll();
            grid[cell.row][cell.col] = mark;

            List<Pair> neighbours = getValidNeighbours(cell, rowLen, collen);
            for (Pair neighbour : neighbours) {
                if(grid[neighbour.row][neighbour.col] == '1') {
                    q.add(neighbour);
                }
            }
        }
    }

    private List<Pair> getValidNeighbours(Pair cell, int rowLen, int colLen) {
        List<Pair> neighbours = new ArrayList<>();

        if(cell.row > 0) {
            neighbours.add(new Pair(cell.row - 1, cell.col));
        }

        if(cell.row < rowLen - 1) {
            neighbours.add(new Pair(cell.row + 1, cell.col));
        }

        if(cell.col > 0) {
            neighbours.add(new Pair(cell.row, cell.col - 1));
        }

        if(cell.col < colLen - 1) {
            neighbours.add(new Pair(cell.row, cell.col + 1));
        }

        return neighbours;

    }


    private static class Pair {
        int row;
        int col;

        Pair(int i, int j) {
            row = i;
            col = j;

        }
    }




}
