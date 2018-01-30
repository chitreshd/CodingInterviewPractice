package com.algos.practice.leetcode.hard;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/6/17.
 */
public class ConcatenatedWordsTest {
    private ConcatenatedWords solution = new ConcatenatedWords();

    @Test
    public void findAllConcatenatedWordsInADict() throws Exception {
        String [] input = new String[] {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String> output = solution.findAllConcatenatedWordsInADict(input);
        assertTrue(output.containsAll(Arrays.asList("catsdogcats", "dogcatsdog", "ratcatdogcat")));
    }

    @Test
    public void isConcWord() throws Exception {
        String [] input = new String[] {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        String word = "catsdogcats";
        Set<String> dict = new HashSet<>(Arrays.asList(input));
        int[] dp = new int[word.length()];
        int output = solution.isConcWord(word, dict, 0, dp);
        assertTrue(output == 1);
    }

}