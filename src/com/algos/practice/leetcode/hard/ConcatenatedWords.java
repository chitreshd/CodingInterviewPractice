package com.algos.practice.leetcode.hard;

import java.util.*;

/**
 * Created by cdeshpande on 6/6/17.
 * Problem:
 * Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.

 A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

 Example:
 Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

 Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

 Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 */
public class ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String> output = new ArrayList<>();

        if(words == null || words.length == 0){
            return output;
        }

        Map<String, Integer> result = new HashMap<>();
        List<String> wordList = Arrays.asList(words);
        Set<String> dict = new HashSet<>(wordList);

        for(String word : wordList) {
            int i = calculateNumOfSubWordsGreedy(word, dict, result);
            if(i > 1){
                output.add(word);
            }
        }

        return output;

    }

    private int calculateNumOfSubWordsGreedy(String s, Set<String> dict, Map<String, Integer> result) {

        if(result.containsKey(s)){
            return result.get(s);
        }

        int subWords = dict.contains(s) ? 1 : 0;

        for(int i = 0; i < s.length() - 1; i++) {
            String left = s.substring(0, i + 1);
            if(dict.contains(left)) {
                int rightSideResult = calculateNumOfSubWordsGreedy(s.substring(i + 1), dict, result);
                if(rightSideResult > 0) {
                    subWords = rightSideResult + 1;
                    break; // greedy
                }
            }
        }

        result.put(s, subWords);
        return result.get(s);

    }

}
