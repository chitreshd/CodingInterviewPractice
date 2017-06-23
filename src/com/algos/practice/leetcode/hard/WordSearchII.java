package com.algos.practice.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cdeshpande on 6/7/17.
 *
 * Problem:
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 Return ["eat","oath"].

 Hint: Trie
 Solution:
 1. Create Trie from given list of words
 2. Iterate the board, backtracking (dfs) at every cell using trie.
 Optimizations:
 a. Since searching in array is faster than hashmap, we use leverage info that all chars
 will be lowercase.
 b. Instead of storing a value for each trie node, we can only store word for nodes corresponding to a word.
 */
public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = createTrie(words);
        List<String> result = new ArrayList<>();
        searchInBoardForWords(board, root, result);
        // dedupe
        Set<String> resultSet = new HashSet<>(result);
        return new ArrayList<>(resultSet);
    }

    private void searchInBoardForWords(char[][] board, TrieNode root, List<String> result) {

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(i,j,board,root, result);
            }
        }
    }

    private void dfs(int i, int j, char[][] board, TrieNode parent, List<String> result) {
        char c = board[i][j];
        // if the cell is already visited OR
        // this char is not available in this trie branch
        if(c == '#' || parent.children[c - 'a'] == null) {
            return;
        }

        // found char in trie branch.
        TrieNode curr = parent.children[c - 'a'];

        // check for word completion
        if(curr.word != null)
            result.add(curr.word);

        // mark visited
        board[i][j] = '#';

        if(i > 0) {
            // up
            dfs(i - 1,j,board,curr,result);
        }
        if(i < board.length - 1) {
            // down
            dfs(i + 1,j,board,curr,result);
        }
        if(j > 0) {
            // left
            dfs(i,j - 1,board,curr,result);
        }
        if(j < board[0].length - 1) {
            // right
            dfs(i,j + 1,board,curr,result);
        }

        // restore the char in the board
        board[i][j] = c;

    }

    private TrieNode createTrie(String[] words) {
        TrieNode root = new TrieNode();

        for(String word : words) {
            char [] wordChars = word.toCharArray();
            TrieNode curr = root;
            for(int i = 0; i < wordChars.length; i++) {
                char c = wordChars[i];
                if(curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }

        return root;
    }

    private static class TrieNode {
        TrieNode [] children = new TrieNode[26];
        String word;

    }
}
