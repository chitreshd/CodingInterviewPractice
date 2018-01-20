package com.algos.practice.leetcode.medium;

import java.util.*;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wd = new HashSet<>(wordDict);
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        int result = doWordBreak(s, 0, wd, dp);
        return result == 1;
    }

    protected int doWordBreak(String s, int startIndex, Set<String> wordDict, int [] dp) {
        if(startIndex == s.length()) {
            // reached end of string; base case
            return 1;
        }

        if(dp[startIndex] != -1) {
            return dp[startIndex];
        }

        for(int i = startIndex; i < s.length(); i++) {
            String leftPart = s.substring(startIndex, i + 1);
            if(wordDict.contains(leftPart)) {
                int rightPartResult = doWordBreak(s, i + 1, wordDict, dp);
                if(rightPartResult == 1) {
                    dp[startIndex] = 1;
                    return dp[startIndex];
                }
            }

        }

        dp[startIndex] = 0;
        return dp[startIndex];
    }

}
