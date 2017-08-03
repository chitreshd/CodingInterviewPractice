package com.algos.practice.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 8/2/17.
 */
public class LongestPalindromicSubstringTest {
    private LongestPalindromicSubstring solve = new LongestPalindromicSubstring();

    @Test
    public void longestPalindrome() throws Exception {
        assertEquals("abba", solve.longestPalindrome("abba"));
        assertEquals("abcba", solve.longestPalindrome("abcba"));
        assertEquals("bab", solve.longestPalindrome("babad"));
        assertEquals("bb", solve.longestPalindrome("cbbd"));
    }

    @Test
    public void expandAroundCenter() throws Exception {
        assertEquals(solve.expandAroundCenter("abba",1,2),4);
        assertEquals(solve.expandAroundCenter("abcba",2,2),5);
    }

}