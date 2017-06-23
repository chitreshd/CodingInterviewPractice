package com.algos.practice.leetcode.hard;

import java.util.Map;

/**
 * Created by cdeshpande on 6/18/17.
 * Problem
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 Example: SUNNY, SNOWY, min distance = 3

 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        if(word1 == null || word1.isEmpty()) {
            return word2.length();
        }

        if(word2 == null || word2.isEmpty()) {
            return word1.length();
        }

        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();
        return calcMinDistance(word1, word1.length() - 1, word2, word2.length() - 1);
    }

    /**
     *
     * @param word1
     * @param
     * @param word2
     * @param
     * @param
     * @return
     */
    protected int calcMinDistanceWithTabulation(String word1, String word2) {

        //results: 2D array for storing intermediate results.
        int[][] results = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 0; i <= word1.length(); i++) {
            results[i][0] = i;
        }

        for(int j = 0; j <= word2.length(); j++) {
            results[0][j] = j;
        }

        //i: number of words to be processed for word1
        for(int i = 1; i <= word1.length(); i++) {

            //j: number of words to be processed for word1
            for(int j = 1; j <=word2.length(); j++) {
                int insert = 1 + results[i - 1][j];
                int delete = 1 + results[i][j - 1];
                int costOfSubs = (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1) + results[i - 1][j - 1];

                int minDist = Math.min(insert, Math.min(delete,costOfSubs));
                results[i][j] = minDist;
            }
        }

        return results[word1.length()][word2.length()];
    }

    /**
     *
     * @param word1
     * @param i: ith index for word1, hence the base case is -1, as -1 will represent before start
     * @param word2
     * @param j: jth index for word2, hence the base case is -1, as -1 will represent before start
     * @return
     */
    protected int calcMinDistance(String word1, int i, String word2, int j) {
        if(i < 0) {
            // j is index, but the edits will be represented by length. hence +1
            return j + 1;
        }

        if(j < 0) {
            // i is index, but the edits will be represented by length. hence +1
            return i + 1;
        }

        int subsCost = (word1.charAt(i) == word2.charAt(j) ? 0 : 1);

        int insert = 1 + calcMinDistance(word1, i, word2, j - 1);
        int delete = 1 + calcMinDistance(word1, i - 1, word2, j);
        int subs   = subsCost + calcMinDistance(word1, i - 1, word2, j - 1);

        return Math.min(insert, Math.min(delete, subs));
    }

    /**
     *
     * @param word1
     * @param i: ith index for word1, hence the base case is -1, as -1 will represent before start
     * @param word2
     * @param j: jth index for word2, hence the base case is -1, as -1 will represent before start
     * @return
     */
    protected int calcMinDistanceWithMemoization(String word1, int i, String word2, int j, Map<String, Integer> results) {
        String key = getKey(i,j);
        if(results.containsKey(key))
            return results.get(key);

        if(i < 0) {
            // j is index, but the edits will be represented by length. hence +1
            results.put(key, j + 1);
            return j + 1;
        }

        if(j < 0) {
            // i is index, but the edits will be represented by length. hence +1
            results.put(key, i + 1);
            return i + 1;
        }

        int subsCost = (word1.charAt(i) == word2.charAt(j) ? 0 : 1);

        int delete = 1 + calcMinDistance(word1, i, word2, j - 1);
        int insert = 1 + calcMinDistance(word1, i - 1, word2, j);
        int subs   = subsCost + calcMinDistance(word1, i - 1, word2, j - 1);

        int minDist = Math.min(insert, Math.min(delete, subs));
        results.put(key, minDist);
        return minDist;
    }

    private String getKey(int i, int j) {
        return String.format("%s_%s",i,j);
    }



}

