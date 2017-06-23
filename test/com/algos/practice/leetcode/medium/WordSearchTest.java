package com.algos.practice.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdeshpande on 6/21/17.
 */
public class WordSearchTest {

    WordSearch solve = new WordSearch();

    @Test
    public void exist() throws Exception {
        char [][] board = new char[][]
                {
                        {'a'}
                };
        assertTrue(solve.exist(board, "a"));
        board = new char[][]
                {
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}
                };
        assertTrue(solve.exist(board, "ABCCED"));
        board = new char[][]
                {
                        {'a','a'}
                };
        assertFalse(solve.exist(board, "aaa"));
    }

}