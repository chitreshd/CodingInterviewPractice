package com.algos.practice.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/10/17.
 */
public class MinimumWindowSubstringTest {

    MinimumWindowSubstring solution = new MinimumWindowSubstring();

    @Test
    public void minWindow() throws Exception {
        assertEquals(solution.minWindow("ADOBECODEBANC","ABC"), "BANC");
        assertEquals(solution.minWindow("AAAAABC","ABC"), "ABC");
        assertEquals(solution.minWindow("ab","a"), "a");
    }

    @Test
    public void minWindowRevision() throws Exception {
        assertEquals(solution.minWindowRevision("ADOBECODEBANC","ABC"), "BANC");
        assertEquals(solution.minWindowRevision("AAAAABC","ABC"), "ABC");
        assertEquals(solution.minWindowRevision("ab","a"), "a");
        assertEquals(solution.minWindowRevision("AbabbbAbaA","Bab"), "");


    }

}