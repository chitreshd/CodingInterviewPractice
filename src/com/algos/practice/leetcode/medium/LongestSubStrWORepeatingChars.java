package com.algos.practice.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cdeshpande on 7/29/17.
 *
 * Problem:
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


 */
public class LongestSubStrWORepeatingChars {

    public int lengthOfLongestSubstring(String s) {

        // "pwwkew"
        Pair longest = new Pair();
        longest.end = -1;
        int start = 0;
        //int end = 0;
        Set<Character> seen = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (seen.contains(c)) {
                char startChar = s.charAt(start);
                seen.remove(startChar);
                start++;
            }
            seen.add(c);
            if((i - start + 1) > longest.size()) {
                longest.start = start;
                longest.end = i;
            }
        }

        return longest.size();

    }

    public static class Pair {
        int start;
        int end;

        public int size() {
            return end - start + 1;// +1 because end is inclusive
        }
    }

}
