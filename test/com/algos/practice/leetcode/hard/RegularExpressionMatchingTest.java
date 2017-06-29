package com.algos.practice.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/9/17.
 */
public class RegularExpressionMatchingTest {
    
    @Test
    public void isMatchSolutionFromLeetCode() throws Exception {


        isMatch("aa","a",false);
        isMatch("aa","aa",true);
        isMatch("aaa","aa",false);
        isMatch("aa", "a*",true);
        isMatch("aa", ".*",true);
        isMatch("ab", ".*",true);
        isMatch("aab", "c*a*b",true);
        isMatch("aaa", "ab*ac*a", true);
        isMatch("aaa", "a*a", true);
        isMatch("aaa", "ab*a*c*a", true);
    }

    private void isMatch(String s, String p, boolean expected) {
        RegularExpressionMatching solution = new RegularExpressionMatching();
        assertEquals(solution.isMatchSolutionByMySelf(s,p), expected);

    }

}