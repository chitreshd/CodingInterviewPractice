package com.algos.practice.leetcode.hard;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/18/17.
 */
public class EditDistanceTest {

    private EditDistance solve = new EditDistance();
    @Test
    public void calcMinDistance() throws Exception {
        String word1 = "sunny";
        String word2 = "snowy";

        assertEquals(3, solve.calcMinDistance(word1, word1.length() - 1, word2, word2.length() - 1));

        word1 = "exponential";
        word2 = "polynomial";

        assertEquals(6, solve.calcMinDistance(word1, word1.length() - 1, word2, word2.length() - 1));

        word1 = "a";
        word2 = "ab";
        assertEquals(1, solve.calcMinDistance(word1, word1.length() - 1, word2, word2.length() - 1));
    }

    @Test
    public void calcMinDistanceWithMemoization() throws Exception {
        String word1 = "sunny";
        String word2 = "snowy";
        Map<String, Integer> results = new HashMap<>();
        assertEquals(3, solve.calcMinDistanceWithMemoization(word1, word1.length() - 1, word2, word2.length() - 1, results));

        word1 = "exponential";
        word2 = "polynomial";
        results = new HashMap<>();
        assertEquals(6, solve.calcMinDistanceWithMemoization(word1, word1.length() - 1, word2, word2.length() - 1, results));
    }

    @Test
    public void calcMinDistanceWithTabulation() throws Exception {
        String word1 = "sunny";
        String word2 = "snowy";
        assertEquals(3, solve.calcMinDistanceWithTabulation(word1, word2));

        word1 = "exponential";
        word2 = "polynomial";
        assertEquals(6, solve.calcMinDistanceWithTabulation(word1, word2));

        word1 = "a";
        word2 = "ab";
        assertEquals(1, solve.calcMinDistanceWithTabulation(word1, word2));
    }

}