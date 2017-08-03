package com.algos.practice.leetcode.medium;

/**
 * Created by cdeshpande on 8/2/17.
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"

 Approach: Check longest palindrome at each center.
 A center can be a letter for an odd length palindrome
 or it can be between letters for an even length palindrome.
 # of centers = 2n - 1. # of operations around each center = n
 complexity: 2n - 1 * n nearly = O(n^2)
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int left = 0; int right = 0;
        int max = 0;

        for(int i = 0; i < s.length(); i++) {
            int odd = expandAroundCenter(s, i, i);
            int even = expandAroundCenter(s, i, i + 1);
            if(odd > max) {
                max = odd;
                left = i - odd / 2;
                right = i + odd / 2;
            }
            if(even > max) {
                max = even;
                left = 1 + i - even / 2;
                right = i + even / 2;
            }

        }
        return s.substring(left, right + 1);
    }



    protected int expandAroundCenter(String s, int left, int right) {

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
