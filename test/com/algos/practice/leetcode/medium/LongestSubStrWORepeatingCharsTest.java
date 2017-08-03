package com.algos.practice.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 7/29/17.
 */
public class LongestSubStrWORepeatingCharsTest {
    private LongestSubStrWORepeatingChars solve = new LongestSubStrWORepeatingChars();

    @Test
    public void lengthOfLongestSubstring() throws Exception {
        assertEquals(solve.lengthOfLongestSubstring("abcabcbb"), 3);
        assertEquals(solve.lengthOfLongestSubstring("bbbbb"), 1);
        assertEquals(solve.lengthOfLongestSubstring("pwwkew"), 3);


    }

}