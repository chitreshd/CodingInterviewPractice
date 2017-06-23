package com.algos.practice.leetcode.hard;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

}