package com.algos.practice.leetcode.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class WordBreakTest {
    @Test
    public void wordBreak() throws Exception {
        assertTrue(solve.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    private WordBreak solve = new WordBreak();

    @Test
    public void doWordBreak() throws Exception {
        Set<String> wd = new HashSet<>(Arrays.asList("leet", "code"));
        int[] dp = new int["leetcode".length()];
        Arrays.fill(dp, -1);
        assertEquals(1, solve.doWordBreak("leetcode", 0, wd, dp));
    }

}