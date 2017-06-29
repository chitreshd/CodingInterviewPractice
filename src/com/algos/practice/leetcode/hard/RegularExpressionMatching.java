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

    /**
     * Following solution uses dynamic programming - tabulation method.
     * Idea:
     * Let p be pattern and s be text to be matched and j and i to be the
     * pointers/indexes for each of them respectively.
     * Also consider a boolean array dp where rows represent each char in s
     * and columns represent each char in j. so dp[i][j] is match between s till i and p till j.
     * We need to go to the end of the pattern and string to determine the match.
     * Why can't i fail fast? Consider s = y and p = x*y now s[0] != p[0], if we fail fast it
     * would be wrong because pattern says: 0 or more character of x.
     * Thus we need to carry forward the previously calculated results and move forward.
     *
     * if p[j] == s[i] || p[j] == '.':
     *      dp[i][j] = dp[i-1][j-1]
     * else if p[j] == '*':
     *      dp[i][j] = dp[i][j - 2] // assumes 0 occurrences of x*
     *      if p[j - 1] == s[i] || p[j - 1] == '.' // 1 or more occurrences
     *          dp[i][j] = dp[i][j] | dp[i - 1][j] // 1a: explanation below
     *      else:
     *          dp[i][j] = false;
     *
     * 1a:
     *  Consider p = xa* and s = xaa now for i = 2, j = 2, p[2] == '*'
     *  and p[j-1] i.e. p[1] == s[2] since, there is a match we would rely or previous results.
     *  We would like to check if xa* (p) matches xa (s). Hence i - 1, j as indexes.
     *
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatchSolutionByMySelf(String text, String pattern) {
        char s [] = text.toCharArray();
        char p [] = pattern.toCharArray();

        // since dp[0][0] is start state we need length + 1 for rows and columns.
        boolean dp[][] = new boolean[s.length + 1][p.length + 1];
        dp[0][0] = true;

        // initialize 0th row
        for(int j= 1; j <= p.length; j++) {
            if(p[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }

        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {

                if(p[j - 1] == '.' || p[j - 1] == s[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2];

                    if(p[j - 2] == '.' || p[j - 2] == s[i - 1]) {
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                    }

                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length][p.length];
    }
    /**
     * Following solution is buggy because it fails fast.
     * A pattern and string has to be checked till the end to determine if it matches or not.
     * Below method tries to fail fast, which is wrong.
     * @param s
     * @param p
     * @return
     */
    public boolean isMatchSolutionByMySelfBuggy(String s, String p) {
        int si = 0;
        int pi = 0;
        char lastCharMatched = ' ';

        while(si < s.length() && pi < p.length()) {
            if( match(s.charAt(si), p.charAt(pi)) ) {
                //perfect match
                lastCharMatched = p.charAt(pi);
                pi++;
                si++;

            } else if( match(s.charAt(si), lastCharMatched) && (p.charAt(pi) == '*')) {
                pi++;
                si++;
            } else if( match(s.charAt(si), lastCharMatched) && (p.charAt(pi - 1) == '*')) {
                si++;
                /*while(si < s.length() && match(s.charAt(si), lastCharMatched)) { // s = aaa p = a*
                    si++;
                }
                pi++;*/
                //si++;
            } else if( s.charAt(si) != p.charAt(pi) && (pi < (p.length() - 1) && p.charAt(pi + 1) == '*')) {
                pi +=2;

            } else {
                return false;
            }

        }


        /*if(si == s.length() && ( pi == p.length() || ( pi == p.length() - 1 && p.charAt(pi) == '*'))) {
            return true;
        }*/
        return ( si == s.length() && pi == p.length() );
    }

    private boolean match(char s, char p) {
        return (s == p || p == '.');
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
