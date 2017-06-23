package com.algos.practice.leetcode.hard;

/**
 * Created by cdeshpande on 6/10/17.
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] charCounter = new int[128]; // this will only work for ASCII strings. For unicode, bump this to 256.
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, minLenStart = 0, charsToBeFound = t.length();

        char [] scs = s.toCharArray();
        char [] tcs = t.toCharArray();
        // initialize the charCounter with char counts from string t
        for(char tc : tcs) {
            charCounter[tc]++;
        }

        // loop for tail of the window.
        while(end < scs.length) {


            // decrement the respective char counter. if the char was present in t, the count should be 0
            // or else negative
            if(charCounter[scs[end]] > 0) {
                charsToBeFound--;
            }
            charCounter[scs[end]]--;
            end++;

            // if we have found all the chars from t in s in current window, then charsToBeFound will be 0.
            while(charsToBeFound == 0) {

                if((end - start) < minLen) {
                    minLenStart = start;
                    minLen = (end - start);
                }

                // try to reduce the window by moving start counter
                charCounter[scs[start]]++;
                if(charCounter[scs[start]] > 0) {
                    charsToBeFound++;
                }
                start++;

            }

        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLenStart, minLenStart + minLen);

    }

    public static void main(String[] args) {
        new MinimumWindowSubstring().minWindow("","");
    }
}
