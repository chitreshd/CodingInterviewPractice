package com.algos.practice.leetcode.medium;

import java.util.*;

/**
 * Problem:
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log","cog"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 UPDATE (2017/1/20):
 The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code
 definition to get the latest changes.
 */
public class WordLadder {

    private static final char [] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        Set<String> wordDict = new HashSet<>(wordList);
        //wordDict.add(endWord);
        int distance = 1;

        while(!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for(String each : reached) {
                List<String> transformations = getAllValidTransformations(each, wordDict);
                toAdd.addAll(transformations);
                wordDict.removeAll(transformations);
            }
            distance++;
            if(toAdd.size() == 0) {
                return 0;
            }
            reached = toAdd;
        }
        return distance;


    }
    public int ladderLength_my(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        if(!dictionary.contains(endWord))
            return 0;

        Queue<Tuple> queue = new ArrayDeque<>();
        queue.add(new Tuple(beginWord, 1));
        Set<String> visited = new HashSet<>();

        while(!queue.isEmpty()) {
            Tuple curr = queue.remove();
            List<String> transformations = getAllValidTransformations(curr.word, dictionary);
            for(String transformation : transformations ) {
                if(transformation.equals(endWord)) {
                    return curr.length + 1;
                }
                if(!visited.contains(transformation)) {
                    queue.add(new Tuple(transformation, curr.length + 1));
                }
            }


        }

        return 0;
    }

    protected List<String> getAllValidTransformations(String word, Set<String> dictionary) {
        char [] temp = word.toCharArray();
        List<String> transformations = new ArrayList<>();

        for(int i = 0; i < word.length(); i++) {
            for(char c : ALPHABET) {
                char orig = temp[i];
                temp[i] = c;
                String tempWord = new String(temp);
                if(!tempWord.equals(word) && dictionary.contains(tempWord)) {
                    transformations.add(tempWord);
                }
                temp[i] = orig;
            }
        }

        return transformations;
    }

    public static class Tuple {
        String word;
        int length;

        Tuple(String word, int ladderLength) {
            this.word = word;
            this.length = ladderLength;
        }
    }

}
