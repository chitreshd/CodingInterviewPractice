package com.algos.practice.ctci.hard;

import com.algos.practice.Constants;
import com.algos.practice.leetcode.medium.PalindromeMatching;

/**
 * Created by cdeshpande on 6/25/17.
 */
public class MaxSumSubMatrix {

    public int calcMaxSumNaive(int [][] input) {
        int max = Integer.MIN_VALUE;
        int rowCount = input.length;
        int colCount = input[0].length;

        for(int row1 = 0; row1 < rowCount; row1++) {
            for(int row2 = row1; row2 < rowCount; row2++) {
                for(int col1 = 0; col1 < colCount; col1++) {
                    for(int col2 = col1; col2 < colCount; col2++) {
                        int sum = calcSum(input, row1, row2, col1, col2);
                        if(Boolean.getBoolean(Constants.DEBUG)) {
                            System.out.println(String.format("[%s,%s]:[%s,%s] = %s",row1, col1, row2, col2, sum));
                        }
                        max = Math.max(sum, max);
                    }
                }
            }
        }

        return max;
    }

    protected int calcSum(int[][] input, int row1, int row2, int col1, int col2) {
        int sum = 0;
        for(int row = row1; row <= row2; row++) {
            for(int col = col1; col <= col2; col++) {
                sum += input[row][col];
            }

        }
        return sum;
    }

    public int calcMaxSumUsingPreCompute(int [][] input) {
        int max = Integer.MIN_VALUE;
        int rowCount = input.length;
        int colCount = input[0].length;
        int [][] precomputed = precompute(input);

        for(int row1 = 0; row1 < rowCount; row1++) {
            for(int row2 = row1; row2 < rowCount; row2++) {
                for(int col1 = 0; col1 < colCount; col1++) {
                    for(int col2 = col1; col2 < colCount; col2++) {
                        int sum = calcSumWithPrecompute(input, precomputed, row1, row2, col1, col2);
                        if(Boolean.getBoolean(Constants.DEBUG)) {
                            System.out.println(String.format("[%s,%s]:[%s,%s] = %s",row1, col1, row2, col2, sum));
                        }
                        max = Math.max(sum, max);
                    }
                }
            }
        }

        return max;
    }

    private int calcSumWithPrecompute(int[][] input, int[][] precomputed, int row1, int row2, int col1, int col2) {
        int Dt = precomputed[row2][col2];
        int Bt = row1 > 0 ? precomputed[row1 - 1][col2] : 0;
        int Ct = col1 > 0 ? precomputed[row2][col1 - 1] : 0;
        int A =  (row1 > 0 && col1 > 0) ? precomputed[row1 - 1][col1 - 1] : 0;
        int D = Dt - Bt - Ct + A;
        return D;
    }

    protected int [][] precompute(int [][] input) {
        int rowCount = input.length;
        int colCount = input[0].length;
        int [][] precomputed = new int[rowCount][colCount];

        for(int row = 0; row < rowCount; row++) {
            for(int col = 0; col < colCount; col++) {
                int _A = 0;
                if(row > 0 && col > 0) {
                    _A = precomputed[row - 1][col - 1];
                }

                int _B = 0;
                if(col > 0) {
                    _B = precomputed[row][col - 1];
                }

                int _C = 0;
                if(row > 0) {
                    _C = precomputed[row - 1][col];
                }

                precomputed[row][col] = _C + _B - _A + input[row][col];
            }
        }

        return precomputed;
    }
}
