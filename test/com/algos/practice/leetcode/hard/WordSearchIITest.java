package com.algos.practice.leetcode.hard;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/7/17.
 */
public class WordSearchIITest {
    @Test
    public void findWords() throws Exception {
        char [][] board = new char[][]
                {
                        {'o','a','a','n'},
                        {'e','t','a','e'},
                        {'i','h','k','r'},
                        {'i','f','l','v'}
                };
        String[] words = new String[] {"oath","pea","eat","rain"};
        List<String> found = new WordSearchII().findWords(board,words);
        System.out.println(found);
        assertTrue(found.containsAll(Arrays.asList("oath", "eat")));

        board = new char[][]
                {
                        {'a','a'}
                };
        words = new String[] {"aaa"};
        found = new WordSearchII().findWords(board,words);
        System.out.println(found);
        assertTrue(found.isEmpty());
    }

}