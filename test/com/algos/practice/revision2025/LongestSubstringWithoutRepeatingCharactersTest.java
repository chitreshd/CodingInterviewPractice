package com.algos.practice.revision2025;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for LongestSubstringWithoutRepeatingCharacters
 */
public class LongestSubstringWithoutRepeatingCharactersTest {
    
    private LongestSubstringWithoutRepeatingCharacters solution;
    
    @BeforeEach
    void setUp() {
        solution = new LongestSubstringWithoutRepeatingCharacters();
    }
    
    @Test
    void testExample1() {
        // Input: s = "abcabcbb"
        // Expected Output: 3
        // Explanation: The answer is "abc", with the length of 3.
        String s = "abcabcbb";
        int expected = 3;
        int actual = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }
    
    @Test
    void testExample2() {
        // Input: s = "bbbbb"
        // Expected Output: 1
        // Explanation: The answer is "b", with the length of 1.
        String s = "bbbbb";
        int expected = 1;
        int actual = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }
    
    @Test
    void testExample3() {
        // Input: s = "pwwkew"
        // Expected Output: 3
        // Explanation: The answer is "wke", with the length of 3.
        String s = "pwwkew";
        int expected = 3;
        int actual = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }
    
    @Test
    void testEmptyString() {
        // Input: s = ""
        // Expected Output: 0
        String s = "";
        int expected = 0;
        int actual = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }
    
    @Test
    void testSingleCharacter() {
        // Input: s = "a"
        // Expected Output: 1
        String s = "a";
        int expected = 1;
        int actual = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }
    
    @Test
    void testAllUniqueCharacters() {
        // Input: s = "abcdef"
        // Expected Output: 6
        String s = "abcdef";
        int expected = 6;
        int actual = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }
    
    @Test
    void testWithSpaces() {
        // Input: s = "a b c d"
        // Expected Output: 7 (all characters are unique including spaces)
        String s = "a b c d";
        int expected = 3;
        int actual = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }
    
    @Test
    void testWithNumbers() {
        // Input: s = "abc123def"
        // Expected Output: 9 (all characters are unique)
        String s = "abc123def";
        int expected = 9;
        int actual = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }
    
    @Test
    void testWithSpecialCharacters() {
        // Input: s = "a!@#b"
        // Expected Output: 5 (all characters are unique)
        String s = "a!@#b";
        int expected = 5;
        int actual = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }
    
    @Test
    void testRepeatingAtEnd() {
        // Input: s = "abcdefgg"
        // Expected Output: 6 (substring "abcdefg" has length 6, but "g" repeats)
        String s = "abcdefgg";
        int expected = 7;
        int actual = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }
    
    @Test
    void testRepeatingAtStart() {
        // Input: s = "aabcdef"
        // Expected Output: 6 (substring "abcdef" has length 6)
        String s = "aabcdef";
        int expected = 6;
        int actual = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }
    
    @Test
    void testComplexCase() {
        // Input: s = "dvdf"
        // Expected Output: 3 (substring "vdf" has length 3)
        String s = "dvdf";
        int expected = 3;
        int actual = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }
}