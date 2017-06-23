package com.algos.practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cdeshpande on 6/21/17.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        char [] wordChars = word.toCharArray();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                boolean result = exist(board, i, j, wordChars, 0);
                if(result) {
                    return result;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int row, int coln,char [] wordChars, int charIndex) {
        if(board[row][coln] != wordChars[charIndex]) {
            return false;
        }

        if(charIndex == wordChars.length - 1) {
            return true;
        }

        boolean result = false;
        char c = board[row][coln];
        board[row][coln] = '#';
        if(row > 0) {
            result = exist(board, row - 1, coln, wordChars, charIndex + 1);
            if(result)
                return result;
        }

        if(row < board.length - 1) {
            result = exist(board, row + 1, coln, wordChars, charIndex + 1);
            if(result)
                return result;
        }

        if(coln > 0) {
            result = exist(board, row, coln - 1, wordChars, charIndex + 1);
            if(result)
                return result;
        }

        if(coln < board[0].length - 1) {
            result = exist(board, row, coln + 1, wordChars, charIndex + 1);
            if(result)
                return result;
        }
        board[row][coln] = c;
        return result;


    }


}
