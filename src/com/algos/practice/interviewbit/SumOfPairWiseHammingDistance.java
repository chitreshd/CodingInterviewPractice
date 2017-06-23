package com.algos.practice.interviewbit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cdeshpande on 6/19/17.
 */
public class SumOfPairWiseHammingDistance {

    private Map<Integer,Integer> setBitCount = new HashMap<>();

    public int hammingDistance(final List<Integer> A) {
        int sum = 0;
        for(int i = 0; i < A.size(); i++) {
            for(int j = i + 1; j < A.size(); j++) {
                if(A.get(i) != A.get(j)) {
                    sum += getHammingDistance(A.get(i), A.get(j));
                }

            }
        }
        return sum * 2;
    }

    protected int getHammingDistance(int a, int b) {
        int xOrResult = a ^ b;
        return getNumOfSetBitsOptimized(xOrResult);
       // return getNumOfSetBits(xOrResult);
    }

    private int getNumOfSetBitsOptimized(int xOrResult) {
        int temp = xOrResult;
        if(setBitCount.containsKey(xOrResult)) {
            return setBitCount.get(xOrResult);
        }

        int count = 0;
        while(temp != 0) {
            temp = temp & (temp - 1);
            count++;
        }
        setBitCount.put(xOrResult, count);
        return count;
    }

    /**
     * Logic: Consider array has only binary numbers
     * 1-bit: [0,1]
     * Num of bits set (x) = 1, Num of bits not set(y) = 1 (n - x ).
     * hamming distance between unique pair(h) = 1
     * For (0,1) = 1 and (1,0) it will be another 1.  Thus ans = 2*h
     *
     * 3-bit: [010, 001, 110]
     * [ 0: x = 1, y = 2 ], [ 1: x = 2, y = 1 ], [ 2: x = 1, y = 2 ]
     * h = (1*2) + (2*1) + (1*2) = 6
     * ans = 6 * 2 = 12
     *
     * @param A
     * @return
     */
    protected int calcSumOfPairwiseHammingDistanceUsingBits(final List<Integer> A) {

        int sum = 0; // hamming distance for unique pairs.
        int n = A.size();

        for(int i = 0; i < 32; i++) {
            int x = 0;
            for(int a : A) {
                int ithBitFora = a & (1 << i);
                if(ithBitFora != 0) {
                    x++;
                }
            }
            int y = n - x;
            sum += (x * y);
        }

        return sum*2; // multiply by 2 as sum is only for unique pairs
    }
    private int getNumOfSetBits(int xOrResult) {
        int count = 0;
        while(xOrResult != 0) {
            xOrResult = xOrResult & (xOrResult - 1);
            count++;
        }
        return count;
    }
}
