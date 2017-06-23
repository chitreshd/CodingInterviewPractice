package com.algos.practice.leetcode.hard;

/**
 * Created by cdeshpande on 6/9/17.
 */
public class RegularExpressionMatching {

    public boolean isMatchSolutionFromLeetCode(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }


    public boolean isMatchSolutionFromLeetCode1(String s, String p){

        int m = s.length() + 1;
        int n = p.length() + 1;
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();

        boolean [][] r = new boolean[m][n];
        r[0][0] = true;

        for(int j = 2; j < n; j++) {
            if(pc[j - 1] == '*') {
                r[0][j] = r[0][j - 2];
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(sc[i-1] == pc[j-1] || pc[j-1] == '.') {
                    // carry the status of previous word char match, forward. If the previous match failed, we
                    // want to carry it till the last cell, because thats where th'e final decision will be tested for.
                    r[i][j] = r[i - 1][j-1];
                } else if(pc[j-1] == '*') {

                    if(sc[i - 1] == pc[j-2] || pc[j-2] == '.') {
                        // previous character in pattern represented by 'j-2' is equal to current (i-1) character
                        // from s or if previous pattern char is a wild card '.'
                        r[i][j] = r[i][j-2] || r[i-1][j];
                    } else {
                        r[i][j] = r[i][j-2];
                    }
                } /*else {
                    // is it redundant?
                    r[i][j] = false;
                }*/
            }
        }
        return r[m-1][n-1];
    }

}
