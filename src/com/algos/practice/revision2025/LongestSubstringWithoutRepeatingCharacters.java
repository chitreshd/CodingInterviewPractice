package com.algos.practice.revision2025;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 * 
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * Constraints:
 * - 0 <= s.length <= 5 * 10^4
 * - s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    
    /**
     * Finds the length of the longest substring without repeating characters.
     * 
     * @param s the input string
     * @return the length of the longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        /**
         * • Use two pointers: left and right (or start and end)
         *   • Move the right pointer to expand the window
         *   • When you encounter a repeat, move the left pointer to slide the window
         *   • Keep track of characters in the current window and remove characters as the left pointer moves
         */
        if (s == null || s.length() == 0 ) return 0;

        Set<Character> window = new HashSet<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0 ; right < s.length(); right++) {
            char c = s.charAt(right);

            while (window.contains(c)) {
                window.remove(s.charAt(left));
                left++;
            }

            // Add character to window
            window.add(c);

            // Update max len
            maxLen = Math.max(maxLen, right - left + 1); // +1 because right is inclusive
        }
        return maxLen;
    }

}