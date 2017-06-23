package com.algos.practice.leetcode.hard;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/6/17.
 */
public class WordBreakIITest {

    WordBreakII solution = new WordBreakII();

    @Test
    public void wordBreak() throws Exception {
        String s = "catsanddogs";
        List<String> dict = Arrays.asList("cat", "cats", "and", "dogs", "sand");
        List<String> ans = solution.wordBreak(s, dict);
        System.out.println(ans);
    }

}