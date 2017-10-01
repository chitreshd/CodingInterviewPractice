package com.algos.practice.ctci.moderate;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by cdeshpande on 10/1/17.
 * Problem:
 * Diving Board: You are building a diving board by placing a bunch of planks of wood end-to-end. There are two types
 * of planks, one of length shorter and one of length longer. You must use exactly K planks of wood.Write a method to
 * generate all possible lengths for the diving board.
 */

public class DivingBoard {

    public Collection<Integer> getAllPossibleLengths(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();
        for(int i = 0; i <= k; i++) {
            int sum = (i * shorter) + ((k - i) * longer);
            lengths.add(sum);
        }
        return lengths;
    }


}
