package com.algos.practice.ctci.recursionanddp;

/**
 * Created by cdeshpande on 8/5/17.
 *
 * Solution: Use recursion to try out each possible combination of arrangement.
 *
 * Mistake:
 * 1. Didnt check valid r i.e. row of diagonal under test.
 *
 * Beware:
 * 1. To mark the col as used and unused . Ref line: 35 and 37.
 */
public class Queens {

    public int totalNQueens(int N) {
        int [] usedColumns = new int[N];
        for(int i = 0; i < N; i++) {
            usedColumns[i] = -1;
        }
        return ways(0,usedColumns, N, N);
    }

    protected int ways(int currRow, int [] usedColumns, int remaining, int N) {
        if(remaining == 0)
            return 1;

        if(currRow >= N) {
            return 0;
        }

        int ways = 0;
        for(int col = 0; col < N; col++) {
            if(valid(col, currRow, usedColumns)) {
                usedColumns[col] = currRow;
                ways += ways(currRow + 1, usedColumns, remaining - 1, N);
                usedColumns[col] = -1;
            }
        }

        return ways;
    }

    protected boolean valid(int col, int currRow, int[] usedColumns) {
        if(usedColumns[col] >= 0)
            return false;

        // diagonals

        // decreasing columns
        int c = col - 1;
        int r = currRow - 1;
        while(c >= 0 && r >= 0) {
            if(usedColumns[c] == r) {
                return false;
            }
            c--;
            r--;
        }

        // increasing columns
        c = col + 1;
        r = currRow - 1;
        while(c < usedColumns.length && r >= 0) {
            if(usedColumns[c] == r) {
                return false;
            }
            c++;
            r--;
        }

        return true;
    }

}
