package com.algos.practice.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/22/17.
 */
public class LetterCombinationsTest {

    LetterCombinations solve = new LetterCombinations();

    @Test
    public void letterCombinations() throws Exception {
        System.out.println(solve.letterCombinations("2"));
        System.out.println(solve.letterCombinations("23"));
    }

}