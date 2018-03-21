package com.algos.practice.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public String minWindowRevision(String s, String t) {
        Pattern p = new Pattern(t);
        int left = 0, right = 0;
        String currWindow = null;
        String minWindow = null;
        while(right < s.length()) {

            while(!p.found() && left < s.length()) {
                p.add(s.charAt(left));
                left++;
            }

            while(p.found() && right <= left) {
                currWindow = s.substring(right, left);
                if(minWindow == null || minWindow.length() > currWindow.length()) {
                    minWindow = currWindow;
                }
                p.remove(s.charAt(right));
                right++;
            }

            if(left >= s.length()) {
                break;
            }
        }

        return minWindow == null ? "" : minWindow;

    }

    public static class Pattern {
        private Map<Character, Integer> freqMap;

        //private int foundFlag;
        /*
        Since int doesnt account for integers and CAPs alphabet, moving to hashset
        a hashset has to be empty for found to be true
        when freq of c > 0: enter into hashset
        when freq of c < 0: remove from hashset
         */
        private Set<Character> set;

        public Pattern(String patternStr) {
            set = new HashSet<>();
            freqMap = new HashMap<>();
            for(char c : patternStr.toCharArray()) {
                int currCount = freqMap.containsKey(c) ? freqMap.get(c) : 0;
                freqMap.put(c, currCount + 1);
                set.add(c);
                /*int bit = c - 'A';
                foundFlag |= 1 << bit;*/
            }
        }


        public void add(char ch) {
            if(freqMap.containsKey(ch)) {
                int currCount = freqMap.get(ch);
                currCount--;
                if(currCount <= 0) {
                    /*int bit = ch - 'a';
                    foundFlag &= ~(1 << bit);*/
                    set.remove(ch);
                }
                freqMap.put(ch, currCount);
            }
        }

        public void remove(char ch) {
            if(freqMap.containsKey(ch)) {
                int currCount = freqMap.get(ch);
                currCount++;
                if(currCount > 0) {
                    /*int bit = ch - 'a';
                    foundFlag |= (1 << bit);*/
                    set.add(ch);
                }
                freqMap.put(ch, currCount);
            }
        }

        public boolean found() {
            return set.isEmpty();
        }
    }

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
        System.out.println("A - a: " + (long)('1' - 'A'));
    }
}
